package lotto.controller;

import java.util.List;
import lotto.Lotto;
import lotto.Service.CheckerService;

public class CheckerController {
    private static final CheckerService checkerService = new CheckerService();

    public static void checkResult(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        countMatches(lottos, winningNumbers, bonusNumber);
        result();
    }

    private static void countMatches(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        for (Lotto lotto : lottos) {
            int matchCount = checkerService.countMatches(lotto.getNumbers(), winningNumbers);
            matchBonus(lotto.getNumbers(), bonusNumber);
            isDetermine(matchCount);
        }
    }

    private static void matchBonus(List<Integer> lotto, int bonusNumber) {
        checkerService.matchBonus(lotto, bonusNumber);
    }

    private static void isDetermine(int matchCount) {
        checkerService.isDetermine(matchCount);
    }

    private static void result() {
        checkerService.result();
    }
}
