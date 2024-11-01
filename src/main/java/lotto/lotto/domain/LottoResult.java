package lotto.lotto.domain;

import lotto.lotto.domain.value.LottoRank;
import lotto.lotto.domain.value.LottoState;

public class LottoResult {

    private final Lotto lotto;
    private final LottoRank lottoRank;
    private final LottoState lottoState;

    private LottoResult(Lotto lotto, LottoRank lottoRank, LottoState lottoStatus) {
        this.lotto = lotto;
        this.lottoRank = lottoRank;
        this.lottoState = lottoStatus;
    }

    private LottoResult(Lotto lotto, LottoState lottoStatus) {
        this.lotto = lotto;
        this.lottoRank = null;
        this.lottoState = lottoStatus;
    }

    public static LottoResult create(Lotto lotto) {
        return new LottoResult(lotto, LottoState.PENDING);
    }

    public LottoResult updateLottoRank(LottoRank lottoRank) {
        if (this.lottoState.equals(LottoState.MATCHED)) {
            throw new IllegalStateException("[ERROR] 이미 확인된 로또의 등수를 수정할 수 없습니다");
        }
        return new LottoResult(this.lotto, lottoRank, LottoState.MATCHED);
    }


    public Lotto getLotto() {
        return lotto;
    }

    public LottoRank getLottoRank() {
        if (this.lottoRank == null || this.lottoState.equals(LottoState.PENDING)) {
            throw new IllegalStateException("[ERROR] 아직 로또의 등수가 정해지지 않았습니다.");
        }
        return this.lottoRank;
    }

}
