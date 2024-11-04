package lotto.model;

import lotto.model.Lotto;
import lotto.model.LottoType;

import java.util.List;
import java.util.Map;

public class LottoProcessor {
    private final Map<LottoType, Integer> lottoStorage;

    public LottoProcessor(Map<LottoType, Integer> lottoStorage) {
        this.lottoStorage = lottoStorage;
    }

    public Map<LottoType, Integer> lottoPick(List<List<Integer>> purchaseLottoNumbers, Lotto lotto,
                                             int inputBonusNumber) {
        for (List<Integer> lottoNumbers : purchaseLottoNumbers) {
            Integer matchingNumberCount = lotto.getMatchingNumberCount(lottoNumbers);

            if (lotto.isBonusNumberMatching(inputBonusNumber) && matchingNumberCount == 5) {
                Integer count = lottoStorage.get(LottoType.SECOND_PLACE);
                lottoStorage.put(LottoType.SECOND_PLACE, count + 1);
            }

            count(matchingNumberCount);
        }

        return lottoStorage;
    }

    private void count(Integer matchingNumberCount) {
        LottoType lottoType = LottoType.countToLottoType(matchingNumberCount);

        if (!lottoType.isOutOfTheRanking()) {
            Integer count = lottoStorage.get(lottoType);
            lottoStorage.replace(lottoType, count + 1);
        }
    }

    public long calculateWinnings() {
        long winnings = 0;
        for (Map.Entry<LottoType, Integer> lottoTypeIntegerEntry : lottoStorage.entrySet()) {
            winnings += (long) lottoTypeIntegerEntry.getKey().getWinnings() * lottoTypeIntegerEntry.getValue();
        }

        return winnings;
    }

}
