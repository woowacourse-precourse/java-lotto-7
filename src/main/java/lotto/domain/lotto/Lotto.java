package lotto.domain.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.input.InputValidator;

import java.util.ArrayList;
import java.util.Collections;
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
        InputValidator.isDuplicate(numbers);
    }

    /**
     * 1-45 사이의 중복되지 않는 정수 6개 생성
     */
    public static List<Integer> generateLottoNumber() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    /**
     * 로또 번호들을 오름차순 정렬
     */
    public static List<Integer> sortNumbers(List<Integer> numbers) {
        List<Integer> sortedNumbers = new ArrayList<>(numbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    /**
     * 로또 번호 getter
     */
    public List<Integer> getNumbers() {
        return numbers;
    }
}
