package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LottoResult {
    private Map<LottoRank, Integer> lottoResult = new HashMap<>();
    private final int rate;

    public LottoResult(int rate, Map<LottoRank, Integer> lottoResult) {
        this.lottoResult = lottoResult; // lottoResult에 final을 붙이면 안되는 이유
        this.rate = rate;
    }
}
