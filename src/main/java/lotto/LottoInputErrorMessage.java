package lotto;

public enum LottoInputErrorMessage {
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이여야 합니다."),
    LOTTO_NUMBER_DUPLICATE_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTO_LIST_EMPTY_ERROR("[ERROR] 로또 목록은 비어있을 수 없습니다.");

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
}