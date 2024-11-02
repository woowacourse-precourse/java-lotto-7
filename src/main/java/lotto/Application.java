package lotto;

public class Application {
    public static void main(String[] args) {

        UserInput number = new UserInput();

        while (true) {
            try {
                number.purchaseAmountInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
