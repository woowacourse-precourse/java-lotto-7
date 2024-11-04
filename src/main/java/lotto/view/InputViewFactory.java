package lotto.view;

public class InputViewFactory {

    public static final String AMOUNT_INPUT_REQUEST_MESSAGE = "구입금액을 입력해 주세요.%n";
    public static final String WINNING_NUMBER_INPUT_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.%n";
    public static final String BONUS_NUMBER_INPUT_REQUEST_MESSAGE = "%n보너스 번호를 입력해 주세요.%n";
    public static final String INVALID_INPUT_VIEW_EXCEPTION = "[ERROR] 존재하지 않는 InputView 를 요청하셨습니다.";

    private InputViewFactory() {
    }

    public static InputView createInputViewOf(InputViewType type) {
        if (type.equals(InputViewType.AMOUNT)) {
            return new InputView(AMOUNT_INPUT_REQUEST_MESSAGE);
        }

        if (type.equals(InputViewType.WINNING_NUMBER)) {
            return new InputView(WINNING_NUMBER_INPUT_REQUEST_MESSAGE);
        }

        if (type.equals(InputViewType.BONUS_NUMBER)) {
            return new InputView(BONUS_NUMBER_INPUT_REQUEST_MESSAGE);
        }

        throw new IllegalArgumentException(INVALID_INPUT_VIEW_EXCEPTION);
    }
}
