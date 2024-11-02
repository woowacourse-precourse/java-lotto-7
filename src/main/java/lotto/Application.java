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

        while (true) {
            try {
                number.winNumbersInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                number.bonusNumberInput();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
