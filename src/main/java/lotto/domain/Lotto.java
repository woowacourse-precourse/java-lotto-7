package lotto.domain;

import java.util.List;
import lotto.service.Validator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        Validator.validateLottoNumbers(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // 보너스 볼 획득 및 5개 일치 시 0으로 리턴. 그 외에는 당첨된 숫자 개수 리턴.
    public int getWinningNumberCount(List<Integer> inputNumbers, int bonusNumber) {
        int count = (int) inputNumbers.stream().filter(numbers::contains).count();

        if(inputNumbers.contains(bonusNumber) && count == 5) return 0;
        return count;
    }

    @Override
    public String toString() {
        List<Integer> list = numbers.stream().sorted().toList();
        return list.toString();
    }
}
