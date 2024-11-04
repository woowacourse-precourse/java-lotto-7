package lotto.business.contract;

import static lotto.Util.tryGetUntilSuccess;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lotto.business.BusinessException;
import lotto.business.LottoPrize;
import lotto.business.Money;
import lotto.io.IOManager;
import lotto.lotto.Lotto;
import lotto.lotto.LottoResult;

public class WoowaContractStrategy implements ContractStrategy {
    private final IOManager ioManager;
    private final Money lottoPrice;

    public WoowaContractStrategy(IOManager ioManager, Money lottoPrice) {
        this.ioManager = ioManager;
        this.lottoPrice = lottoPrice;
    }

    @Override
    public Money askMoney() {
        return tryGetUntilSuccess(this::getMoneyFromUser, this::printLinebreak);
    }

    @Override
    public void printBill(List<Lotto> lotteriesBuy) {
        ioManager.printMessage(lotteriesBuy.size() + "개를 구매했습니다.");
        lotteriesBuy.forEach(lotto -> ioManager.printMessage(lotto.toString()));
        printLinebreak();
    }

    @Override
    public void printResult(List<Lotto> lotteries, LottoResult lottoResult) {
        ioManager.printMessage("당첨 통계");
        ioManager.printMessage("---");
        List<LottoPrize> lottoPrizes = LottoPrize.from(lotteries, lottoResult);
        printWinningPrizes(lottoPrizes);
        printProfitRate(lotteries, lottoPrizes);
    }

    private Money getMoneyFromUser() {
        promptUserToInputMoney();
        Money inputMoney = new Money(getIntFromUser());

        if (!isDivisibleByLottoPrice(lottoPrice)) {
            throw BusinessException.INVALID_MONEY_FOR_PURCHASE.getException();
        }

        return inputMoney;
    }

    private void promptUserToInputMoney() {
        ioManager.printMessage("구입금액을 입력해 주세요.");
    }

    private int getIntFromUser() {
        return ioManager.getUserNumber();
    }

    private boolean isDivisibleByLottoPrice(Money inputMoney) {
        return inputMoney.isDivisibleBy(lottoPrice);
    }

    private void printWinningPrizes(List<LottoPrize> lottoPrizes) {
        Arrays.stream(LottoPrize.values())
                .sorted(Comparator.reverseOrder())
                .filter(lottoPrize -> lottoPrize != LottoPrize.NONE)
                .forEach(targetPrize -> printWinningPrize(targetPrize, lottoPrizes));
    }

    private void printWinningPrize(LottoPrize targetPrize, List<LottoPrize> lottoPrizes) {
        int count = Collections.frequency(lottoPrizes, targetPrize);
        ioManager.printMessage(targetPrize.toString() + " - " + count + "개");
    }

    private void printProfitRate(List<Lotto> lotteries, List<LottoPrize> lottoPrizes) {
        double profitRate = calculateProfitRate(lotteries, lottoPrizes);
        DecimalFormat df = new DecimalFormat("#,##0.0");
        ioManager.printMessage("총 수익률은 " + df.format(profitRate * 100) + "%입니다.");
    }

    private double calculateProfitRate(List<Lotto> lotteries, List<LottoPrize> lottoPrizes) {
        int moneyUsed = lottoPrice.multiply(lotteries.size());
        if (moneyUsed == 0) {
            return 0;
        }

        int totalRewards = LottoPrize.sumOfRewards(lottoPrizes);
        return (double) totalRewards / moneyUsed;
    }

    private void printLinebreak() {
        ioManager.printMessage("");
    }
}
