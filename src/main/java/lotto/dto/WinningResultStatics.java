package lotto.dto;

import java.util.List;

public class WinningResultStatics {

    private final List<WinningNumbersStatics> winningNumbersStatics;
    private final String winningPrizeStatics;

    public WinningResultStatics(List<WinningNumbersStatics> inputWinningNumbersStatics, String prizeSum) {
        winningNumbersStatics = inputWinningNumbersStatics;
        winningPrizeStatics = prizeSum;
    }

    public List<WinningNumbersStatics> getWinningNumbersStatics() {
        return winningNumbersStatics;
    }

    public String getWinningPrizeStatics() {
        return winningPrizeStatics;
    }

}
