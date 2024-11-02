package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.*;
import lotto.model.enums.ErrorMessage;
import lotto.model.enums.LottoConstants;
import lotto.view.LottoMachineView;

import java.util.List;

public class LottoMachineService {
    PurchasedLottos purchasedLottos;
    WinningLotto winningLotto;
    PurchasedLottosResult purchasedLottosResult;

    public LottoMachineService() {
        purchasedLottos = new PurchasedLottos();
        purchasedLottosResult = new PurchasedLottosResult();
    }

    public void purchaseLotto() {
        while ( true ) {
            try {
                makeLotto(readPurchaseLotto());
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        LottoMachineView.printPurchasedLottosView(purchasedLottos);
    }

    private int readPurchaseLotto() {
        LottoMachineView.printPurchaseLottoView();
        String input = Console.readLine();
        int purchaseAmount = InputHandler.purchaseLottoHandle(input);

        return purchaseTicketAmount(purchaseAmount);
    }

    private int purchaseTicketAmount(int purchaseAmount) {
        if ( purchaseAmount < LottoConstants.LOTTO_TICKET_PRICE.getValue() ) {
            throw new IllegalArgumentException(ErrorMessage.MUST_BUY_ONE_MORE.getMessage());
        }
        if ( purchaseAmount % LottoConstants.LOTTO_TICKET_PRICE.getValue() != 0 ) {
            throw new IllegalArgumentException(ErrorMessage.THOUSAND_UNIT_ONLY.getMessage());
        }

        return purchaseAmount / LottoConstants.LOTTO_TICKET_PRICE.getValue();
    }

    private void makeLotto(int purchaseAmount) {
        for ( int i = 0; i < purchaseAmount; i++ ) {
            List<Integer> numbers =
                    Randoms.pickUniqueNumbersInRange(
                            LottoConstants.LOTTO_BEGIN_NUMBER.getValue(),
                            LottoConstants.LOTTO_END_NUMBER.getValue(),
                            LottoConstants.LOTTO_NUMBERS_SIZE.getValue());

            purchasedLottos.add(new Lotto(numbers));
        }
    }

    public void enterWinningNumbers() {
        while ( true ) {
            try {
                winningLotto = readEnterWinningNumbers();
                break;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
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

    public void calculateWinnings() {
        compareWinningNumbers();
        getStats();
    }

    private void compareWinningNumbers() {
        for ( Lotto purchasedOne : purchasedLottos.getLottos() ) {
            purchasedLottosResult.add(new LottoResult(purchasedOne, winningLotto));
        }
    }

    private void getStats() {
        Statistics statistics = new Statistics(purchasedLottosResult);

        printStats(statistics);
    }

    private void printStats(Statistics statistics) {
        LottoMachineView.printStatisticsView(statistics);
    }
}
