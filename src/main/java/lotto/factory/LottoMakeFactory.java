package lotto.factory;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;

public class LottoMakeFactory {

    public static List<Lotto> makeTickets(int purchaseAmount) {
        return IntStream.range(0, purchaseAmount)
                        .mapToObj(i -> createSortedLotto())
                        .collect(Collectors.toList());
    }

    private static Lotto createSortedLotto() {
        List<Integer> sortedNumbers = generateLottoNumber()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(sortedNumbers);
    }

    private static List<Integer> generateLottoNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }
}