package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.function.Predicate;

public class LottoMachine {

    private final Lotto winningLotto;
    private int bonusNumber;

    public LottoMachine(Lotto winningLotto, String bonusNumber) throws IllegalArgumentException {
        this.winningLotto = winningLotto;
        validateBonusNumber(bonusNumber);
        this.bonusNumber = Integer.parseInt(bonusNumber);
    }

    private void validateBonusNumber(String bonusNumber) throws IllegalArgumentException {
        if (!(bonusNumber.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 숫자로만 입력해야 합니다.");
        }
        if (Integer.parseInt(bonusNumber) < 1 || Integer.parseInt(bonusNumber) > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        if (this.winningLotto.getNumbers().contains(Integer.parseInt(bonusNumber))) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 중복되면 안됩니다.");
        }
    }

    public static Lotto releaseLotto(RandomIntegersGenerator randomGenerator) {
        return new Lotto(randomGenerator.generate());
    }
}
