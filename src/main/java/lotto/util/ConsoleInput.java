package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.BusinessException;
import lotto.exception.ErrorMessage;

public class ConsoleInput {

    private ConsoleInput() {}

    public static String getStringWithQuestion(String question) {
        System.out.println(question);
        return Console.readLine();
    }

    public static long getLongWithPrompt(String prompt) {
        try {
            return Long.parseLong(getStringWithQuestion(prompt));
        } catch (NumberFormatException e) {
            throw new BusinessException(ErrorMessage.INVALID_LOTTO_NUM_FORMAT);
        }
    }

    public static int getIntWithPrompt(String prompt) {
        try {
            return Integer.parseInt(getStringWithQuestion(prompt));
        } catch (NumberFormatException e) {
            throw new BusinessException(ErrorMessage.INVALID_LOTTO_NUM_FORMAT);
        }
    }
}
