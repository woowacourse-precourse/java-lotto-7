package lotto;

public class constants {
    public static class Request_Messages{
        public static final String INPUT_TOTAL_AMOUNT = "구입금액을 입력해 주세요.";
        public static final String OUTPUT_TOTAL_COUNT = "개를 구매했습니다.";
        public static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
        public static final String INPUT_BONUS_WINNING_NUMBER = "보너스 번호를 입력해 주세요.";
        public static final String SUMMARY = "당첨 통계\n---\n";
    }
    public static class Error_Messages{
        public static final String INPUT_NOT_POSITIVE_INT = "[ERROR] 값은 양수여야 합니다.";
        public static final String INPUT_TOTAL_AMOUNT_NOT_LARGER_THAN_1000 = "[ERROR] 구입 최소 금액은 1000원입니다.";
        public static final String INPUT_ERROR = "[ERROR] 입력값에 오류가 있습니다.";
        public static final String LOTTO_COUNT_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
        public static final String NUMBER_RANGE_ERROR = "[ERROR] 번호는 1~45 이여야 합니다.";
        public static final String DUPLICATE_ERROR = "[ERROR] 번호는 중복되면 안됩니다.";
    }
}
