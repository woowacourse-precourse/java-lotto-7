package lotto;

import lotto.console.ConsoleOutput;
import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.enums.WinRank;
import lotto.util.StringMaker;

import java.util.List;

public class LottoGameRunner {

    private final LottoGame lottoGame;

    private LottoGameRunner(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public static LottoGameRunner from(LottoGame lottoGame) {
        return new LottoGameRunner(lottoGame);
    }

    public void run() {

        List<WinRank> wins = calculateWinRank(matchLottoNumbers());

        Double earningRate = calculateEarningRate(wins);

        printLottoGameResult(wins, earningRate);
    }

    private void printLottoGameResult(List<WinRank> winningWinRanks, Double earningRate) {
        ConsoleOutput.print(makeWinStatusResult(winningWinRanks, earningRate));
    }

    private static String makeWinStatusResult(List<WinRank> winningWinRanks, Double earningRate) {

        int[] countPerWinningRank = countRanks(winningWinRanks);

        return StringMaker.make(earningRate, countPerWinningRank);
    }

    private static int[] countRanks(List<WinRank> winningWinRanks) {
        int[] countPerWinningRank = new int[6];
        winningWinRanks
                .forEach(winRank -> {
                    countPerWinningRank[winRank.getValue()]++;
                });
        return countPerWinningRank;
    }

    private Double calculateEarningRate(List<WinRank> winningWinRanks) {

        double earnRate = ((double) calculateTotalEarning(winningWinRanks) / lottoGame.getTotalPrice().getValue()) * 100;

        return roundToSecondDecimalPlace(earnRate);
    }

    private double roundToSecondDecimalPlace(double earnRate) {
        return Math.round(earnRate * 100) / 100.0;
    }

    private Integer calculateTotalEarning(List<WinRank> winningWinRanks) {
        return winningWinRanks.stream()
                .mapToInt(LottoGameRunner::winPriceFromRank)
                .sum();
    }

    private static int winPriceFromRank(WinRank winRank) {
        return winRank.getPrize();
    }

    private List<WinRank> calculateWinRank(List<Integer> winningHistoty) {
        return winningHistoty.stream()
                .map(LottoGameRunner::calculateRank)
                .toList();
    }

    private static WinRank calculateRank(Integer winCount) {
        if(winCount == 6) {
            return WinRank.FIRST;
        }
        if(winCount == 7) {
            return WinRank.SECOND;
        }
        if(winCount == 5) {
            return WinRank.THIRD;
        }
        if(winCount == 4) {
            return WinRank.FOURTH;
        }
        if(winCount == 3) {
            return WinRank.FIFTH;
        }
        return WinRank.NONE;
    }

    private List<Integer> matchLottoNumbers() {
        return lottoGame.getPurchasedLottos().getValue().stream()
                .map(this::countMatchedNumbers)
                .toList();
    }

    private int countMatchedNumbers(Lotto lotto) {
        int correctCount = 0;

        for(LottoNumber value : lotto.getValue()) {
            if(lottoGame.getWinningNumbers().contains(value)) {
                correctCount++;
            }
        }

        if (correctCount == 5) {
            if (lotto.contains(lottoGame.getBonusNumber().getValue())) {
                correctCount = 7;
            }
        }
        return correctCount;
    }
}
