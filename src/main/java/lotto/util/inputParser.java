package lotto.util;

public class inputParser {
    public static int parseInt(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력값에 대해 숫자로 입력해야합니다.");
        }
    }
}
