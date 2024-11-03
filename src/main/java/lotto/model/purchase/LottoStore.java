package lotto.model.purchase;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;

public class LottoStore {
    private final int lottoPrice;
    private final LottoGenerator lottoGenerator;
    private final PurchaseAmountValidator purchaseAmountValidator;

    public LottoStore(int lottoPrice, LottoGenerator lottoGenerator) {
        this.lottoPrice = lottoPrice;
        this.lottoGenerator = lottoGenerator;
        this.purchaseAmountValidator = new PurchaseAmountValidator(lottoPrice);
    }

    public List<Lotto> purchaseLottoTickets(int amount) {
        purchaseAmountValidator.validate(amount);
        int numberOfTickets = amount / lottoPrice;
        return generateTickets(numberOfTickets);
    }

    private List<Lotto> generateTickets(int numberOfTickets) {
        return IntStream.range(0, numberOfTickets)
                .mapToObj(i -> lottoGenerator.generate())
                .toList();
    }
}
