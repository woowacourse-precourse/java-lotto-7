package lotto;

import java.util.List;
import java.util.Map;

public class OutputManager {
    private final IO io = new IO();
    private final OutputFormatter outputFormatter = new OutputFormatter();

    public void purchaseLottoResult(List<Lotto> lottos) {
        System.out.printf("\n%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            io.printOutput(outputFormatter.lotto(lotto));
        }
    }

    public void lottoResult(Map<WinningStandard, Integer> winningResult) {
        System.out.println("\n당첨통계\n---");
        for (WinningStandard place : WinningStandard.values()) {
            io.printOutput(outputFormatter.result(winningResult, place));
        }
    }

    public void earningsRate(double earningsRate) {
        io.printOutput(outputFormatter.earningsRate(earningsRate));
    }
}