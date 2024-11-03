package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.BusinessException;

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
            throw new BusinessException("숫자만 입력할 수 있습니다.");
        }
    }

    public static int getIntWithPrompt(String prompt) {
        try {
            return Integer.parseInt(getStringWithQuestion(prompt));
        } catch (NumberFormatException e) {
            throw new BusinessException("숫자만 입력할 수 있습니다.");
        }
    }
}
