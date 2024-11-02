package lotto.domain;

import lotto.constant.ErrorMessage;
import lotto.constant.NumberConstant;

import java.util.Collections;
import java.util.List;
import java.util.SequencedSet;

import static lotto.constant.NumberConstant.*;

public class WinningNumber {

    List<Integer> winningNumber;
    private Integer bonusNumber;

    public WinningNumber(Lotto winningNumber) {
        this.winningNumber = winningNumber.getNumbers();
    }

//    private void validateSize(SequencedSet<Integer> winningNumber) {
//        if (winningNumber.size() != LOTTO_NUMBER_PICK_COUNT) {
//            throw new IllegalArgumentException(ErrorMessage.NOT_MATCHED_WINNING_NUMBER_COUNT.getMessage());
//        }
//    }

    public void addBonusNumber(final int number) {
        if (this.bonusNumber != null) {
            throw new IllegalArgumentException("이미 보너스 번호가 있습니다.");
        }
        validateDuplicateNumber(number);

        this.bonusNumber = number;
    }

    private void validateDuplicateNumber(int number) {
        if (winningNumber.contains(number)) {
            throw new IllegalArgumentException("보너스 숫자는 당첨 번호와 다르게 입력해주세요.");
        }
    }

    public List<Integer> getWinningNumber() {
        return Collections.unmodifiableList(winningNumber);
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
