package lotto;

import lotto.controller.BonusNumberController;
import lotto.controller.LotteryMachineController;
import lotto.controller.PurchaseAmountController;
import lotto.controller.WinnerNumberController;
import lotto.injection.ObjectFactory;

public class Application {
    public static void main(String[] args) {
        ObjectFactory objectFactory = new ObjectFactory();

        PurchaseAmountController purchaseAmountController = objectFactory.purchaseAmountController();
        purchaseAmountController.run();

        WinnerNumberController winnerNumberController = objectFactory.winnerNumberController();
        winnerNumberController.run();

        BonusNumberController bonusNumberController = objectFactory.bonusNumberController();
        bonusNumberController.run();

        LotteryMachineController lotteryMachineController = objectFactory.lotteryMachineController();
        lotteryMachineController.run();
    }
}
