package lotto;

public class LottoCount {
    public int getLottoCount() {
        InputView inputView = new InputView();

        return inputView.getLottoPurchaseAmount() / 1000;
    }
}
