package lotto;

public class LottoMachine {
    InputView inputView = new InputView();

    public void playMachine() {
        Purchase purchase = new Purchase(inputView.askPurchase());
    }
}
