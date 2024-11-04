package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoMaker;
import lotto.domain.LottoMatcher;
import lotto.domain.WinningNumber;
import lotto.domain.WinningNumberMaker;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoMachineController {

    private final LottoMaker lottoMaker;
    private final WinningNumberMaker winningNumberMaker;

    private final LottoMatcher lottoMatcher;


    public LottoMachineController(LottoMaker lottoMaker, WinningNumberMaker winningNumberMaker,
                                  LottoMatcher lottoMatcher) {
        this.lottoMaker = lottoMaker;
        this.winningNumberMaker = winningNumberMaker;
        this.lottoMatcher = lottoMatcher;

    }

    public void run() {
        int amount = getPurchaseAmount();
        List<Lotto> lotteries = createLottoMachine(amount);
        OutputView.outputTicketCountAndLotteries(lotteries);
        WinningNumber winningNumber = createWinningNumber();
        lottoResult(lotteries, winningNumber, amount);

    }

    private int getPurchaseAmount() {
        while (true) {
            try {
                return LottoMaker.transInputToInt(InputView.inputPurchaseAmount());
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Lotto> createLottoMachine(int amount) {
        return lottoMaker.generateLotteries(amount);
    }


    private WinningNumber createWinningNumber() {

        while (true) {
            try {
                winningNumberMaker.setWinningNumber(InputView.inputWinningNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                winningNumberMaker.setBonusNumber(InputView.inputBonusNumber());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return winningNumberMaker.getWinningNumber();

    }

    private void lottoResult(List<Lotto> lotteries, WinningNumber winningNumber, int totalspent) {
        lottoMatcher.matcher(lotteries, winningNumber, totalspent);
    }

}
