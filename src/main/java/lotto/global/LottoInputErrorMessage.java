package lotto.global;

public enum LottoInputErrorMessage {
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTO_LIST_EMPTY_ERROR("로또 목록은 비어있을 수 없습니다."),
    LOTTO_BONUS_NUMBER_RANGE_ERROR("보너스 번호는 %d부터 %d 사이여야 합니다."),
    LOTTO_BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    public static final String ERROR = "[ERROR]";
    private static final String PREFIX = "로또 번호는 ";
    private static final String SUFFIX = "다시 입력해주세요.";

    private final String message;

    LottoInputErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return String.format("%s %s %s %s", ERROR, PREFIX, message, SUFFIX);
    }

    public String getFormattedMessage(int min, int max) {
        return String.format("%s %s %s %s", ERROR, PREFIX, String.format(message, min, max), SUFFIX);
    }
}