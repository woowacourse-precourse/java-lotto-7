package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;

import java.util.ArrayList;
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
        return amount / LOTTO_TICKET_PRICE;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, COUNT);
        return ascending(numbers);
    }

    private List<Integer> ascending(List<Integer> numbers) {
        List<Integer> mutableList = new ArrayList<>(numbers);
        Collections.sort(mutableList);
        return mutableList;
    }
}
