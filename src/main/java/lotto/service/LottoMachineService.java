package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.PurchasedLottos;
import lotto.model.WinningLotto;
import lotto.view.LottoMachineView;

import java.util.Collections;
import java.util.List;

public class LottoMachineService {
    PurchasedLottos purchasedLottos;
    WinningLotto winningLotto;

    public LottoMachineService() {
        purchasedLottos = new PurchasedLottos();
    }

    public void purchaseLotto() {
        makeLotto(readPurchaseLotto());
        LottoMachineView.printPurchasedLottosView(purchasedLottos);
    }

    private int readPurchaseLotto() {
        LottoMachineView.printPurchaseLottoView();
        String input = Console.readLine();
        int purchaseAmount = InputHandler.purchaseLottoHandle(input);

        return purchaseTicketAmount(purchaseAmount);
    }

    private int purchaseTicketAmount(int purchaseAmount) {
        if ( purchaseAmount < 1000 ) {
            throw new IllegalArgumentException("[ERROR] 한 장 이상 구매해야 합니다");
        }
        if ( purchaseAmount % 1000 != 0 ) {
            throw new IllegalArgumentException("[ERROR] 천원 단위로만 구매할 수 있습니다");
        }

        return purchaseAmount / 1000;
    }

    private void makeLotto(int purchaseAmount) {
        for ( int i = 0; i < purchaseAmount; i++ ) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(lotto.getNumbers());
            purchasedLottos.add(lotto);
        }
    }

    public void enterWinningNumbers() {
        winningLotto = readEnterWinningNumbers();
    }

    private WinningLotto readEnterWinningNumbers() {
        LottoMachineView.printEnterWinningNumbersView();
        String winningNumber = Console.readLine();
        List<Integer> winningNumbers = InputHandler.enterWinningNumbersHandle(winningNumber);

        LottoMachineView.printEnterBonusWinningNumberView();
        String bonusNumber = Console.readLine();
        int handledBonusNumber = InputHandler.enterBonusNumberHandle(bonusNumber);
        return new WinningLotto(winningNumbers, handledBonusNumber);
    }

//    private void calculateWinnings() {
//        //당첨로직
//    }
//
//    private void getStats() {
//        //통계로직
//    }
//
//    public void printStats() {
//        LottoMachineView.printStatisticsView();
//    }
}
