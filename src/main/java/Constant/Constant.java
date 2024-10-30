package Constant;

public class Constant {
    public enum win {
        THREE, FOUR, FIVE, FIVEANDBONUS, SIX
    }
    public class MessageConstant {
        public static final String INPUT_PURCHASE_PROMPT = "구입금액을 입력해 주세요.";
        public static final String INPUT_NUMBER_PROMPT = "당첨 번호를 입력해 주세요.";
        public static final String INPUT_BONUS_PROMPT = "보너스 번호를 입력해 주세요.";
        public static final String OUTPUT_PROMPT = "개를 구매했습니다.";
    }
    public class GameRuleConstant {
        public static final String INPUT_DELIMITER = ",";
        public static final int LOTTO_RANGE_MIN = 1;
        public static final int LOTTO_RANGE_MAX = 45;
        public static final int INPUT_LOTTO_RANGE = 6;
        public static final int INPUT_BONUS_RANGE = 1;
        public static final String THREE_MATCHES = "3개 일치 (5,000원) - ";
        public static final String FOUR_MATCHES = "4개 일치 (50,000원) - ";
        public static final String FIVE_MATCHES = "5개 일치 (1,500,000원) - ";
        public static final String FIVE_AND_BONUS_MATCHES = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
        public static final String SIX_MATCHES = "6개 일치(2,000,000,000) - ";
    }
    public class ErrorConstant {
        public static final String OUTPUT_ERROR = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
        public static final String COUNT_MISMATCH_ERROR = "[ERROR] 로또 번호는 6개여야 합니다.";
        public static final String BOUNS_COUNT_MISMATCH_ERROR ="[ERROR] 보너스 번호는 1개여야 합니다.";

    }
}
