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
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
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
