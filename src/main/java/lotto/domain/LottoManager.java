package lotto.domain;

import static lotto.utils.Constant.MAX_LOTTO_NUMBER;
import static lotto.utils.Constant.MAX_LOTTO_NUMBER_COUNT;
import static lotto.utils.Constant.MIN_LOTTO_NUMBER;
import static lotto.utils.Constant.MIN_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final List<Lotto> lottoNumbers = new ArrayList<>();

    public void generateLottoNumbers(int purchaseAmount) {
        int lottoCount = purchaseAmount / MIN_PURCHASE_AMOUNT;

        for (int count = 0; count < lottoCount; count++) {
            lottoNumbers.add(new Lotto(generateRandomNumbers()));
        }
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER,
                MAX_LOTTO_NUMBER_COUNT
        );

        return randomNumbers.stream()
                .sorted()
                .toList();
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }
}
