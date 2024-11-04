package lotto.business.contract;

import java.util.List;
import lotto.business.Money;
import lotto.lotto.Lotto;
import lotto.lotto.LottoResult;

/**
 * <code>ContractStrategy</code> is an interface that provides the strategy to interact with <b>client</b>.
 *
 * @see lotto.business.Money
 * @see lotto.lotto.Lotto
 */
public interface ContractStrategy {
    /**
     * Ask money for the <code>Lotto</code>.
     *
     * @return the <code>Money</code> paid by the client
     */
    Money askMoney();

    /**
     * Print the bill.
     *
     * @param lotteriesBuy the <code>Lotto</code>s to print result
     */
    void printBill(List<Lotto> lotteriesBuy);

    /**
     * Print the result(lottery rewards).
     *
     * @param lotteries   the <code>Lotto</code>s bought
     * @param lottoResult the <code>LottoResult</code> drawn
     */
    void printResult(List<Lotto> lotteries, LottoResult lottoResult);
}
