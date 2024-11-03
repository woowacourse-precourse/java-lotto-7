package lotto.controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.LottoTicket;
import lotto.domain.Money;
import lotto.domain.PrizeResult;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        Money money = promptForMoney();
        LottoTicket lottoTicket = generateLottoTickets(money);
        WinningLotto winningLotto = promptForWinningLotto();
        PrizeResult prizeResult = calculatePrizes(lottoTicket, winningLotto);
        outputWinningDetails(prizeResult, money);
    }

    private Money promptForMoney() {
        while (true) {
            try {
                return new Money(inputView.enterMoney());
            } catch (IllegalArgumentException e) {
                outputView.renderError(e.getMessage());
            }
        }
    }

    private LottoTicket generateLottoTickets(Money money) {
        outputView.printTicketAmount(money);
        LottoTicket lottoTicket = new LottoTicket(money);
        outputView.printLotto(lottoTicket);
        return lottoTicket;
    }

    private WinningLotto promptForWinningLotto() {
        while (true) {
            try {
                String originWinningNumber = inputView.enterWinningNumber();
                Integer bonusNumber = inputView.enterBonusNumber();
                return new WinningLotto(convertToLottoFormat(originWinningNumber), bonusNumber);
            } catch (IllegalArgumentException e) {
                outputView.renderError(e.getMessage());
            }
        }
    }

    private PrizeResult calculatePrizes(LottoTicket lottoTicket, WinningLotto winningLotto) {
        PrizeResult prizeResult = new PrizeResult();
        prizeResult.calculate(winningLotto, lottoTicket);
        return prizeResult;
    }

    private void outputWinningDetails(PrizeResult prizeResult, Money money) {
        outputView.winningDetails(prizeResult, money);
    }

    public List<Integer> convertToLottoFormat(String inputValue) {
        return Arrays.stream(inputValue.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}