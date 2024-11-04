package services;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import model.Lotto;

public class LottoService {

    public List<Lotto> generateLotto(String purchaseAmount) {
        int parsedPurchaseAmount = Integer.parseInt(purchaseAmount);
        int lottoCount = parsedPurchaseAmount / 1000;

        return IntStream.range(0, lottoCount)
                .mapToObj(count -> new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)))
                .toList();
    }
}
