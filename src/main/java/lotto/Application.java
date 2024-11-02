package lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input(new InputValidator());

        Lotto winNumberLotto = input.getWinNumberLotto();
        WinLotto winLotto = input.getBonusNumber(winNumberLotto);
//        Integer amountWithMessage = input.getAmountWithMessage();
    }
}
