package lotto.service;

import lotto.model.Lotto;
import lotto.constants.LottoConstants;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerationService {

    public List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / LottoConstants.LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_NUMBER,
                    LottoConstants.MAX_LOTTO_NUMBER,
                    LottoConstants.LOTTO_NUMBER_COUNT
            );
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }
}
