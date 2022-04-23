package ca.umanitoba.personalhealthcare.business;

import ca.umanitoba.personalhealthcare.objects.EmailExistException;
import ca.umanitoba.personalhealthcare.objects.EmailInvalidException;
import ca.umanitoba.personalhealthcare.objects.LoginSession;
import ca.umanitoba.personalhealthcare.objects.Member;
import ca.umanitoba.personalhealthcare.objects.NameExistsException;
import ca.umanitoba.personalhealthcare.objects.PasswordInvalidException;
import ca.umanitoba.personalhealthcare.objects.Patient;
import ca.umanitoba.personalhealthcare.objects.Profile;
import ca.umanitoba.personalhealthcare.persistence.LoginSessionPersistence;
import ca.umanitoba.personalhealthcare.persistence.LoginSessionPersistenceImp;
import ca.umanitoba.personalhealthcare.persistence.MemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeMemberPersistence;
import ca.umanitoba.personalhealthcare.persistence.fakeDb.FakeProfilePersistence;

public class AccountManagerImp implements  AccountManager {
    MemberPersistence memberPersistence;
    ProfileManager profileManager;
    LoginSessionPersistence loginSessionPersistence;

    public AccountManagerImp() {
        memberPersistence = FakeMemberPersistence.getMemberPersistence(); //TODO: create a fake persistence
        loginSessionPersistence =  LoginSessionPersistenceImp.getLoginSessionPersistence();
        profileManager = new ProfileManagerImp(FakeProfilePersistence.getProfilePersistence());
    }

    public AccountManagerImp(MemberPersistence memberPersistence) {
        this.memberPersistence = memberPersistence;
    }

    @Override
    public LoginSession authMemberLogin(String username, String password) {
        Member member = memberPersistence.getMember(username, password);
        LoginSession session = loginSessionPersistence.getLoginSession();
        session.setLogined(member != null);
        session.setMemberEmail(username);

        loginSessionPersistence.saveLoginSession(session);
        return session;
    }

    @Override
    public Member createAccount(String email, String password) throws PasswordInvalidException, EmailInvalidException, EmailExistException {
        Member newMember = new Patient(null, email, password);
        System.out.println("Create : " + email + " - " + password);

        Member createdMember = memberPersistence.createMember(newMember);

        try {
            profileManager.insertProfile(email, "Default", "", 0,0, 0, 1, 1, "");
        } catch (NameExistsException e) {
            e.printStackTrace();
            //TODO: handle errors
        }


        return createdMember;
    }
}
