package lotto.model;

import static lotto.config.LottoConstants.LOTTO_END_NUMBER;
import static lotto.config.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.config.LottoConstants.LOTTO_PRICE;
import static lotto.config.LottoConstants.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public static List<Lotto> buyLottos(int purchaseAmount) {
        return IntStream.range(0, purchaseAmount / LOTTO_PRICE)
                .mapToObj(i -> buyLotto())
                .toList();
    }

    private static Lotto buyLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                        LOTTO_START_NUMBER,
                        LOTTO_END_NUMBER,
                        LOTTO_NUMBER_COUNT
                )
                        .stream()
                        .sorted()
                        .toList()
        );
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    public boolean hasBonus(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int countMatchNumber(List<Integer> winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public String toString() {
        return numbers.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
