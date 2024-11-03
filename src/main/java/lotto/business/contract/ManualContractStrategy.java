package lotto.business.contract;

import static lotto.Util.tryGetUntilSuccess;

import java.util.List;
import lotto.business.BusinessException;
import lotto.business.Money;
import lotto.io.IOManager;
import lotto.lotto.Lotto;

public class ManualContractStrategy implements ContractStrategy {
    private final IOManager ioManager;
    private final Money lottoPrice;

    public ManualContractStrategy(IOManager ioManager, Money lottoPrice) {
        this.ioManager = ioManager;
        this.lottoPrice = lottoPrice;
    }

    @Override
    public Money sellLotto() {
        return tryGetUntilSuccess(this::getMoneyFromUser, this::printLinebreak);
    }

    @Override
    public void printBill(List<Lotto> lotteriesBuy) {
        ioManager.printMessage(lotteriesBuy.size() + "개를 구매했습니다.");
        lotteriesBuy.forEach(lotto -> ioManager.printMessage(lotto.toString()));
        printLinebreak();
    }

    private Money getMoneyFromUser() {
        askUserToInputMoney();
        Money inputMoney = new Money(getIntFromUser());

        if (!isDivisibleByLottoPrice(lottoPrice)) {
            throw BusinessException.INVALID_MONEY_FOR_PURCHASE.getException();
        }

        return inputMoney;
    }

    private void askUserToInputMoney() {
        ioManager.printMessage("구입금액을 입력해 주세요.");
    }

    private int getIntFromUser() {
        return ioManager.getUserNumber();
    }

    private boolean isDivisibleByLottoPrice(Money inputMoney) {
        return inputMoney.isDivisibleBy(lottoPrice);
    }

    private void printLinebreak() {
        ioManager.printMessage("");
    }
}
