package lotto;

public class Controller {

    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();
    }

    private static int getPurchaseAmount() {
        while (true) {
            String input = InputView.readPurchaseAmount();
            try {
                InputValidator.validatePurchaseAmount(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
