package lotto.model;

import java.util.List;

public class LottoHistory {
    private final WinningLotto winningLotto;
    private final List<Lotto> boughtLottoList;
    private final LottoStatistic lottoStatistic;

    public LottoHistory(WinningLotto winningLotto, List<Lotto> boughtLottoList) {
        this.winningLotto = winningLotto;
        this.boughtLottoList = List.copyOf(boughtLottoList);
        List<LottoRank> rankList = boughtLottoList.stream()
                .map(lotto -> lotto.getRankFrom(winningLotto))
                .toList();
        this.lottoStatistic = new LottoStatistic(rankList);
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public List<Lotto> getBoughtLottoList() {
        return List.copyOf(boughtLottoList);
    }

    public LottoStatistic getLottoStatistic() {
        return lottoStatistic;
    }
}
