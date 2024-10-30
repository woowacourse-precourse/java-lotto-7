package lotto.factory;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoNumberGenerator;

public class LottoMakeFactory {

    public static List<Lotto> makeTickets(int purchaseAmount) {
        return IntStream.range(0, purchaseAmount)
                        .mapToObj(i -> createSortedLotto())
                        .collect(Collectors.toList());
    }

    private static Lotto createSortedLotto() {
        List<Integer> sortedNumbers = LottoNumberGenerator.generateLottoNumber()
                .stream()
                .sorted()
                .collect(Collectors.toList());
        return new Lotto(sortedNumbers);
    }
}
