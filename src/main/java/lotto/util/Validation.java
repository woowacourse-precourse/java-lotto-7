package lotto.util;

public class Validation {
    public static void validateWinningLength(int length) {
        if (length != 6){
            throw new IllegalArgumentException("[ERROR] 이동 횟수가 올바르지 않습니다.");
        }
    }
}
