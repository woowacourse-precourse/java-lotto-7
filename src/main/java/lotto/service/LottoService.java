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

public class LottoService {
    public LottoService() {
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

    public long getTotalPrize(Lottos lottos, Lotto winningNumber, BonusNumber bonusNumber) {
        long totalPrize = 0;

        for (Lotto lotto : lottos.getLottos()) {
            Prize prize = lotto.match(winningNumber, bonusNumber);
            totalPrize += prize.getMoney();
        }

        return totalPrize;
    }
}
