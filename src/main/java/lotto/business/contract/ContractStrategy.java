package lotto.business.contract;

import java.util.List;
import lotto.business.Money;
import lotto.lotto.Lotto;

public interface ContractStrategy {
    Money sellLotto();

    void printBill(List<Lotto> lotteriesBuy);
}
