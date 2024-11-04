package lotto;

public class Constants {
    public static final int TICKET_UNIT_PRICE = 1000;

    public enum RequestMessages {
        INPUT_TOTAL_AMOUNT("구입금액을 입력해 주세요."),
        OUTPUT_TOTAL_COUNT("개를 구매했습니다."),
        INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
        INPUT_BONUS_WINNING_NUMBER("보너스 번호를 입력해 주세요."),
        SUMMARY("당첨 통계\n---");

        private final String message;

        RequestMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum ErrorMessages {
        INPUT_NOT_POSITIVE_INT("[ERROR] 값은 양수여야 합니다.\n"),
        INPUT_TOTAL_AMOUNT_NOT_LARGER_THAN_1000("[ERROR] 구입 최소 금액은 1000원입니다.\n"),
        INPUT_TOTAL_AMOUNT_ERROR("[ERROR] 입력값은 1000원 단위여야 합니다.\n"),
        LOTTO_COUNT_ERROR("[ERROR] 로또 번호는 6개여야 합니다."),
        NUMBER_RANGE_ERROR("[ERROR]  로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        DUPLICATE_ERROR("[ERROR] 번호는 중복되면 안됩니다."),
        NUMBER_FORMAT_ERROR("[ERROR] 숫자만 입력하세요.");

        private final String message;

        ErrorMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    public enum OutputMessages {
        MATCH_3("3개 일치 (5,000원) - "),
        MATCH_4("4개 일치 (50,000원) - "),
        MATCH_5("5개 일치 (1,500,000원) - "),
        MATCH_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
        MATCH_6("6개 일치 (2,000,000,000원) - ");

        private final String message;

        OutputMessages(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }
}
