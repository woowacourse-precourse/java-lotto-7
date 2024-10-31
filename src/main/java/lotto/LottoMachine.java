package lotto;

import lotto.exception.LottoException;
import lotto.exception.MoneyException;
import lotto.io.reader.MoneyReader;
import lotto.io.reader.LottoNumberReader;
import lotto.io.printer.LottoPrinter;
import lotto.io.printer.ResultPrinter;
import lotto.io.printer.DefaultPrinter;
import lotto.util.calculator.LottoCalculator;
import lotto.util.generator.LottoGenerator;
import lotto.util.calculator.LottoPrizeCalculator;

import java.util.ArrayList;
import java.util.List;


public class LottoMachine {

    private final Money money;
    private final Lotto winningLotto;
    private final BonusNumber bonusNumber;
    private final List<Lotto> purchaseLottos;

    private LottoMachine(Money money, Lotto winningLotto, BonusNumber bonusNumber, List<Lotto> purchaseLottos) {
        this.money = money;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        this.purchaseLottos = purchaseLottos;
    }

    public static LottoMachine create() {
        // 구매
        Money money = putMoney();
        List<Lotto> lottos = purchaseLottos(money);

        // 구매 로또 출력
        showAllPurchaseLottos(lottos);

        // 당첨번호 등록
        Lotto winningLotto = registerWinningLotto();

        // 보너스 번호 등록
        BonusNumber bonusNumber = registerBonusNumber();
        return new LottoMachine(money, winningLotto, bonusNumber, lottos);
    }

    private static Money putMoney() {
        boolean isPurchaseSuccess = true;
        Money money = null;
        do {
            long amount = MoneyReader.readMoney();
            try {
                money = new Money(amount);
            } catch (MoneyException exception) {
                DefaultPrinter.printLine(exception.getMessage());
                isPurchaseSuccess = false;
            }
        } while (!isPurchaseSuccess);
        return money;
    }

    private static List<Lotto> purchaseLottos(Money money) {
        long numberOfAbleToPurchase = LottoCalculator.getNumberOfAbleToPurchase(money.getAmount());
        LottoPrinter.printLottoQuantity(numberOfAbleToPurchase);

        List<Lotto> lottos = new ArrayList<>();
        for (long number = 0L; number < numberOfAbleToPurchase; number++) {
            Lotto autoLotto = LottoGenerator.generateAutoLotto();
            lottos.add(autoLotto);
        }
        return lottos;
    }

    private static void showAllPurchaseLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            LottoPrinter.printLotto(lotto);
        }
    }

    private static Lotto registerWinningLotto(){
        boolean isRegisterSuccess = true;
        Lotto lotto = null;
        do {
            List<Integer> numbers = LottoNumberReader.readWinningNumbers();
            try {
                lotto = LottoGenerator.generateLotto(numbers);
            } catch (LottoException exception) {
                DefaultPrinter.printLine(exception.getMessage());
                isRegisterSuccess = false;
            }
        } while (!isRegisterSuccess);
        return lotto;
    }

    private static BonusNumber registerBonusNumber(){
        boolean isRegisterSuccess = true;
        BonusNumber bonusNumber = null;
        do {
            Integer number = LottoNumberReader.readBonusNumber();
            try {
                bonusNumber = new BonusNumber(number);
            } catch (LottoException exception) {
                DefaultPrinter.printLine(exception.getMessage());
                isRegisterSuccess = false;
            }
        } while (!isRegisterSuccess);
        return bonusNumber;
    }

    public void showResult() {
        ResultPrinter.printResultHeader();

        // 결과 연산
        List<LottoPrize> lottoPrizes = new ArrayList<>();
        for (Lotto lotto : purchaseLottos) {
            LottoPrize prize = LottoPrizeCalculator.calculatePrize(winningLotto, bonusNumber, lotto);
            lottoPrizes.add(prize);
        }

        // 결과 출력
        showTotalPrizeResult(lottoPrizes);
        showTotalProfitResult(lottoPrizes);
    }

    private void showTotalPrizeResult(List<LottoPrize> prizes) {
        long totalCountOfMatchThree = getTotalCountOf(LottoPrize.MATCH_THREE, prizes);
        ResultPrinter.printPrizeResult(LottoPrize.MATCH_THREE, totalCountOfMatchThree);

        long totalCountOfMatchFour = getTotalCountOf(LottoPrize.MATCH_FOUR, prizes);
        ResultPrinter.printPrizeResult(LottoPrize.MATCH_FOUR, totalCountOfMatchFour);

        long totalCountOfMatchFive = getTotalCountOf(LottoPrize.MATCH_FIVE, prizes);
        ResultPrinter.printPrizeResult(LottoPrize.MATCH_FIVE, totalCountOfMatchFive);

        long totalCountOfMatchFiveWithBonus = getTotalCountOf(LottoPrize.MATCH_FIVE_AND_BONUS, prizes);
        ResultPrinter.printPrizeResult(LottoPrize.MATCH_FIVE_AND_BONUS, totalCountOfMatchFiveWithBonus);

        long totalCountOfMatchSix = getTotalCountOf(LottoPrize.MATCH_SIX, prizes);
        ResultPrinter.printPrizeResult(LottoPrize.MATCH_SIX, totalCountOfMatchSix);
    }

    private long getTotalCountOf(LottoPrize targetPrize, List<LottoPrize> prizes) {
        return LottoPrizeCalculator.countPrizeCount(targetPrize, prizes);
    }

    private void showTotalProfitResult(List<LottoPrize> prizes) {
        long winningMoney = 0L;
        for (LottoPrize prize : prizes) {
            winningMoney += prize.getAmount();
        }
        double totalProfit = LottoPrizeCalculator.calculateProfit(winningMoney, money.getAmount());
        ResultPrinter.printTotalProfit(totalProfit);
    }

}
