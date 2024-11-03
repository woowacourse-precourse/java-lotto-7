package lotto;

import lotto.view.ConsoleInput;
import lotto.view.ConsoleOutput;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {
        ConsoleInput input = new ConsoleInput();
        ConsoleOutput output = new ConsoleOutput();

        try {
            BigDecimal amount = input.readPurchaseAmount();
            Money money = new Money(amount);
            int lottoQuantity = money.calculateLottoQuantity();
            LottoTicket lottoTicket = new LottoTicket();
            List<Lotto> lottos = lottoTicket.create(lottoQuantity);
            output.printLottoTicket(lottoQuantity, lottos);

            String string = input.readWinningNumbers();
            String bonusNumber = input.readBonusNumber();
            String[] stringNumbers = string.split(",");
            List<Integer> numbers = new ArrayList<>();
            for (String stringNumber : stringNumbers) {
                numbers.add(Integer.parseInt(stringNumber));
            }
            WinningNumbers winningNumbers = new WinningNumbers(numbers, Integer.parseInt(bonusNumber));
            Map<Rank, Integer> rankCounts = winningNumbers.countRank(lottos);
            WinningResult winningResult = new WinningResult(rankCounts, money);
            output.printPrizeStatistics(winningResult);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
}
