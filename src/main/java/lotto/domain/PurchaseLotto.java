package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PurchaseLotto {

    private final List<Lotto> tickets;

    public PurchaseLotto(List<Lotto> tickets) {
        this.tickets = tickets;
    }

    public static PurchaseLotto of(PurchasePrice purchasePrice, NumberGenerator lottoNumberGenerator) {
        int purchaseCount = purchasePrice.calculatePurchaseCount();

        List<Lotto> lottoList = IntStream.range(0, purchaseCount)
                .mapToObj(i -> new Lotto(lottoNumberGenerator.generate()))
                .collect(Collectors.toList());

        return new PurchaseLotto(lottoList);
    }

    public int getLottoCount() {
        return tickets.size();
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
