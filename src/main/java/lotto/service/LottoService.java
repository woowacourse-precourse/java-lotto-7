package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.entity.Lotto;
import lotto.entity.Lottos;
import lotto.entity.WinningNumbers;
import lotto.enums.LottoConstants;
import lotto.enums.Prize;

import java.util.ArrayList;
import java.util.List;

public class LottoService {

    public Lottos generateLottos(int purchaseAmount) {
        int count = purchaseAmount / LottoConstants.LOTTO_PRICE.getValue();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                    LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                    LottoConstants.MAX_LOTTO_NUMBER.getValue(),
                    LottoConstants.LOTTO_NUMBERS_COUNT.getValue()
            );
            lottos.add(new Lotto(numbers));
        }
        return new Lottos(lottos);
    }

    public List<Prize> calculateResults(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.calculateResults(winningNumbers);
    }
}
