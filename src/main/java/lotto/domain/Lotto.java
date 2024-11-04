package lotto.domain;

import lotto.constant.LottoConstant;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.HashSet;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        if (hasDuplicates(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
        }

        if (!isWithinRange(numbers)) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
    }

    private boolean hasDuplicates(List<Integer> numbers) {
        HashSet<Integer> uniqueNumbers = new HashSet<>(numbers);
        return uniqueNumbers.size() != numbers.size();
    }

    private boolean isWithinRange(List<Integer> numbers) {
        return numbers.stream().allMatch(num -> num >= LottoConstant.LOTTO_MIN_NUMBER && num <= LottoConstant.LOTTO_MAX_NUMBER);
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public void validateBonusNumber(Integer bonusNumber) {
        if(bonusNumber<LottoConstant.LOTTO_MIN_NUMBER || LottoConstant.LOTTO_MAX_NUMBER<bonusNumber){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1에서 45 사이의 숫자여야 합니다.");
        }
        if(numbers.stream().anyMatch(number -> number.equals(bonusNumber))){
            throw new IllegalArgumentException("[ERROR] 로또 보너스 번호는 당첨 번호와 중복일 수 없습니다.");
        }
    }

    public Integer getMatchCount(Lotto winningLotto) {
        return (int) numbers.stream()
                .filter(winningLotto.getNumbers()::contains)
                .count();
    }

    public boolean getBonusMatch(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
