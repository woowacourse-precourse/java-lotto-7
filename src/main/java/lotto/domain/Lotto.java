package lotto.domain;

import static lotto.global.ErrorMessage.HAS_SIX_LOTTO_NUMBER;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(HAS_SIX_LOTTO_NUMBER.message);
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    // 보너스 볼 획득 및 5개 일치 시 7으로 리턴. 그 외에는 당첨된 숫자 개수 리턴.
    public int getWinningNumberCount(Lotto userLotto, int bonusNumber) {
        List<Integer> numbers = userLotto.getNumbers();
        int count = (int) numbers.stream().filter(this.numbers::contains).count();

        if(numbers.contains(bonusNumber) && count == 5) return 7;
        return count;
    }

    @Override
    public String toString() {
        List<Integer> list = numbers.stream().sorted().toList();
        return list.toString();
    }
}
