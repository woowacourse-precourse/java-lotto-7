package lotto;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(Constants.ERROR_PREFIX + "로또 번호는 6개여야 합니다.");
        }
        boolean[] used = new boolean[46];

        for (Integer number : numbers) {
            if (used[number]) {
                throw new IllegalArgumentException(Constants.ERROR_PREFIX + "로또 번호에 중복된 숫자가 있을 수 없습니다.");
            }
            used[number] = true;
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    /**
     * @param winningNumbers 당첨 번호
     * @return 당첨 번호 포함 개수
     */
    public int countMatchNumber(List<Integer> winningNumbers) {
        int matchCount = 0;

        for (Integer winningNumber : winningNumbers) {
            if (numbers.contains(winningNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    /**
     * @param bonusNumber 보너스 넘버
     * @return 보너스 넘버 포함 여부
     */
    public boolean hasBonus(Integer bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
