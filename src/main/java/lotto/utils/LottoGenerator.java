package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;
import lotto.domain.Number;

public class LottoGenerator {

    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private static final int LOTTO_NUMBERS_COUNT = 6;

    public static LottoTickets generateLottoTickets(BigDecimal lottoAmount) {
        List<Lotto> lottoList = Stream.generate(LottoGenerator::generateSortedLottoNumbers)
                .limit(lottoAmount.longValue())
                .map(Lotto::new)
                .toList();

        return new LottoTickets(lottoList);
    }

    private static List<Integer> generateSortedLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER, LOTTO_NUMBERS_COUNT).stream()
                .sorted()
                .toList();
    }
}
