package lotto.domain.exception;

public class BonusNumberFormatException extends NumberFormatException {

    public BonusNumberFormatException() {
        super();
    }

    public BonusNumberFormatException(String message) {
        super(message);
    }

    public static BonusNumberFormatException invalidNumber() {
        return new BonusNumberFormatException("보너스 번호는 숫자로만 이루어져야 합니다.");
    }

    public static BonusNumberFormatException duplicateNumber() {
        return new BonusNumberFormatException("보너스 번호는 당첨 번호 중 하나가 아니어야 합니다.");
    }

    public static BonusNumberFormatException outOfRange() {
        return new BonusNumberFormatException("보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }
}
