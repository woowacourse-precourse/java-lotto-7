package lotto.business.contract;

import java.util.List;
import lotto.business.Money;
import lotto.lotto.Lotto;

/**
 * <code>ContractStrategy</code> is an interface that provides the strategy to interact with <b>client</b>.
 *
 * @see lotto.business.Money
 * @see lotto.lotto.Lotto
 */
public interface ContractStrategy {
    /**
     * Sell the <code>Lotto</code>.
     *
     * @return the <code>Money</code> after selling the <code>Lotto</code>
     */
    Money sellLotto();

    /**
     * Print the bill.
     *
     * @param lotteriesBuy the <code>Lotto</code>s to print result
     */
    void printBill(List<Lotto> lotteriesBuy);
}
