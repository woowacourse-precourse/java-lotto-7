package lotto.domain.player;

import static lotto.constant.LottoConfig.LOTTO_COST;

import java.util.List;

import lotto.constant.Rank;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.Lottos;
import lotto.random.LottoRandom;

public class Player {

    private Wallet wallet;
    private Lottos lottos;
    private RankCounts rankCounts;

    public Player(long money) {
        wallet = new Wallet(money);
    }

    public void buyLottos(LottoRandom lottoRandom) {
        long buyCount = wallet.getMoney() / LOTTO_COST;
        wallet = wallet.useMoney(buyCount * LOTTO_COST);
        lottos = Lottos.buy(lottoRandom, buyCount);
        rankCounts = new RankCounts();
    }

    public List<Lotto> getLottos() {
        return lottos.getAll();
    }

    public int getLottoTicketCounts() {
        return lottos.size();
    }

    public void addRank(Rank rank) {
        rankCounts.add(rank);
    }

    public double gain() {
        return (double)rankCounts.totalPrice() / wallet.getInitialMoney();
    }

    public List<RankCounts.RankCount> getRanks() {
        return rankCounts.getAll();
    }
}
