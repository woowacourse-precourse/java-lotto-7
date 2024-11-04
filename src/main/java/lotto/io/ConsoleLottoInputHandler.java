package lotto.io;

import camp.nextstep.edu.missionutils.Console;

public class ConsoleLottoInputHandler implements LottoInputHandler {

    @Override
    public String getPurchaseAmount() {
        return Console.readLine();
    }

    @Override
    public String getWinningNumbers() {
        return Console.readLine();
    }

    @Override
    public String getBonusNumber() {
        return Console.readLine();
    }
}
