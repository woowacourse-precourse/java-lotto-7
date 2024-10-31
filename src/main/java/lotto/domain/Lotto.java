package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private static final int START_NUM = 1;
    private static final int END_NUM = 45;
    private static final int LOTTO_COUNT = 6;

    private final List<LottoNum> numbers;

    protected Lotto(List<LottoNum> numbers) {
        validate(numbers);
        this.numbers = sorted(numbers);
    }

    public static Lotto generate() {
        List<LottoNum> numbers = Lotto.generateRandomLottoNumbers();
        return new Lotto(numbers);
    }

    private static List<LottoNum> generateRandomLottoNumbers() {
        return convertToLottoNums(generateUniqueRandomNumbers());
    }

    private static List<Integer> generateUniqueRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(START_NUM, END_NUM, LOTTO_COUNT);
    }

    private static List<LottoNum> convertToLottoNums(List<Integer> numbers) {
        return numbers.stream()
                .map(LottoNum::new)
                .toList();
    }

    private List<LottoNum> sorted(List<LottoNum> numbers) {
        return numbers.stream()
                .sorted()
                .toList();
    }

    private void validate(List<LottoNum> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<LottoNum> numSet = new HashSet<>(numbers);
        if (numSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복된 로또 번호는 허용하지 않습니다.");
        }
    }
}
