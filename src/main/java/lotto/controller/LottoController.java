package lotto.controller;

import lotto.domain.LottoResult;
import lotto.dto.Result;
import lotto.domain.LotteryMachine;
import lotto.domain.User;
import lotto.view.InputView;
import lotto.view.outputView;

public class LottoController {
    private LotteryMachine lotteryMachine;
    private User user;

    public LottoController() {
        lotteryMachine = new LotteryMachine();
    }
    public void run() {
        startLottoPurchase();
        checkLottery();
        showLottoPrizeResult();
    }

    public void startLottoPurchase() {
        while(true) {
            try {
                user = new User(InputView.inputPurchaseAmount());
                lotteryMachine.purchaseLottoTickets(user);
                outputView.printPurchasedLottoTickets(user.getBag());
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void checkLottery() {
        while(true) {
            try{
                Result result = InputView.inputWinningNumbers();
                InputView.inputBonusNumber(result);
                lotteryMachine.checkLottery(user,result);
                break;
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public void showLottoPrizeResult() {
        LottoResult lottoResult = user.getLottoResult();
        long totalPrize = lottoResult.calculateLottoPrize();
        outputView.printLottoResult(lottoResult);
        outputView.showRateOfReturn(user.getPurchaseAmount(),totalPrize);
    }
}
