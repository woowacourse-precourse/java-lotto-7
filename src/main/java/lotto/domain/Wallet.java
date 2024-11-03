package lotto.domain;

import static lotto.constant.ExceptionMessage.INVALID_MONEY_UNIT;
import static lotto.constant.LottoConfig.LOTTO_COST;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.constant.Rank;
import lotto.random.LottoRandom;

public class Wallet {

    private final List<Lotto> lottos = new ArrayList<>();
    private final Map<Rank, Integer> rankCounts = new EnumMap<>(Rank.class);

    private long money;
    private long initalMoney;

    public Wallet(long money) {
        validateMoney(money);
        this.money = money;
        initalMoney = money;
    }

    public void buyLottoTickets(LottoRandom strategy) {
        long ticketCount = money / LOTTO_COST;
        money -= ticketCount * LOTTO_COST;
        while (ticketCount-- > 0) {
            lottos.add(new Lotto(strategy.getLottoNumbers()));
        }
    }

    private void validateMoney(long money) {
        if (money % LOTTO_COST != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
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
        return (double)totalPrice / initalMoney;
    }

    public Map<Rank, Integer> getRanks() {
        return rankCounts;
    }
}
