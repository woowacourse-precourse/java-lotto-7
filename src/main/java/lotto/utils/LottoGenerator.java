package lotto.utils;

import static lotto.constant.lotto.LottoConstants.LOTTO_NUMBERS_COUNT;
import static lotto.constant.lotto.LottoConstants.MAX_LOTTO_NUMBER;
import static lotto.constant.lotto.LottoConstants.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.domain.LottoTickets;

public class LottoGenerator {

    public static LottoTickets generateLottoTickets(BigDecimal lottoAmount) {
        List<Lotto> lottoList = Stream.generate(LottoGenerator::generateSortedLottoNumbers)
                .limit(lottoAmount.longValue()).map(Lotto::new).toList();

        return new LottoTickets(lottoList);
    }

    private static List<Integer> generateSortedLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getIntValue(),
                MAX_LOTTO_NUMBER.getIntValue(),
                LOTTO_NUMBERS_COUNT.getIntValue()
                )
                .stream()
                .sorted()
                .toList();
    }
}
