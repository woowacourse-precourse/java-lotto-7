package lotto.service;

import static lotto.constant.Policy.LOTTO_PRICE;

import lotto.constant.Message;
import lotto.entity.PurchaseAmount;
import lotto.model.LotteryMachineModel;

public class LotteryMachineService {

    private final LotteryMachineModel lotteryMachineModel;

    public LotteryMachineService(LotteryMachineModel lotteryMachineModel) {
        this.lotteryMachineModel = lotteryMachineModel;
    }

    public void buy(StringBuilder sb) {
        PurchaseAmount purchaseAmount = lotteryMachineModel.getPurchaseAmount();
        sb.append(getPurchaseCount(purchaseAmount));
        sb.append(Message.BUY_LOTTO);
    }

    private long getPurchaseCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.purchaseAmount() / LOTTO_PRICE;
    }
}
