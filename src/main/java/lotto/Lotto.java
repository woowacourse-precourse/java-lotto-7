package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        this.numbers = sortedNumbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        if (Validator.validateDuplicate(numbers)){
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복되면 안됩니다.");
        }
    }

    // TODO: 추가 기능 구현
    public Grade judgeLotto(List<Integer> answer, int bonusNumber) {
        LottoJudge lottoJudge = new LottoJudge(answer, numbers, bonusNumber);
        return lottoJudge.judge();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
