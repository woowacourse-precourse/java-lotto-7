package lotto;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        try {
            inputView.getLottoPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        inputView.getWinningNumber();
        inputView.getBonusNumber();
    }
}