package lotto.view;

public class OutputView {
    public void displayErrorMessage(Exception exception) {
        System.out.println("[ERROR] " + exception.getMessage());
    }
}
