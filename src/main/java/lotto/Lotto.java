package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        for(int i = 0; i < 6; i++) {
            validateDistinctNumbers(numbers, i, numbers.get(i));
        }
    }

    private void validateDistinctNumbers(List<Integer> numbers, int index, int number) {
        for(int i = 0; i < index; i++) {
            if (numbers.get(i).equals(number)){
                throw new IllegalArgumentException("[ERROR] 중복된 번호가 있습니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return this.numbers;
    }

    public int countMatchingNumber(List<Integer> winningNumbers) {
        int count = 0;
        for (Integer number : this.numbers) {
            if (winningNumbers.contains(number)) {
                count++;
            }
        }
        return count;
    }
    public boolean isMatchingBonusNumber(int bonusNumber) {
        for (Integer number : this.numbers) {
            if (number == bonusNumber){
                return true;
            }
        }
        return false;
    }
}
