package lotto.util;

public class Validation {
    public static void validateWinningLength(int length) {
        if (length != 6){
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 6개여야 합니다.");
        }
    }

    public static void validateNumBoundary(int number){
        if (number < 1 || number > 45){
            throw new IllegalArgumentException("[ERROR] 로또 당첨 번호는 1에서 45 사이여야 합니다.");
        }
    }
}
