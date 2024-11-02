package lotto.service;

import static lotto.constant.Constant.EMPTY_LINE;
import static lotto.constant.Policy.LOTTO_NUMBER_MAX;
import static lotto.constant.Policy.LOTTO_NUMBER_MIN;
import static lotto.constant.Policy.LOTTO_PRICE;
import static lotto.constant.Policy.LOTTO_PRICE_FORMAT;
import static lotto.constant.Policy.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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

    public void getStatistic(StringBuilder sb) {
        sb.append(Message.PRIZE_STATISTIC);
        Map<Prize, Long> prizes = statisticModel.getPrizes();
        for (Entry<Prize, Long> entry : prizes.entrySet()) {
            Prize prize = entry.getKey();
            Long count = entry.getValue();
            appendResult(sb, prize, count);
        }
    }

    private void appendResult(StringBuilder sb, Prize prize, Long count) {
        sb.append(EMPTY_LINE);
        sb.append(prize.getMatch());
        sb.append(Message.PRIZE_MATCH_MESSAGE);

        if (prize.isBonus()) {
            sb.append(Message.PRIZE_BONUS_MESSAGE);
        }

        sb.append(Message.PRIZE_MONEY_PREFIX);
        sb.append(String.format(LOTTO_PRICE_FORMAT, prize.getMoney()));
        sb.append(Message.PRIZE_MONEY_SUFFIX);

        sb.append(count);
        sb.append(Message.PRIZE_COUNT_SUFFIX);
    }

    public void getProfitRate(StringBuilder sb) {
        sb.append(Message.PROFIT_RATE_PREFIX);
        BigDecimal profitRate = computeProfitRate(statisticModel.getPrizeMoney(), statisticModel.getPurchaseAmount());
        sb.append(profitRate);
        sb.append(Message.PROFIT_RATE_SUFFIX);
    }

    private BigDecimal computeProfitRate(long prizeMoney, PurchaseAmount purchaseAmount) {
        BigDecimal numerator = BigDecimal.valueOf(prizeMoney);
        BigDecimal denominator = BigDecimal.valueOf(purchaseAmount.purchaseAmount());

        return numerator.multiply(BigDecimal.valueOf(100))
                .divide(denominator, 1, RoundingMode.HALF_UP);
    }
}
