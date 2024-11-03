package lotto.model;

import java.util.List;

public class LottoBank {
    public static final int LOTTO_PRICE = 1000;

    public LottoResult evaluate(WinningLotto winningLotto, List<Lotto> myLottos, BonusNumber bonusNumber) {
        List<Prize> prizes = myLottos.stream().map(mLotto -> Prize.getPrize(winningLotto, mLotto, bonusNumber))
                .toList();
        return new LottoResult(prizes);
    }

    public double calculateProfitRate(LottoResult lottoResult, int lottoCount) {
        long totalInvestment = lottoCount * LOTTO_PRICE;
        long totalProfit = lottoResult.getResult().stream().mapToLong(prize -> prize.getMoney()).sum();
        double profitRate = ((double) totalProfit / totalInvestment) * 100;
        return Math.round(profitRate * 100) / 100.0;
    }
}
