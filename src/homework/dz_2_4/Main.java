package homework.dz_2_4;

public class Main {
    public static void main(String[] args) {
        boolean results = Validator.check("java_skypro.go", "D_1hWiKjjP_9", "D_1hWiKjjP_9");
        if (results) {
            System.out.println("Логин и пароль корректные");
        } else {
            System.out.println("Некорректные данные");
        }
    }
}
