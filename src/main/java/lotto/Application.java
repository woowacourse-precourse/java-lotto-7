package lotto;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        LottoCount lottoCount = new LottoCount();

        try {
            inputView.getLottoPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        inputView.getWinningNumber();
        inputView.getBonusNumber();
        lottoCount.getLottoCount();
    }
}