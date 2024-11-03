package lotto;

import java.util.List;

public class WinningLotto extends Lotto {
    private final int bonusNum;

    public WinningLotto(List<Integer> numbers, int bonusNum) {
        super(numbers);
        validate(bonusNum);
        this.bonusNum = bonusNum;
    }

    private void validate(int bonusNum) {
        if (this.getNumbers().contains(bonusNum)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다.");
        }
        if (!(1 <= bonusNum && bonusNum <= 45)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호의 숫자 범위는 1~45까지여야 합니다.");
        }
    }

    public int getBonusNum() {
        return bonusNum;
    }

}
