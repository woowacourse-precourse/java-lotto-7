package lotto.view;

public class OutputView {
    private static OutputView instance;
    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
    }
    public void printMessage(String message) {
        System.out.println(message);
    }
}
