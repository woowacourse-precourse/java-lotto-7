package lotto.model;

import lotto.contants.value.LottoValue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

public class LottoResult {
    private List<Integer> lottoSameSize;

    public LottoResult() {
        lottoSameSize = new ArrayList<>();

        //1~5등 데이터 초기화
        for (int i = 0; i < 5; i++) {
            lottoSameSize.add(0);
        }
    }

    public void updateLottoRankSize(int rank) {
        int rankSize = lottoSameSize.get(rank - 1);
        lottoSameSize.set(rank - 1, rankSize + 1);
    }

    public int getLottoRankSize(int rank) {
        return lottoSameSize.get(rank - 1);
    }
}
