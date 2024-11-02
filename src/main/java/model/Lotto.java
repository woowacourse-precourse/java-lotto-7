package model;

import java.util.ArrayList;
import java.util.List;
import validation.Validation;

import static error.ErrorMessage.LOTTO_NUM_SIX_ERROR;
import static error.ErrorMessage.LOTTO_NUM_DUPLICATE_ERROR;

public class Lotto {

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(LOTTO_NUM_SIX_ERROR);
        }
        try {
            Validation.duplicate(numbers);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(LOTTO_NUM_DUPLICATE_ERROR);
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

    public int getMatchCount(WinningLottoNum winningLottoNum){
        List<Integer> lottoNums = new ArrayList<>(numbers);
        lottoNums.retainAll(winningLottoNum.getWinningNums());
        return lottoNums.size();
    }

    public boolean isContain(BonusNumber bonusNumber){
        return numbers.contains(bonusNumber.get());
    }
}
