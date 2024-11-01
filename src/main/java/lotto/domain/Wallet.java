package lotto.domain;

import static lotto.constant.ExceptionMessage.INVALID_MONEY_UNIT;

import java.util.ArrayList;
import java.util.List;

import lotto.constant.RankPrice;
import lotto.util.RandomUtil;

public class Wallet {

    private long money;
    private long originalMoney;
    private List<RankPrice> ranks = new ArrayList<>();
    private final List<Lotto> lottos = new ArrayList<>();

    public Wallet(long money) {
        validateMoney(money);
        this.money = money;
        originalMoney = money;
    }

    public void buyLottoTickets() {
        long ticketCount = money / 1000;
        money -= ticketCount * 1000;
        while (ticketCount-- > 0) {
            lottos.add(new Lotto(RandomUtil.getLottoNumbers()));
        }
    }

    private void validateMoney(long money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_UNIT.getMessage(1000));
        }
    }

    public List<Lotto> getTickets() {
        return lottos;
    }

    public int getLottoTicketCounts() {
        return lottos.size();
    }

    public void addRank(RankPrice rankPrice) {
        ranks.add(rankPrice);
    }

    public double gain() {
        long totalPrice = ranks.stream()
            .mapToLong(RankPrice::getPrice)
            .sum();
        return totalPrice / originalMoney;
    }

    public int getRankCount(int rank) {
        return (int)ranks.stream()
            .filter((rank1 -> rank1.getRank() == rank))
            .count();
    }
}
