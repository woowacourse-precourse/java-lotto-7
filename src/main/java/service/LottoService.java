package service;

import static java.util.stream.Stream.generate;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import lotto.Lotto;
import lotto.LottoList;
import lotto.PurchaseCount;

public class LottoService {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public PurchaseCount getCount(String purchaseAmountFromView) {
        int purchaseAmount = purchaseAmountValidate(purchaseAmountFromView);
        return new PurchaseCount(purchaseAmount);
    }

    private int purchaseAmountValidate(String purchaseAmountFromView) {
        int purchaseAmount;
        try {
            purchaseAmount = Integer.parseInt(purchaseAmountFromView);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해야 합니다.");
        }
        if (purchaseAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000 이상이어야 합니다.");
        }
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 1000원 단위로 입력해야 합니다.");
        }
        return purchaseAmount;
    }

    public LottoList generateLottos(int purchaseCount) {
        List<Lotto> lottoList = generate(() -> new Lotto(generateRandomLottoNumbers()))
                .limit(purchaseCount)
                .collect(Collectors.toList());
        return new LottoList(lottoList);
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
    }
}
