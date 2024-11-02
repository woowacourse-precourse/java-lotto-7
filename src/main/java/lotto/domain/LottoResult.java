package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {

    private final List<LottoRankType> lottoRankTypes;

    private LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        lottoRankTypes = new ArrayList<>();
        calculateLottoRanks(lottos, winningNumbers, bonusNumber);
    }

    public static LottoResult of(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }

    public List<LottoRankType> getLottoRankTypes() {
        return Collections.unmodifiableList(lottoRankTypes);
    }

    private void calculateLottoRanks(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            calculateRankForLotto(lotto.getNumbers(), winningNumbers, bonusNumber);
        }
    }

    private void calculateRankForLotto(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
        }
        boolean hasBonusNumber = containsBonusNumber(lottoNumbers, bonusNumber);
        lottoRankTypes.add(LottoRankType.of(matchCount, hasBonusNumber));
    }

    private boolean containsBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

}