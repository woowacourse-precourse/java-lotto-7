package lotto.controller;

import lotto.Ball;
import lotto.Lotto;
import lotto.LottoTicket;
import lotto.Money;
import lotto.WinningNumbers;
import lotto.WinningResult;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

import java.util.List;

public class LottoGame {
    private final ConsoleInput input;
    private final ConsoleOutput output;

    public LottoGame(ConsoleInput input, ConsoleOutput output) {
        this.input = input;
        this.output = output;
    }

    public void play() {
        Money money = new Money(input.readPurchaseAmount());
        LottoTicket lottoTicket = new LottoTicket(money);
        output.printLottoTicket(lottoTicket);

        WinningNumbers winningNumbers = enterWinningNumbers();
        WinningResult winningResult = winningNumbers.calculateResult(lottoTicket);
        output.printPrizeStatistics(winningResult);
    }

    private WinningNumbers enterWinningNumbers() {
        List<Integer> numbers = input.readWinningNumbers();
        int bonusNumber = input.readBonusNumber();
        return new WinningNumbers(Lotto.with(numbers), Ball.valueOf(bonusNumber));
    }

}
