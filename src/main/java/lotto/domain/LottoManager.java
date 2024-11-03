package lotto.domain;

import static lotto.utils.Constant.CHECK_BONUS_NUMBER;
import static lotto.utils.Constant.MAX_LOTTO_NUMBER;
import static lotto.utils.Constant.MAX_LOTTO_NUMBER_COUNT;
import static lotto.utils.Constant.MIN_LOTTO_NUMBER;
import static lotto.utils.Constant.MIN_PURCHASE_AMOUNT;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final List<Lotto> lottoNumbers = new ArrayList<>();
    private final LottoResult lottoResult = new LottoResult();
    private final int purchaseAmount;

    public LottoManager(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void generateLottoNumbers() {
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

    public void checkLottoResult(List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottoNumbers) {
            LottoRanking rank = findLottoResult(lotto, winningNumbers, bonusNumber);

            lottoResult.addMatchCount(rank);
        }
    }

    public LottoRanking findLottoResult(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = lotto.countMatchNumbers(winningNumbers);
        boolean matchBonusNumber = false;

        if (matchCount == CHECK_BONUS_NUMBER) {
            matchBonusNumber = lotto.isMatchBonusNumber(bonusNumber);
        }

        return lottoResult.findRanking(matchCount, matchBonusNumber);
    }

    public List<Lotto> getLottoNumbers() {
        return lottoNumbers;
    }

    public LottoResult getLottoResult() {
        return lottoResult;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
