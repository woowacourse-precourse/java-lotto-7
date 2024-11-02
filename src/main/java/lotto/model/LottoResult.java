package lotto.model;

import lotto.contants.value.LottoValue;

import java.util.ArrayList;
import java.util.List;

public class LottoResult {
    private final List<Integer> lottoSameSize;

    public LottoResult() {
        lottoSameSize = new ArrayList<>();

        //1~5등 데이터 초기화
        for (int i = 0; i < 5; i++) {
            lottoSameSize.add(0);
        }
    }

    public List<Integer> getLottoSameSize() {
        return this.lottoSameSize;
    }

    public void updateLottoRankSize(int rank) {
        int rankSize = lottoSameSize.get(rank - 1);
        lottoSameSize.set(rank - 1, rankSize + 1);
    }

    public int calculPrizeMoney() {
        int sum = 0;

        sum += lottoSameSize.get(0) * LottoValue.RANK_FIRST_PRIZE.getValue();
        sum += lottoSameSize.get(1) * LottoValue.RANK_SECOND_PRIZE.getValue();
        sum += lottoSameSize.get(2) * LottoValue.RANK_THRID_PRIZE.getValue();
        sum += lottoSameSize.get(3) * LottoValue.RANK_FOURTH_PRIZE.getValue();
        sum += lottoSameSize.get(4) * LottoValue.RANK_FIFTH_PRIZE.getValue();

        return sum;
    }
}
