package lotto.model;

import java.util.List;


public class LottoTicket {
    private List<Lotto> lottos;
    private int price;

    public LottoTicket(List<Lotto> lottos, int price) {
        this.lottos = lottos;
        this.price = price;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getPrice() {
        return price;
    }
}
