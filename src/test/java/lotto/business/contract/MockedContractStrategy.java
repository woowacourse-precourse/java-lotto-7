package lotto.business.contract;

import java.util.List;
import lotto.business.Money;
import lotto.io.IOManager;
import lotto.lotto.Lotto;

/**
 * Implementation of <code>ContractStrategy</code> that can be used for testing.
 * <p>
 * <ul>
 *   <li>Set <code>payedMoney</code> to the desired return value before calling the <code>sellLotto</code>.</li>
 *   <li>Get <code>ioManager</code> to the desired output value after calling the <code>printBill</code>.</li>
 * </ul>
 * <p>
 * The method call history is stored in the corresponding field.
 * <ul>
 *   <li>Method call count is stored in <code>methodCallCount</code>.</li>
 *   <li>Last argument passed to method is stored in <code>methodLastCalledWith</code>.</li>
 * </ul>
 *
 * @see ContractStrategy
 */
public class MockedContractStrategy implements ContractStrategy {
    private final IOManager ioManager;
    public int payedMoney;
    public int sellLottoCallCount = 0;
    public int printBillCallCount = 0;
    public List<Lotto> printBillLastCalledWith = null;

    public MockedContractStrategy(IOManager ioManager) {
        this.ioManager = ioManager;
    }

    @Override
    public Money sellLotto() {
        sellLottoCallCount++;

        return new Money(payedMoney);
    }

    @Override
    public void printBill(List<Lotto> lotteriesBuy) {
        printBillCallCount++;
        printBillLastCalledWith = lotteriesBuy;

        ioManager.printMessage(lotteriesBuy.size() + "개를 구매했습니다.");
        lotteriesBuy.forEach(lotto -> ioManager.printMessage(lotto.toString()));
        ioManager.printMessage("");
    }
}
