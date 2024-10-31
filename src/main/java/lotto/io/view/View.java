package lotto.io.view;

public class View {
    private static final View INSTANCE = new View();
    private static final InputView INPUT_VIEW = InputView.getInstance();

    private View() {
    }

    public static View getInstance() {
        return INSTANCE;
    }

    public InputView getInputView() {return INPUT_VIEW;}
}
