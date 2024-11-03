package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static lotto.validation.ValidatorImpl.LOTTO_TICKET_PRICE;

public class LottoGenerator {
    public static final int START_INCLUSIVE = 1;
    public static final int END_INCLUSIVE = 45;
    public static final int COUNT = 6;

    public List<Lotto> generateLotto(int amount) {
        int ticketCount = calculate(amount);
        return Stream.generate(() -> new Lotto(generateLottoNumbers()))
                .limit(ticketCount)
                .collect(Collectors.toList());
    }

    private static int calculate(int amount) {
        int ticketCount = amount / LOTTO_TICKET_PRICE;
        return ticketCount;
    }

    private static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        ascending(numbers);
        return numbers;
    }

    private static void ascending(List<Integer> numbers) {
        Collections.sort(numbers);
    }
}
