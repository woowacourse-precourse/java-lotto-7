package lotto.controller;

import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoArchive;
import lotto.model.LottoMaker;
import lotto.model.Money;
import lotto.model.WinningNumber;
import lotto.view.MoneyInputView;
import lotto.view.OutView;
import lotto.view.WinningNumberInputView;

public class LottoController {

    OutView outView = new OutView();

    public void start() {

        Money money = userMoneyInput();
        LottoArchive lottoArchive = buyLottos(money.getTickets());
        printLottoList(lottoArchive.getLottoList());
        WinningNumber winningNumber = winningNumberInput();

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

    public LottoArchive buyLottos(Long ticket) {
        List<Lotto> lottoList = LottoMaker.makeLottos(ticket);
        return new LottoArchive(lottoList);
    }

    public void printLottoList(List<Lotto> lottoList) {
        outView.printLottoCount(lottoList.size());
        for (Lotto lotto : lottoList) {
            outView.printLottoNumbers(lotto.getNumbers());
        }
    }

    public WinningNumber winningNumberInput() {
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
}
