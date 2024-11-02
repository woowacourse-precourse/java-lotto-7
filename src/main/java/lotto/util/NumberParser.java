package lotto.util;

public class NumberParser {
    public static int stringToInt(String string) { //입력 값 변환 가능 여부 처리
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 정수 값을 입력해야 합니다");
        }
    }
}
