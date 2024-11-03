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
    private int purchaseAmount;
    private double returnOfRate;

    private Member() {
        issuedLottos = new ArrayList<>();
        lottoResults = new EnumMap<>(LottoRank.class);
        initializeLottoResults();
    }

    // 생성 메서드
    private void initializeLottoResults() {
        for (LottoRank rank : LottoRank.values()) {
            lottoResults.put(rank, 0);
        }
    }

    // 비즈니스 로직
    public void saveIssuedLotto(Lotto lotto) {
        issuedLottos.add(lotto);
    }

    public void addLottoResult(LottoRank lottoRank) {
        lottoResults.put(lottoRank, lottoResults.get(lottoRank) + 1);
    }

    public void savePurchaseAmount(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public void saveReturnOfRate(double returnOfRate) {
        this.returnOfRate = returnOfRate;
    }

    // GETTER
    public static Member getInstance() {
        return instance;
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }

    public Map<LottoRank, Integer> getLottoResults() {
        return lottoResults;
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public double getReturnOfRate() {
        return returnOfRate;
    }
}
