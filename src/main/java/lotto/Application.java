package lotto;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int money;

        while (true) {
            try {
                money = getMoney();
                exception(money);
                break;
            } catch (IllegalArgumentException error) {
                System.out.println("[ERROR]" + error.getMessage());
            }
        }
    }
}
