package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Winning;
import lotto.validate.WinningValidate;
import lotto.view.WinningView;

public class WinningService {

    private final Lottos lottos;
    private static Winning winning;

    public WinningService(Lottos lottos, Winning winning) {
        this.lottos = lottos;
        this.winning = winning;
    }

    public void run() {
        getWinningInput();
        getBonusInput();
        findWinningNumber(lottos);
    }

    public void findWinningNumber(Lottos lottos) {
        for (List LottoNumbers : lottos.getLottos()) {
            containsWinningNumber(LottoNumbers);
        }
    }

    public static void containsWinningNumber(List lottoNumbers) {
        HashSet<Integer> winningSet = winning.getWinningSet();

        for (int winningNumber : winningSet) {
            lottoNumbers.remove(Integer.valueOf(winningNumber));
        }
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
        winning.setBonusNumber(bonusNumber);
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
