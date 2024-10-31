package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import lotto.util.RandomUtil;

public class Wallet {

    private long money;
    private long originalMoney;
    private List<Rank> ranks = new ArrayList<>();
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
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해야 합니다.\n");
        }
    }

    public List<Lotto> getTickets() {
        return lottos;
    }

    public int getLottoTicketCounts() {
        return lottos.size();
    }

    public void addRank(Rank rank) {
        ranks.add(rank);
    }

    public double gain() {
        int totalPrice = ranks.stream()
            .mapToInt(Rank::getPrice)
            .sum();
        return totalPrice / originalMoney;
    }

    public int getRankCount(int rank) {
        return (int)ranks.stream()
            .filter((rank1 -> rank1.get() == rank))
            .count();
    }
}
