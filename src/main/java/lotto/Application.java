package lotto;


public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        Budget budget = inputView.readBudget();
    }
}
