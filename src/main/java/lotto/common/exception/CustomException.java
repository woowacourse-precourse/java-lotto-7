package lotto.common.exception;

public interface CustomException {

    static String appendDetails(String message, String... details) {
        StringBuilder stringBuilder = new StringBuilder(message);
        for (String detail : details) {
            stringBuilder.append(" ").append(detail);
        }
        return stringBuilder.toString();
    }
}
