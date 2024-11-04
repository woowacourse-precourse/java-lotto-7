package lotto.service.purchase;

import lotto.domain.LottoPurchase;
import lotto.service.NumbersSelector;

public interface PurchaseService {

    LottoPurchase purchase(int payAmount);
}
