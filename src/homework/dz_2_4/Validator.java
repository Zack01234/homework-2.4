package homework.dz_2_4;

public class Validator {

    public static boolean check(String login, String password, String confirmPassword) {
        try {
            validate(login, password, confirmPassword);
        } catch (WrongLoginException | WrongPasswordException i) {
            System.out.println(i.getMessage());
            return false;
        }
        return true;
    }

    private static final String VALID_CHARACTERS = "0123456789._abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private Validator() {

    }

    private static void validate(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (login == null || login.length() > 20) {
            throw new WrongLoginException("Логин должен быть меньше или равен 20 символам");
        }
        if (password == null || password.length() >= 20) {
            throw new WrongLoginException("Пароль не должен быть больше 20 символов");
        }
        if (confirmPassword == null || !password.equals(confirmPassword)) {
            throw new WrongPasswordException("Пароли должны совпадать");
        }
        validateCharacters(login, true);
        validateCharacters(password, false);
    }

    private static void validateCharacters(String s, boolean isLogin) throws WrongPasswordException, WrongLoginException {
        for (int i = 0; i < s.length(); i++) {
            if (!VALID_CHARACTERS.contains(String.valueOf(s.charAt(i)))) {
                if (isLogin) {
                    throw new WrongLoginException("Логин содержит некорректный символ " +
                            s.charAt(i) + " !");
                } else {
                    throw new WrongPasswordException("Пароль содержит некорректный символ " +
                            s.charAt(i) + " !");
                }
            }
        }
    }
}
