package lotto.dto;

import lotto.Lotto;

public class UserInputDTO {
    private Lotto winningLotto;
    private Integer bonusNumber;

    public UserInputDTO(Lotto winningLotto, Integer bonusNumber) {
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
    }

    public Lotto getWinningLotto() {
        return winningLotto;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
