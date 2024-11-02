package lotto.model;

public class BonusNumber {

    private final int bonusNumber;

    private BonusNumber(int bonusNumber, Lotto lotto) {
        validateBonusNumber(bonusNumber, lotto);
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(int bonusNumber, Lotto lotto){
        return new BonusNumber(bonusNumber, lotto);
    }

    private void validateBonusNumber(int bonusNumber, Lotto lotto) {
        if (String.valueOf(bonusNumber).isBlank()) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호를 입력해주세요.");
        }

        if (bonusNumber < 0) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 음수를 입력할 수 없습니다.");
        }

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 숫자를 입력해주세요.");
        }

        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안 됩니다.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
