package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputHandler {
    public Long inputMoney() {
        return Long.parseLong(Console.readLine());
    }

    public int inputBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputWinningNumbers() {
        InputUtils inputUtils = new InputUtils();
        return inputUtils.toIntegerList(
                inputUtils.splitByComma(
                        Console.readLine()
                )
        );
    }
}
