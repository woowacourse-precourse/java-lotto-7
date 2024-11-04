package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Money;
import lotto.domain.WinningNumber;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public static Money readPurchasePrice() throws IllegalArgumentException {
        OutputView.printPurchasePrice();
        return new Money(Console.readLine());
    }

    public static WinningNumber readWinningNumber() throws IllegalArgumentException {
        OutputView.printRequestWinningNumber();
        String input = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinningNumber(winningNumbers);
    }

    public static BonusNumber readBonusNumber() throws IllegalArgumentException {
        OutputView.printRequestBonusNumber();
        String input = Console.readLine();

        return new BonusNumber(input);
    }
}
