package lotto.io.view;

public class View {
    private static final View INSTANCE = new View();
    private static final InputView INPUT_VIEW = InputView.getInstance();
    private static final LottoBuyView LOTTO_BUY_VIEW = LottoBuyView.getInstance();
    private static final ResultView RESULT_VIEW = ResultView.getInstance();

    private View() {
    }

    public static View getInstance() {
        return INSTANCE;
    }

    public InputView getInputView() {
        return INPUT_VIEW;
    }

    public LottoBuyView getLottoBuyView() {
        return LOTTO_BUY_VIEW;
    }

    public ResultView getResultView() {
        return RESULT_VIEW;
    }
}
