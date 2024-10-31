package lotto.domain;

import lotto.constant.ErrorMessage;

import java.util.List;

public class WinningLotto {
    private final Lotto winningLotto;
    private final Bonus bonus;

    public WinningLotto(WinningNumber winningNumber, Bonus bonus) {
        List<Integer> winningNumberList = winningNumber.getList();
        this.winningLotto  = new Lotto(winningNumberList);
        this.bonus = bonus;
        validate();
    }

    private void validate() {
        validateDuplication();
    }

    private void validateDuplication() {
        String state = winningLotto.getState();
        if(state.contains(bonus.getBonus())) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION_ERROR_MESSAGE);
        }
    }
}
