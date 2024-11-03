package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.constant.Prize;
import lotto.constant.Prompt;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;

public class LottoService {
    public LottoService() {
    }

    public Lottos buyLottos(Money money) {
        int ticketCount = getTicketCount(money);

        return new Lottos(ticketCount);
    }

    public int getTicketCount(Money money) {
        return money.getValue() / 1000;
    }

    public Lotto getWinningNumbers() {
        System.out.println(Prompt.INPUT_WINNING_NUMBERS.getMessage());
        String numbers = Console.readLine();

        List<Integer> list = Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return new Lotto(list);
    }

    public BonusNumber getBonusNumber() {
        System.out.println(Prompt.INPUT_BONUS_NUMBER.getMessage());
        return new BonusNumber(Console.readLine());
    }

    public Result getResult(Lottos lottos, Lotto winningNumber, BonusNumber bonusNumber) {
        Result result = new Result();

        for (Lotto lotto : lottos.getLottos()) {
            Prize prize = lotto.match(winningNumber, bonusNumber);
            result.addPrize(prize);
        }

        return result;
    }

    public double calculateEarningRate(long totalPrize, Money money) {
        return (double) totalPrize /  money.getValue() * 100;
    }
}
