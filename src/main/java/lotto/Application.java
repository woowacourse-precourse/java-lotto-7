package lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input(new InputValidator());

        Lotto winNumberLotto = input.getWinNumberLotto();
//        Integer bonus = input.getBonusNumberWithMessage();
//        Integer amountWithMessage = input.getAmountWithMessage();
    }
}
