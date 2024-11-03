package lotto.domain;

import static lotto.constant.ExceptionMessage.INVALID_MONEY_UNIT;
import static lotto.constant.LottoConfig.LOTTO_COST;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.constant.Rank;
import lotto.random.LottoRandom;

public class Wallet {

    private final long initialMoney;
    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    private long money;
    private Lottos lottos;

    public Wallet(long money) {
        validateMoney(money);
        this.money = money;
        initialMoney = money;
    }

    public void buyLottoTickets(LottoRandom lottoRandom) {
        long buyCount = money / LOTTO_COST;
        money -= buyCount * LOTTO_COST;
        lottos = Lottos.buy(lottoRandom, buyCount);
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
        rankCounts.merge(rank, 1, Integer::sum);
    }

    public double gain() {
        long totalPrice = rankCounts.entrySet().stream()
            .mapToLong(set -> {
                Rank rank = set.getKey();
                int count = set.getValue();
                return rank.getPrice() * count;
            })
            .sum();
        return (double)totalPrice / initialMoney;
    }

    public Map<Rank, Integer> getRanks() {
        return rankCounts;
    }
}
