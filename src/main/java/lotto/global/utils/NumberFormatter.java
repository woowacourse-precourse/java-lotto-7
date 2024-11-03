package lotto.global.utils;

import static lotto.global.constants.Constants.*;

public class NumberFormatter {

    // 문자열에서 앞뒤 공백을 제거하고 콤마를 제거한 뒤 하나의 문자로 반환
    public static String removeCommas(String input) {
        String sanitizedNumber = input.trim();
        return sanitizedNumber.replaceAll(",", "");
    }

    // 입력된 문자열을 숫자형식으로 변환
    public static int parseToInt(String input) {
        String formattedNumber = removeCommas(input);
        try {
            return Integer.parseInt(formattedNumber);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(ERROR_HEADER.getValue() + "숫자가 아닌 다른 입력입니다.");
        }
    }

}
