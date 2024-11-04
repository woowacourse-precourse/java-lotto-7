package controlloer;

import input.BonusNumberInputProcessor;
import input.LottoPurchaseAmountInputProcessor;
import input.LottoWinnerNumberInputProcessor;
import java.util.ArrayList;
import lotto.Lotto;
import lotto.LottoBuyer;
import lotto.LottoVendingMachine;
import lotto.RevenueRateComputer;
import lotto.WinnerManager;
import validation.BonusNumberValidator;
import validation.LottoPurchaseAmountValidator;

public class LottoGameController {

    private final LottoBuyer lottoBuyer;
    private final WinnerManager winnerManager;
    private final RevenueRateComputer revenueRateComputer;

    public LottoGameController(){
        lottoBuyer = lottoBuyerGenerator();
        winnerManager = winnerManagerGenerator();
        revenueRateComputer = new RevenueRateComputer();
    }

    public LottoBuyer lottoBuyerGenerator() {
        LottoPurchaseAmountValidator lottoPurchaseAmountValidator = new LottoPurchaseAmountValidator();
        LottoPurchaseAmountInputProcessor lottoPurchaseAmountInputProcessor
                = new LottoPurchaseAmountInputProcessor(lottoPurchaseAmountValidator);
        LottoVendingMachine lottoVendingMachine = new LottoVendingMachine();
        return new LottoBuyer(lottoPurchaseAmountInputProcessor, lottoVendingMachine);

    }

    public WinnerManager winnerManagerGenerator(){
        LottoWinnerNumberInputProcessor lottoWinnerNumberInputProcessor = new LottoWinnerNumberInputProcessor();
        BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
        BonusNumberInputProcessor bonusNumberInputProcessor = new BonusNumberInputProcessor(bonusNumberValidator);
        return new WinnerManager(lottoWinnerNumberInputProcessor, bonusNumberInputProcessor);
    }

    public void run(){
        ArrayList<Lotto> buyLottoTickets;
        buyLottoTickets = lottoBuyer.purchaseLotto();
        winnerManager.registerWinnerLotto();
        winnerManager.rankClassification(buyLottoTickets);
        winnerManager.rankStatistic();
        winnerManager.printRankStatistic();
        long totalRevenue = winnerManager.computeTotalRevenue();
        int boughtTicketCount = lottoBuyer.ownLottoTicketCount();
        revenueRateComputer.printRevenueRate(totalRevenue, boughtTicketCount);
    }
}
