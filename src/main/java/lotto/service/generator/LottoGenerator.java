package lotto.service.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.factory.LottoFactory;

public class LottoGenerator {

    private static final Integer MIN_NUMBER_RANGE = 1;
    private static final Integer MAX_NUMBER_RANGE = 45;
    private static final Integer NUMBER_COUNT = 6;

    private final Integer lottoCount;
    private final List<Lotto> lottoTicket = new ArrayList<>();

    private LottoGenerator(Integer lottoCount) {
        this.lottoCount = lottoCount;
    }

    public static LottoGenerator create(Integer lottoCount) {
        return new LottoGenerator(lottoCount);
    }

    private List<Integer> generateNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE, NUMBER_COUNT);
    }

    private Lotto changeNumberToLotto(List<Integer> number) {
        return LottoFactory.create(number);
    }

    public List<Lotto> getLottoTicket() {
        for (int count = 0; count < lottoCount; count++) {
            lottoTicket.add(changeNumberToLotto(generateNumber()));
        }
        return lottoTicket;
    }
}
