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
        getBonusInput();
    }

    public void getBonusInput() {
        int bonusNumber = 0;

        while (true) {
            WinningView.requestBonusInput();
            String bonusNumberString = Console.readLine();

            if (!WinningValidate.runValidBonusString(bonusNumberString, winning)) {
                continue;
            }

            break;
        }
    }

    public void getWinningInput() {
        String winningString = null;

        while (true) {
            WinningView.requestWinningInput();
            winningString = Console.readLine();

            if (!WinningValidate.runValidWinningString(winningString)) {
                continue;
            }

            break;
        }

        HashSet<Integer> winningNumberSet = addWinningNumber(winningString);
        winning.setHashSet(winningNumberSet);
    }

    public static HashSet<Integer> addWinningNumber(String winningString) {
        String[] winningNumber = winningString.split(",");

        HashSet<Integer> winningNumberSet = new HashSet<>();
        for (String number : winningNumber) {
            winningNumberSet.add(Integer.parseInt(number));
        }

        return winningNumberSet;
    }
}
