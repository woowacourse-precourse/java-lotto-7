package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.enums.Prize;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.LottoArchive;
import lotto.model.LottoMaker;
import lotto.model.Money;
import lotto.model.NumberMatchCounter;
import lotto.model.PrizeCalculator;
import lotto.model.WinningNumber;
import lotto.view.BonusNumberInputView;
import lotto.view.MoneyInputView;
import lotto.view.OutView;
import lotto.view.WinningNumberInputView;

public class LottoController {

    OutView outView = new OutView();

    public void start() {
        Money money = getMoney();
        LottoArchive lottoArchive = buyLotto(money.getTickets());
        displayLottos(lottoArchive.getLottos());

        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber.getNumbers());

        NumberMatchCounter numberMatchCounter = new NumberMatchCounter(lottoArchive, winningNumber, bonusNumber);
        PrizeCalculator prizeCalculator = new PrizeCalculator(numberMatchCounter.getPrizeCounts(), money.getMoney());

        displayResult(numberMatchCounter.getPrizeCounts(), prizeCalculator.calculatePrizeRate());
    }

    public Money getMoney() {
        outView.printMoneyInputMessage();

        while (true) {
            try {
                Long number = MoneyInputView.getMoney();
                return new Money(number);
            } catch (IllegalArgumentException e) {
                outView.printErrorMessage(e.getMessage());
            }
        }
    }

    public LottoArchive buyLotto(Long ticket) {
        List<Lotto> lottos = LottoMaker.makeLottos(ticket);
        return new LottoArchive(lottos);
    }

    public void displayLottos(List<Lotto> lottos) {
        outView.printLottoCount(lottos.size());
        for (Lotto lotto : lottos) {
            outView.printLottoNumbers(lotto.getNumbers());
        }
    }

    public WinningNumber getWinningNumber() {
        outView.printWinningNumberInputMessage();
        while (true) {
            try {
                List<Integer> winningNumber = WinningNumberInputView.getWinningNumber();
                return new WinningNumber(winningNumber);
            } catch (IllegalArgumentException e) {
                outView.printErrorMessage(e.getMessage());
            }
        }
    }

    public BonusNumber getBonusNumber(List<Integer> winningNumber) {
        outView.printBonusNumberInputMessage();
        while (true) {
            try {
                int number = BonusNumberInputView.getBonusNumber();
                return new BonusNumber(number, winningNumber);
            } catch (IllegalArgumentException e) {
                outView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void displayResult(Map<Prize, Long> prizeCounts, double earnRate) {
        outView.printLottoResult(prizeCounts);
        outView.printEarnRate(earnRate);
    }

}
