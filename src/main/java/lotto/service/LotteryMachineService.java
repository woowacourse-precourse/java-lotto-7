package lotto.service;

import static lotto.constant.Constant.EMPTY_LINE;
import static lotto.constant.Policy.LOTTO_NUMBER_MAX;
import static lotto.constant.Policy.LOTTO_NUMBER_MIN;
import static lotto.constant.Policy.LOTTO_PRICE;
import static lotto.constant.Policy.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lotto.constant.Message;
import lotto.entity.BonusNumber;
import lotto.entity.IssuedLotto;
import lotto.entity.Lotto;
import lotto.entity.Prize;
import lotto.entity.PurchaseAmount;
import lotto.entity.WinnerNumber;
import lotto.model.LotteryMachineModel;
import lotto.model.StatisticModel;

public class LotteryMachineService {

    private final LotteryMachineModel lotteryMachineModel;
    private final StatisticModel statisticModel;

    public LotteryMachineService(LotteryMachineModel lotteryMachineModel, StatisticModel statisticModel) {
        this.lotteryMachineModel = lotteryMachineModel;
        this.statisticModel = statisticModel;
    }

    public void buy(StringBuilder sb) {
        PurchaseAmount purchaseAmount = lotteryMachineModel.consumePurchaseAmount();
        statisticModel.setPurchaseAmount(purchaseAmount);

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

    public void check() {
        WinnerNumber winnerNumber = lotteryMachineModel.getWinnerNumber();
        BonusNumber bonusNumber = lotteryMachineModel.getBonusNumber();
        IssuedLotto issuedLotto = lotteryMachineModel.getIssuedLotto();

        for (Lotto lotto : issuedLotto.lottos()) {
            compare(winnerNumber.numbers(), bonusNumber.number(), lotto.getNumbers());
        }
    }

    private void compare(List<Integer> winnerNumbers, Integer BonusNumber, List<Integer> lotto) {
        int match = 0;
        boolean bonus = false;
        for (Integer number : lotto) {
            if (winnerNumbers.contains(number)) {
                match++;
            }
            if (BonusNumber.equals(number)) {
                bonus = true;
            }
        }

        savePrize(match, bonus);
    }

    private void savePrize(int match, boolean bonus) {
        Optional<Prize> prize = Prize.getPrize(match, bonus);
        prize.ifPresent(statisticModel::add);
    }
}
