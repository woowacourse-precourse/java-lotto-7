package lotto.Model;

import lotto.Validation.NumberValidation;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        NumberValidation.NumberNotDuplicate(numbers);
        NumberValidation.NumberRange(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Lotto> Lottos(int money) {
        List<Lotto> Lottos = new ArrayList<>();
        for (int i=0; i<money/1000; i++) {
            List<Integer> numbers = LottoNumbers();
            Lottos.add(new Lotto(numbers));
        }
        return Lottos;
    }

    private List<Integer> LottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
}
