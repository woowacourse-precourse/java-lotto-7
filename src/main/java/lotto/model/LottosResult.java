package lotto.model;

import java.util.HashMap;

public class LottosResult {
    private final HashMap<LottoRank, Integer> lottosResult;

    public LottosResult() {
        lottosResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.getAllLottoRank(true)) {
            lottosResult.put(lottoRank, 0);
        }
    }

    public Integer get(LottoRank lottoRank) {
        return lottosResult.get(lottoRank);
    }

    public void plus(LottoRank lottoRank) {
        lottosResult.put(lottoRank, get(lottoRank) + 1);
    }

    public double getRateOfReturn() {
        double totalRevenue = 0;
        int totalQuantity = 0;
        for (LottoRank lottoRank : LottoRank.getAllLottoRank(true)) {
            int quantity = get(lottoRank);
            totalRevenue += lottoRank.getWinningAmount() * quantity;
            totalQuantity += quantity;
        }
        return (totalRevenue / totalQuantity) / 10;
    }
}
