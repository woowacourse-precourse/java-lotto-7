package lotto;

public class Application {
    public static void main(String[] args) {
        Input input = new Input(new InputValidator());
        Integer amountWithMessage = input.getAmountWithMessage();
    }
}
