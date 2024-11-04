package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public static List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(
                LottoConstant.LOTTO_MIN_NUMBER,
                LottoConstant.LOTTO_MAX_NUMBER,
                LottoConstant.LOTTO_NUMBER_COUNT
        );
    }

    public static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfTickets = purchaseAmount / LottoConstant.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfTickets; i++) {
            lottos.add(new Lotto(generateLottoNumbers()));
        }
        return lottos;
    }
}
