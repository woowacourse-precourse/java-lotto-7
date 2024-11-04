package lotto.service;

import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lotto;
import lotto.model.LottoIssuer;
import lotto.model.PurchaseAmount;

public class LottoIssuingService {

    private final LottoIssuer lottoIssuer;

    public LottoIssuingService(LottoIssuer lottoIssuer) {
        this.lottoIssuer = lottoIssuer;
    }

    public List<Lotto> issueForAmount(PurchaseAmount purchaseAmount) {
        int purchaseQuantity = purchaseAmount.getPurchaseQuantity();
        return IntStream.range(0, purchaseQuantity)
                .mapToObj(ignored -> lottoIssuer.issue())
                .toList();
    }
}
