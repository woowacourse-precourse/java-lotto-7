package lotto;

public class BonusBall {

    private final int number;

    public static BonusBall of(int number, WinningBalls winningBalls) {
        if (!winningBalls.isDistinct(number)) {
            throw new IllegalArgumentException(ErrorMessage.BONUS_NUMBER_DUPLICATE.getMessage());
        }

        return new BonusBall(number);
    }

    private BonusBall(int number) {
        this.number = number;
    }

    public int getSameNumberCount(Lotto userLotto) {
        if(userLotto.hasNumber(number)) {
            return 1;
        }
        return 0;
    }
}

