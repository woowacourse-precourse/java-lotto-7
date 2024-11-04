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
            } catch (IllegalArgumentException e) {
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
        Lotto winningLotto;
        int bonusNumber;
        WinningLotto temp;
        while ( true ) {
            try {
                winningLotto = new Lotto(readEnterWinningLottoNumbers());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        while ( true ) {
            try {
                bonusNumber = readEnterWinningBonusNumber();
                temp = new WinningLotto(winningLotto, bonusNumber);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        this.winningLotto = temp;
    }

    private List<Integer> readEnterWinningLottoNumbers() {
        LottoMachineView.printEnterWinningNumbersView();
        String winningNumber = Console.readLine();
        return InputHandler.enterWinningNumbersHandle(winningNumber);
    }

    private int readEnterWinningBonusNumber() {
        LottoMachineView.printEnterBonusWinningNumberView();
        String bonusNumber = Console.readLine();
        return InputHandler.enterBonusNumberHandle(bonusNumber);
    }

    public void calculateWinnings() {
        compareWinningNumbers();
        printStats(getStats());
    }

    private void compareWinningNumbers() {
        for ( Lotto purchasedOne : purchasedLottos.getLottos() ) {
            purchasedLottosResult.add(new LottoResult(purchasedOne, winningLotto));
        }
    }

    private Statistics getStats() {
        return new Statistics(purchasedLottosResult);
    }

    private void printStats(Statistics statistics) {
        LottoMachineView.printStatisticsView(statistics);
    }
}
