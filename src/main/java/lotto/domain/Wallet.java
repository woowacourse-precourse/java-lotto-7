package lotto.domain;

import static lotto.constant.ExceptionMessage.INVALID_MONEY_UNIT;
import static lotto.constant.LottoConfig.LOTTO_COST;

import java.util.List;

import lotto.constant.Rank;
import lotto.domain.lotto.Lotto;
import lotto.random.LottoRandom;

public class Wallet {

    private final long initialMoney;
    private long money;
    private Lottos lottos;
    private RankCounts rankCounts;

    public Wallet(long money) {
        validateMoney(money);
        this.money = money;
        initialMoney = money;
    }

    public void buyLottoTickets(LottoRandom lottoRandom) {
        long buyCount = money / LOTTO_COST;
        money -= buyCount * LOTTO_COST;
        lottos = Lottos.buy(lottoRandom, buyCount);
        rankCounts = new RankCounts();
    }

    private void validateMoney(long money) {
        if (money % LOTTO_COST != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
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
        return (double)rankCounts.totalPrice() / initialMoney;
    }

    public List<RankCounts.RankCount> getRanks() {
        return rankCounts.getAll();
    }
}
