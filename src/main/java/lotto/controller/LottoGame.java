package lotto.controller;

import lotto.Ball;
import lotto.Lotto;
import lotto.LottoTicket;
import lotto.Money;
import lotto.Rank;
import lotto.WinningNumbers;
import lotto.WinningResult;
import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class LottoGame {
    private final ConsoleInput input;
    private final ConsoleOutput output;

    public LottoGame(ConsoleInput input, ConsoleOutput output) {
        this.input = input;
        this.output = output;
    }

    public void play() {
        BigDecimal amount = input.readPurchaseAmount();
        Money money = new Money(amount);
        int lottoQuantity = money.calculateLottoQuantity();
        LottoTicket lottoTicket = new LottoTicket();
        List<Lotto> lottos = lottoTicket.createLotto(lottoQuantity);
        output.printLottoTicket(lottoQuantity, lottos);

        List<Integer> numbers = input.readWinningNumbers();
        int bonusNumber = input.readBonusNumber();
        WinningNumbers winningNumbers = new WinningNumbers(Lotto.with(numbers), new Ball(bonusNumber));
        Map<Rank, Integer> rankCounts = winningNumbers.countRank(lottos);
        WinningResult winningResult = new WinningResult(rankCounts, money);
        output.printPrizeStatistics(winningResult);
    }
}
