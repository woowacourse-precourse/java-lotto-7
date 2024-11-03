package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import lotto.domain.Winning;
import lotto.validate.WinningValidate;
import lotto.view.WinningView;

public class WinningService {

    Winning winning = new Winning();

    public void run() {
        getWinningInput();
    }

    public void getWinningInput() {
        String winningString = null;

        while (true) {
            WinningView.requestWinningInput();
            winningString = Console.readLine();

            if (!WinningValidate.runValidString(winningString)) {
                continue;
            }

            break;
        }

        addWinningNumber(winningString);
    }

    public void addWinningNumber(String winningString) {
        String[] winningNumber = winningString.split(",");

        HashSet<Integer> winningNumberSet = new HashSet<>();
        for (String number : winningNumber) {
            winningNumberSet.add(Integer.parseInt(number));
        }

        winning.setHashSet(winningNumberSet);
    }
}
