package lotto.controller;

import static lotto.handler.ConstantHandler.WINNING_NUMBERS_DELIMITER;
import static lotto.handler.ErrorHandler.INCONVERTIBLE_TYPE;
import static lotto.handler.PatternHandler.BONUS_NUMBER_PATTERN;
import static lotto.handler.PatternHandler.MONEY_PATTERN;
import static lotto.handler.PatternHandler.WINNING_NUMBERS_PATTERN;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import lotto.domain.LottoGenerator;
import lotto.domain.LottoPrize;
import lotto.domain.LottoProfit;
import lotto.domain.LottoRank;
import lotto.domain.LottoTickets;
import lotto.domain.Money;
import lotto.domain.WinningLotto;
import lotto.view.input.InputBonusNumberView;
import lotto.view.input.InputMoneyView;
import lotto.view.input.InputWinningNumbersView;
import lotto.view.output.OutputErrorMessageView;
import lotto.view.output.OutputLottoTicketsView;
import lotto.view.output.OutputWinningStatisticView;

public class LottoController {
    private final InputMoneyView inputMoneyView = new InputMoneyView();
    private final InputWinningNumbersView inputWinningNumbersView = new InputWinningNumbersView();
    private final InputBonusNumberView inputBonusNumberView = new InputBonusNumberView();
    private final OutputLottoTicketsView outputLottoTicketsView = new OutputLottoTicketsView();
    private final OutputWinningStatisticView outputWinningStatisticView = new OutputWinningStatisticView();
    private final OutputErrorMessageView outputErrorMessageView = new OutputErrorMessageView();

    public void run() {
        Money money = getMoney();
        LottoTickets lottoTickets = getLottoTickets(money.getTicketCount());
        outputLottoTicketsView.showLottoTickets(lottoTickets.getLottoTicketCount(), lottoTickets);

        WinningLotto winningLotto = getWinningLotto();
        LottoRank lottoRank = new LottoRank(lottoTickets, winningLotto);
        LottoPrize lottoPrize = new LottoPrize(lottoRank);
        LottoProfit lottoProfit = new LottoProfit(money.getMoney(), lottoPrize.getLottoPrize());
        outputWinningStatisticView.showWinningStatistic(lottoRank, lottoProfit);
    }

    private Money getMoney() {
        while (true) {
            try {
                String inputMoney = inputMoneyView.readInput();
                validate(inputMoney, MONEY_PATTERN);
                return new Money(Integer.parseInt(inputMoney));
            } catch (IllegalArgumentException e) {
                outputErrorMessageView.showErrorMessage(e.getMessage());
            }
        }
    }

    private LottoTickets getLottoTickets(int ticketCount) {
        return new LottoTickets(new LottoGenerator().generateLottos(ticketCount));
    }

    private WinningLotto getWinningLotto() {
        while (true) {
            try {
                List<Integer> winningNumbers = getWinningNumbers();
                int bonusNumber = getBonusNumber();
                return new WinningLotto(winningNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                outputErrorMessageView.showErrorMessage(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumbers() {
        while (true) {
            try {
                String inputWinningNumbers = inputWinningNumbersView.readInput();
                validate(inputWinningNumbers, WINNING_NUMBERS_PATTERN);
                return Arrays.stream(inputWinningNumbers.split(WINNING_NUMBERS_DELIMITER))
                        .map(Integer::parseInt)
                        .toList();
            } catch (IllegalArgumentException e) {
                outputErrorMessageView.showErrorMessage(e.getMessage());
            }
        }
    }

    private int getBonusNumber() {
        while (true) {
            try {
                String inputBonusNumber = inputBonusNumberView.readInput();
                validate(inputBonusNumber, BONUS_NUMBER_PATTERN);
                return Integer.parseInt(inputBonusNumber);
            } catch (IllegalArgumentException e) {
                outputErrorMessageView.showErrorMessage(e.getMessage());
            }
        }
    }

    private void validate(String inputValue, Pattern pattern) {
        if (!pattern.matcher(inputValue).matches()) {
            throw INCONVERTIBLE_TYPE.getException();
        }
    }
}
