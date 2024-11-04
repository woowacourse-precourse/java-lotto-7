package lotto.dto;

import java.util.List;

public class WinningResultStatics {

    private final List<WinningStaticsPerConditions> winningNumbersStatics;
    private final String winningPrizeStatics;

    public WinningResultStatics(List<WinningStaticsPerConditions> inputWinningNumbersStatics, String prizeSum) {
        winningNumbersStatics = inputWinningNumbersStatics;
        winningPrizeStatics = prizeSum;
    }

    public List<WinningStaticsPerConditions> getWinningNumbersStatics() {
        return winningNumbersStatics;
    }

    public String getWinningPrizeStatics() {
        return winningPrizeStatics;
    }

}
