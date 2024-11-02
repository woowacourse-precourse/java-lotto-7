package lotto.service.lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoConstant;

public class LottoService {


    public List<Lotto> createLottoes(int inputPurchaseAmount) {

        int purchaseCount = inputPurchaseAmount / LottoConstant.LOTTO_PRICE;
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < purchaseCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(numbers);
            lottoes.add(new Lotto(numbers));
        }

        return lottoes;
    }
}
