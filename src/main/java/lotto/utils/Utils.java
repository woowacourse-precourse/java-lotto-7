package lotto.utils;

public class Utils {
    private static final String ERROR_MESSAGE = "[ERROR]";

    public static String makeErrorMessage(String message) {
        return ERROR_MESSAGE + " " + message;
    }

    public static int changeStringToNum(String inputString) {
        int returnNum;
        try {
            returnNum = Integer.parseInt(inputString.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException(Utils.makeErrorMessage("숫자를 입력해주세요."));
        }
        return returnNum;
    }
}
