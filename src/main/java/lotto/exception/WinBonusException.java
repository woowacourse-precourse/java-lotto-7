package lotto.exception;

public class WinBonusException {

    private static final String MESSAGE_WINNING_NUMBER = "[ERROR] 당첨 번호는 숫자를 입력해야 합니다.";
    private static final String MESSAGE_WINNING_RANGE = "[ERROR] 당첨 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String MESSAGE_WINNING_SIZE = "[ERROR] 당첨 번호는 6개의 숫자여야 합니다.";
    private static final String MESSAGE_WINNING_DUPLICATE = "[ERROR] 당첨 번호는 중복되면 안됩니다.";

    private static final String MESSAGE_BONUS_NUMBER = "[ERROR] 보너스 번호는 숫자를 입력해야 합니다.";
    private static final String MESSAGE_BONUS_RANGE = "[ERROR] 보너스 번호는 1 ~ 45 사이의 숫자여야 합니다.";
    private static final String MESSAGE_BONUS_DUPLICATE = "[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.";

    public static void exceptionWinningNumber() {
        throw new IllegalArgumentException(MESSAGE_WINNING_NUMBER);
    }

    public static void exceptionWinningRange() {
        throw new IllegalArgumentException(MESSAGE_WINNING_RANGE);
    }

    public static void exceptionWinningSize() {
        throw new IllegalArgumentException(MESSAGE_WINNING_SIZE);
    }

    public static void exceptionWinningDuplicate() {
        throw new IllegalArgumentException(MESSAGE_WINNING_DUPLICATE);
    }

    public static void exceptionBonusNumber() {
        throw new IllegalArgumentException(MESSAGE_BONUS_NUMBER);
    }

    public static void exceptionBonusRange() {
        throw new IllegalArgumentException(MESSAGE_BONUS_RANGE);
    }

    public static void exceptionBonusDuplicate() {
        throw new IllegalArgumentException(MESSAGE_BONUS_DUPLICATE);
    }

}
