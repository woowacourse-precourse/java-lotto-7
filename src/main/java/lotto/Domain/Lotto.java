package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.Utils.LottoConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto create() {
        List<Integer> numbers = generateNumbers();
        return new Lotto(numbers);
    }

    private static List<Integer> generateNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(LottoConstants.LOTTO_START_NUMBER, LottoConstants.LOTTO_END_NUMBER, LottoConstants.LOTTO_NUMBER_COUNT);
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    // 추가 기능 구현
    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public Lotto getLotto() {
        return from(numbers);
    }

}
