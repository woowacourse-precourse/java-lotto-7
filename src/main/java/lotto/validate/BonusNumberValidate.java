package lotto.validate;

public class BonusNumberValidate {

    private final int bonusNumber;

    public BonusNumberValidate(String number) {
        int bonusNumber = parseBonusNumber(number);
        isRangeNumber(bonusNumber);

        this.bonusNumber = bonusNumber;
    }

    private int parseBonusNumber(String bonusNumber) {
        try {
            return Integer.parseInt(bonusNumber);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자여야 합니다.");
        }
    }

    private void isRangeNumber(int bonusNumber) {
        if (!(1 <= bonusNumber && bonusNumber <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1 ~ 45 범위 안의 숫자여야 합니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
