package lotto.application.dto.request;

import java.util.UUID;
import lotto.domain.amount.PurchaseAmount;

public record PurchaseLottoRequest(PurchaseAmount purchaseAmount, UUID buyerId) {

}
