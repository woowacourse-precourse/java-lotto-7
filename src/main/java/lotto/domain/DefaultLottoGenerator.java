package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.view.ErrorConstants;
import lotto.view.OutputView;

public class DefaultLottoGenerator implements LottoGenerator {

    private static final int LOTTO_PRICE = 1000;

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
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }
}
