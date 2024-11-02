package lotto;

public record WinningNumbers(Lotto lotto, int bonusBall) {

    public WinningNumbers {
        validate(lotto, bonusBall);
    }

    private void validate(Lotto lotto, int bonusBall) {
        if (lotto.contains(bonusBall)) {
            throw new IllegalArgumentException("[ERROR] 보너스 볼은 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
