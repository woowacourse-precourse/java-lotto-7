package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.model.Judge;
import lotto.model.Lotto;
import lotto.model.LottoGenerator;
import lotto.model.ProfitCalculator;
import lotto.util.Grade;
import lotto.view.OutputView;

public class LotteryMachine {
    static final int PRICE = 1000;

    private final InputHandler inputHandler;
    private final ProfitCalculator profitCalculator;
    private Judge judge;

    public LotteryMachine(InputHandler inputHandler, ProfitCalculator profitCalculator) {
        this.inputHandler = inputHandler;
        this.profitCalculator = profitCalculator;
    }

    public void run() {
        final int purchasePrice = requirePurchasePriceProcess();;
        final List<Lotto> lottos = issueLottosProcess(purchasePrice);
        OutputView.printPurchasedLottos(lottos);

        final Lotto winning = requireWinningNumbersProcess();
        final int bonus = requireBonusNumberProcess();
        judge = Judge.from(lottos,winning,bonus);
        final EnumMap<Grade, Integer> gradeWithCount = judge.allJudgedGrade();
        OutputView.printResultScore(gradeWithCount);

        final Double profit = profitCalculator.calculateProfit(gradeWithCount, purchasePrice);
        OutputView.printProfitPercentage(profit);
    }

    private int requirePurchasePriceProcess(){
        while (true) {
            try {
                OutputView.printRequirePurchasePrice();
                final int purchaseAmount = inputHandler.readPurchaseAmount();
                validateDivisible(purchaseAmount);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> issueLottosProcess(final int purchasePrice) {
        while (true) {
            try {
                final int lottoCount = LottoGenerator.purchasableLottoCount(purchasePrice, PRICE);
                return LottoGenerator.issueLottos(lottoCount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto requireWinningNumbersProcess() {
        while (true) {
            try {
                OutputView.printRequireWinningNumbers();
                return inputHandler.readWinningNumber();
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int requireBonusNumberProcess() {
        while (true) {
            try {
                OutputView.printRequireBonusNumber();
                return inputHandler.readBonusNumber();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void validateDivisible(final int paymentAmount) {
        if(paymentAmount % PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 "+ PRICE +" 단위로 입력해야 합니다.");
        }
    }
}
