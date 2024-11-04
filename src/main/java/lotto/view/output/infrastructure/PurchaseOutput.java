package lotto.view.output.infrastructure;

import lotto.view.output.domain.ResultMessage;
import lotto.view.output.service.PurchaseCountViewService;

public class PurchaseOutput implements PurchaseCountViewService {
    public void view(int count) {
        ResultMessage.TICKETS_PURCHASED_COUNT.print(count);
    }
}
