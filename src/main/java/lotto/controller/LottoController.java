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

        Money money = userMoneyInput();
        LottoArchive lottoArchive = buyLotto(money.getTickets());
        displayLottoList(lottoArchive.getLottoList());

        WinningNumber winningNumber = getWinningNumber();
        BonusNumber bonusNumber = getBonusNumber(winningNumber.getNumberList());

        NumberMatchCounter numberMatchCounter = new NumberMatchCounter(lottoArchive, winningNumber, bonusNumber);
        PrizeCalculator prizeCalculator = new PrizeCalculator(numberMatchCounter.getPrizeCounts(), money.getMoney());

        displayResult(numberMatchCounter.getPrizeCounts(), prizeCalculator.calculatePrizeRate());
    }

    public Money userMoneyInput() {
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
        List<Lotto> lottoList = LottoMaker.makeLottos(ticket);
        return new LottoArchive(lottoList);
    }

    public void displayLottoList(List<Lotto> lottoList) {
        outView.printLottoCount(lottoList.size());
        for (Lotto lotto : lottoList) {
            outView.printLottoNumbers(lotto.getNumbers());
        }
    }

    public WinningNumber getWinningNumber() {
        outView.printWinningNumberInputMessage();
        while (true) {
            try {
                List<Integer> number = WinningNumberInputView.getWinningNumber();
                return new WinningNumber(number);
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
