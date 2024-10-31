/*
 * 클래스 이름 WinningLotto
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
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
        int bonus = this.bonus.getBonus();
        String valueOfBonus = String.valueOf(bonus);
        if(state.contains(valueOfBonus)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATION_ERROR_MESSAGE);
        }
    }

    public Bonus getBonus() {
        return bonus;
    }

    public int getMatchingCount(List<Integer> numbers) {
        return winningLotto.getMatchingCount(numbers);
    }

}
