package lotto.global.utils;

import static lotto.global.constants.Constants.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

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

    // 존재하는 모든 공백을 제거한다.
    public static String removeAllWhiteSpaces(String input) {
        return input.replaceAll(WHITE_SPACE.getValue(), "").trim();
    }

    // 존재하는 모든 공백을 제거하고, 콤마를 기준으로 분리하여 List에 담는다.
    public static List<Integer> parseToList(String input) {
        return Arrays.stream(removeAllWhiteSpaces(input).split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
