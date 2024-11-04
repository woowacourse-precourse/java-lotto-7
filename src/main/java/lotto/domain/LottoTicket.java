package lotto.domain;

import java.util.*;

public class LottoTicket {
    private static final int PRICE_TICKET = 1_000;
    private static final int PRICE_MAX = 100_000;
    private final List<Lotto> lottoTickets = new ArrayList<>();
    private final int price;
    private HashMap<Rank, Integer> result = new HashMap<>();
    private int count;

    public LottoTicket(int price) {
        validatePrice(price);
        this.price = price;
        count = priceChangeToTicket(price);
        initResult();
    }

    public void addLottoTicket(Lotto lotto) {
        lottoTickets.add(lotto);
    }

    public int getCount() {
        return count;
    }

    public int getPrice() {
        return price;
    }

    public List<Lotto> getLottoTickets() {
        return lottoTickets;
    }

    public HashMap<Rank, Integer> getResult() {
        return result;
    }

    public long getProfitSum() {
        long sum = 0;
        for (Rank rank : getResult().keySet()) {
            sum += (long) rank.getPrize() * getResult().get(rank);
        }
        return sum;
    }

    private void initResult() {
        result = new LinkedHashMap<>();
        for (Rank rank : Rank.values()) {
            result.put(rank, 0);
        }
    }

    private void validatePrice(int price) {
        if (price < PRICE_TICKET || price > PRICE_MAX) {
            throw new IllegalArgumentException(" 로또 티켓은 10먼원까지 구입 가능합니다.");
        }
        if (checkMoneyChange(price) != 0) {
            throw new IllegalArgumentException("로또는 1,000원 단위로만 판매 가능합니다.");
        }
    }

    private int priceChangeToTicket(int price) {
        count = price / PRICE_TICKET;
        return count;
    }

    private int checkMoneyChange(int price) {
        return price % PRICE_TICKET;
    }
}
