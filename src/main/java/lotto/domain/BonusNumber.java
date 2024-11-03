package lotto.domain;

public class BonusNumber {

    private final long number;

    public BonusNumber(long number) {
        validateNumberInRange(number);
        this.number = number;
    }

    private static void validateNumberInRange(long number) {
        if (isOutOfRange(number)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
        }
    }

    private static boolean isOutOfRange(long number) {
        return number < 1 || number > 45;
    }

    public long getNumber() {
        return number;
    }




}
