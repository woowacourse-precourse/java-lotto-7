package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.WinningInputMessage;
import lotto.validate.WinningValidate;

public class WinningService {
    public void run() {
        getWinningInput();
    }

    public void getWinningInput() {
        while (true) {
            System.out.println("\n" + WinningInputMessage.REQUEST_LOTTO_WINNING_NUMBER.getMessage());

            String winningString = Console.readLine();
            if (!WinningValidate.runValidString(winningString)) continue;

            break;
        }
    }
}
