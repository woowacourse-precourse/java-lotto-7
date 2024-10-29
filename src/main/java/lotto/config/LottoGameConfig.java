package lotto.config;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGameConfig {

    public static int FIRST_PLACE_AMOUNT = 2_000_000_000;
    public static int SECOND_PLACE_AMOUNT = 30_000_000;
    public static int THIRD_PLACE_AMOUNT = 1_500_000;
    public static int FOURTH_PLACE_AMOUNT = 50_000;
    public static int FIFTH_PLACE_AMOUNT = 5_000;

    public static int LOTTO_PRICE_UNIT = 1_000;

    public static final int START_NUMBER = 1;
    public static final int END_NUMBER = 45;
    public static final int COUNT = 6;

    public static final String ERROR_PREFIX = "[ERROR] ";

    private final InputView inputView;
    private final OutputView outputView;

    public LottoGameConfig(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public InputView getInputView() {
        return inputView;
    }

    public OutputView getOutputView() {
        return outputView;
    }

}
