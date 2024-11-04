package lotto.business.contract;

import java.util.List;
import lotto.business.Money;
import lotto.io.IOManager;
import lotto.lotto.Lotto;

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
