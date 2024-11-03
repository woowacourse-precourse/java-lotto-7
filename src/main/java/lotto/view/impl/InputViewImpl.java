package lotto.view.impl;

import static lotto.constant.GameMessage.PRINT_BONUS_NUMBERS_MESSAGE;
import static lotto.constant.GameMessage.PRINT_BUYING_PRICE_MESSAGE;
import static lotto.constant.GameMessage.PRINT_WINNING_NUMBERS_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class InputViewImpl implements InputView {
    @Override
    public String startLottoGameAndReadBuyingPrice() {
        PRINT_BUYING_PRICE_MESSAGE.printGameMessage();
        String input = Console.readLine();
        LottoValidator.validateNumericInput(input);
        return input;
    }

    @Override
    public String readWinningNumbers() {
        PRINT_WINNING_NUMBERS_MESSAGE.printGameMessage();
        String input = Console.readLine();
        LottoValidator.validateCommaSeparatedNumericInput(input);
        return input;
    }

    @Override
    public String readBonusNumber() {
        PRINT_BONUS_NUMBERS_MESSAGE.printGameMessage();
        String input = Console.readLine();
        LottoValidator.validateNumericInput(input);
        return input;
    }
}
