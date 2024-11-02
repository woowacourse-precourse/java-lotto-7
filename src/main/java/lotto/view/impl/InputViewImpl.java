package lotto.view.impl;

import static lotto.constant.GameMessage.GAME_PRINT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.InputView;

public class InputViewImpl implements InputView {
    @Override
    public void startLottoGameAndReadBuyingPrice() {
        GAME_PRINT_MESSAGE.printGameMessage();
        Console.readLine();
    }
}