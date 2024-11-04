package lotto.lotto.domain;

import lotto.lotto.validator.LottoValidator;

import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoValidator.lottoValidate(numbers);
        this.numbers = sort(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> sort(List<Integer> numbers) {
        return numbers.stream().sorted().toList();
    }

    public List<Integer> info() {
        return Collections.unmodifiableList(numbers);
    }

    public boolean isContains(int number) {
        return numbers.contains(number);
    }

    public int getMatchWinningCount(WinningLotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto::isContain).count();
    }

    public int getMatchWinningCountAndBonusNumber(WinningLotto winningLotto, BonusNumber bonusNumber) {
        int matchCount = getMatchWinningCount(winningLotto);
        if (isContains(bonusNumber.getNumber())) matchCount++;
        return matchCount;


    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
