package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.Lottos;

public class SetupService {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private SetupService() {
    }

    private static class SingletonHelper {
        private static final SetupService INSTANCE = new SetupService();
    }

    public static SetupService getInstance() {
        return SingletonHelper.INSTANCE;
    }


    public Lottos purchaseLottos(int purchaseAmount) {
        int purchaseNumber = purchaseAmount / LOTTO_TICKET_PRICE;
        Lottos lottos = new Lottos();

        IntStream.range(0, purchaseNumber)
                .forEach(i -> lottos.insertLotto(createLotto()));

        return lottos;
    }

    private Lotto createLotto() {
        return new Lotto(
                Randoms.pickUniqueNumbersInRange(1, 45, 6)
                        .stream()
                        .sorted()
                        .toList()
        );
    }
}
