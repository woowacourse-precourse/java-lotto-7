package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.Service.CheckerService;

public class CheckerController {
    private static final CheckerService checkerService = new CheckerService();

    public static void checkResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        countMatches(lottos, winningNumbers);

    }

    private static void countMatches(List<Lotto> lottos, List<Integer> winningNumbers) {
        for (Lotto lotto : lottos) {
            int matchCount = checkerService.countMatches(lotto.getNumbers(), winningNumbers);
            isDetermine(matchCount);
        }
        result();
    }

    private static void isDetermine(int matchCount) {
        checkerService.isDetermine(matchCount);
    }

    private static void result() {
        checkerService.result();
    }
}
