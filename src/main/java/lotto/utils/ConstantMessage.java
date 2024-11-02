package lotto.utils;

public class ConstantMessage {
    ConstantMessage() {
    }

    static public enum GuideMessage {
        INPUT_PRICE("구입금액을 입력해 주세요."),
        INPUT_LOTTO("당첨 번호를 입력해 주세요."),
        INPUT_BONUS("보너스 번호를 입력해 주세요."),
        RESULT_STAT("당첨 통계\n---");

        private final String message;

        GuideMessage(String message) {
            this.message = message;
        }

        public String getMessage() {
            return message;
        }
    }

    static public final String ERROR_HEADER = "[ERROR] ";

    static public enum ErrorMessage {
        INVALID_VALUE("부적절한 입력입니다. ");

        private final String error;

        ErrorMessage(String error) {
            this.error = ERROR_HEADER + error;
        }

        public String getErrorMessage() {
            return error;
        }
    }
}
