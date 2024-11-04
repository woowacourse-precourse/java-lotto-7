package lotto.domain;

import static lotto.config.LottoConfig.LOTTO_PRICE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.config.LottoConfig;
import lotto.view.ErrorConstants;
import lotto.view.OutputView;

public class DefaultLottoGenerator implements LottoGenerator {

    @Override
    public List<Lotto> generateLottos(int purchaseAmount) {
        int ticketCount = calculateTicketCount(purchaseAmount);
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            lottos.add(generateLottoWithExceptionHandling());
        }
        return lottos;
    }

    private Lotto generateLottoWithExceptionHandling() {
        try {
            return generateLotto();
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(ErrorConstants.LOTTO_NUMBER_GENERATION_FAILED);
            throw new IllegalArgumentException(ErrorConstants.LOTTO_NUMBER_GENERATION_FAILED, e);
        }
    }

    private int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    protected Lotto generateLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                LottoConfig.LOTTO_MIN_NUMBER,
                LottoConfig.LOTTO_MAX_NUMBER,
                LottoConfig.LOTTO_NUMBER_COUNT
        );
        return new Lotto(numbers);
    }
}
