package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoResult {

    private final List<LottoRankType> lottoRankTypes;

    private LottoResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        lottoRankTypes = new ArrayList<>();
    }

    public static LottoResult of(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        return new LottoResult(lottos, winningNumbers, bonusNumber);
    }

    public List<LottoRankType> getLottoRankTypes() {
        return Collections.unmodifiableList(lottoRankTypes);
    }

}