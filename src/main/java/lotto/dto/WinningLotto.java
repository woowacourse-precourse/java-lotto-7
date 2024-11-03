package lotto.dto;

import lotto.Lotto;

public record WinningLotto(Lotto lotto, int bonusNumber) {
    public WinningLotto {
        if (lotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
