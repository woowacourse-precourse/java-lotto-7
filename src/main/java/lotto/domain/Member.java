package lotto.domain;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.lotto.LottoRank;

public class Member {

    private static final Member instance = new Member();
    private final List<Lotto> issuedLottos;
    private final Map<LottoRank, Integer> lottoResults;

    private Member() {
        issuedLottos = new ArrayList<>();
        lottoResults = new EnumMap<>(LottoRank.class);
        initializeLottoResults();
    }

    private void initializeLottoResults() {
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.put(rank, 0);
        }
    }

    public static Member getInstance() {
        return instance;
    }

    public void saveIssuedLotto(Lotto lotto) {
        issuedLottos.add(lotto);
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }

    public void addLottoResult(LottoRank lottoRank) {
        lottoResults.put(lottoRank, lottoResults.get(lottoRank) + 1);
    }

    public Map<LottoRank, Integer> getLottoResults() {
        return lottoResults;
    }
}
