import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.levchenko.service.services.SignUpService;
import ru.levchenko.service.services.SignUpServiceImpl;

import java.util.Arrays;

public class ValidationTest {

    private static final String[] VALID_EMAILS = new String[]{"email@yahoo.com", "email-100@yahoo.com",
            "Email.100@yahoo.com", "email111@email.com", "email-100@email.net",
            "email.100@email.au", "emAil@11.com", "email@gmail.com",
            "email+100@gmail.com", "emAil-100@yahoo-test.com", "email_100@yahoo-test.CoM"};

    private static final String[] INVALID_EMAILS = new String[]{"あいうえお@example.com", "email@111",
            "email", "email@.com.my", "email123@gmail.", "email123@.com", "email123@.com.com",
            ".email@email.com", "email()*@gmAil.com", "eEmail()*@gmail.com", "email@%*.com", "email..2002@gmail.com",
            "email.@gmail.com", "email@email@gmail.com", "email@gmail.com."};
    private static final String[] VALID_LOGIN = new String[]{"agertolke","AGER","age1","agArtFSke123","14124124124"};

    private static final String[] INVALID_LOGIN = new String[]{"age,rto.lke","AGE","1()asdfsafasf","ag ArtFSke123","1412412412412452144124411414","aывфафафа","login123фф"};

    private static final String[] VALID_PASSWORD = new String[]{"age,rto.lke","ASDadfasfq12","12345678","qazwsxcde","^&^%$@ASfSA."};
    private static final String[] INVALID_PASSWORD = new String[]{"aefert","Привет123","123456789012345678","asd asd152","^&^%$@ASfSA<>."};
    private SignUpService signUpService;

    @Before
    public void setUp(){
        signUpService = new SignUpServiceImpl();
    }


    @Test
    public void emailValidationShouldBeValid(){
        Arrays.stream(VALID_EMAILS).forEach(email-> {

            System.out.println(email);
            Assert.assertTrue(signUpService.checkEmail(email));

        });

    }
    @Test
    public void emailValidationShouldBeInvalid(){
        Arrays.stream(INVALID_EMAILS).forEach(email-> {

            System.out.println(email);
            Assert.assertFalse(signUpService.checkEmail(email));

        });
    }

    @Test
    public void loginValidationShouldBeValid(){
        Arrays.stream(VALID_LOGIN).forEach(login-> {

            System.out.println(login);
            Assert.assertTrue(signUpService.checkLogin(login));

        });

    }
    @Test
    public void loginValidationShouldBeInvalid(){
        Arrays.stream(INVALID_LOGIN).forEach(login-> {

            System.out.println(login);
            Assert.assertFalse(signUpService.checkLogin(login));

        });

    }
    @Test
    public void passwordValidationShouldBeValid(){
        Arrays.stream(VALID_PASSWORD).forEach(password-> {

            System.out.println(password);
            Assert.assertTrue(signUpService.checkPassword(password));

        });

    }
    @Test
    public void passwordValidationShouldBeInvalid(){
        Arrays.stream(INVALID_PASSWORD).forEach(password-> {

            System.out.println(password);
            Assert.assertFalse(signUpService.checkPassword(password));

        });

    }





}
