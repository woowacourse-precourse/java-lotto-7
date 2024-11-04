package lotto.view.impl;

import static lotto.constant.GameMessage.PRINT_BONUS_NUMBERS_MESSAGE;
import static lotto.constant.GameMessage.PRINT_BUYING_PRICE_MESSAGE;
import static lotto.constant.GameMessage.PRINT_WINNING_NUMBERS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.view.InputView;

public class InputViewImpl implements InputView {
    @Override
    public String startLottoGameAndReadBuyingPrice() {
        PRINT_BUYING_PRICE_MESSAGE.printGameMessage();
        return Console.readLine();
    }

    @Override
    public List<Integer> readWinningNumbers() {
        PRINT_WINNING_NUMBERS_MESSAGE.printGameMessage();
        String winningNumbers = Console.readLine();
        return Arrays.stream(winningNumbers.split(","))
                .map(String::trim)
                .filter(value -> !value.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    @Override
    public String readBonusNumber() {
        PRINT_BONUS_NUMBERS_MESSAGE.printGameMessage();
        return Console.readLine();
    }
}
