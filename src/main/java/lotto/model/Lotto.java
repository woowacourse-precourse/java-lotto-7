package lotto.model;

import static lotto.config.LottoConstants.LOTTO_END_NUMBER;
import static lotto.config.LottoConstants.LOTTO_NUMBER_COUNT;
import static lotto.config.LottoConstants.LOTTO_PRICE;
import static lotto.config.LottoConstants.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.config.SystemConstants;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static List<Lotto> buyLottos(int purchaseAmount) {
        return IntStream.range(0, purchaseAmount / LOTTO_PRICE.getValue())
                .mapToObj(i -> buyLotto())
                .toList();
    }

    private static Lotto buyLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(
                        LOTTO_START_NUMBER.getValue(),
                        LOTTO_END_NUMBER.getValue(),
                        LOTTO_NUMBER_COUNT.getValue()
                )
                        .stream()
                        .sorted()
                        .toList()
        );
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
                .collect(Collectors.joining(
                        SystemConstants.LOTTO_TO_STRING_FORMAT_SEPARATOR,
                        SystemConstants.LOTTO_TO_STRING_FORMAT_PREFIX,
                        SystemConstants.LOTTO_TO_STRING_FORMAT_SUFFIX
                ));
    }
}
