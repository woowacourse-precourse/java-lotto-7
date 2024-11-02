package lotto.service;

import static lotto.constant.Constant.EMPTY_LINE;
import static lotto.constant.Policy.LOTTO_NUMBER_MAX;
import static lotto.constant.Policy.LOTTO_NUMBER_MIN;
import static lotto.constant.Policy.LOTTO_PRICE;
import static lotto.constant.Policy.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.Message;
import lotto.entity.IssuedLotto;
import lotto.entity.Lotto;
import lotto.entity.PurchaseAmount;
import lotto.model.LotteryMachineModel;

public class LotteryMachineService {

    private final LotteryMachineModel lotteryMachineModel;

    public LotteryMachineService(LotteryMachineModel lotteryMachineModel) {
        this.lotteryMachineModel = lotteryMachineModel;
    }

    public void buy(StringBuilder sb) {
        PurchaseAmount purchaseAmount = lotteryMachineModel.consumePurchaseAmount();
        long purchaseCount = getPurchaseCount(purchaseAmount);
        sb.append(purchaseCount);
        sb.append(Message.BUY_LOTTO);
        sb.append(EMPTY_LINE);

        issue(purchaseCount, sb);
    }

    private long getPurchaseCount(PurchaseAmount purchaseAmount) {
        return purchaseAmount.purchaseAmount() / LOTTO_PRICE;
    }

    private void issue(long purchaseCount, StringBuilder sb) {
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < purchaseCount; i++) {
            lottos.add(generate());
        }

        IssuedLotto issuedLotto = new IssuedLotto(lottos);
        lotteryMachineModel.settingIssuedLotto(issuedLotto);
        sb.append(issuedLotto);
        sb.append(EMPTY_LINE);
    }

    private Lotto generate() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_SIZE);
        return new Lotto(numbers);
    }
}
