package lotto;

public class LottoMachine {
    InputView inputView = new InputView();

    public void playMachine() {
        Purchase purchase = makePurchase();
    }

    private Purchase makePurchase() {
        try {
            Purchase purchase = new Purchase(inputView.askPurchase());
            return purchase;
        }catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return makePurchase();
        }
    }
}
