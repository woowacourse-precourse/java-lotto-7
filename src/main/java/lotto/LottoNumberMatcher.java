package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoNumber;
import lotto.enums.WinRank;
import lotto.util.LottoPrinter;

import java.util.List;

public class LottoNumberMatcher {

    private final LottoGame lottoGame;

    private LottoNumberMatcher(LottoGame lottoGame) {
        this.lottoGame = lottoGame;
    }

    public static LottoNumberMatcher from(LottoGame lottoGame) {
        return new LottoNumberMatcher(lottoGame);
    }

    public void match() {

        List<WinRank> wins = matchLottos();

        Double earningRate = calculateEarningRate(wins);

        LottoPrinter.print(earningRate, countPerRank(wins));
    }

    private static int[] countPerRank(List<WinRank> wins) {
        int[] countPerWinningRank = new int[6];
        wins.forEach(winRank -> {
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
                .mapToInt(LottoNumberMatcher::winPriceFromRank)
                .sum();
    }

    private static int winPriceFromRank(WinRank winRank) {
        return winRank.getPrize();
    }

    private List<WinRank> matchLottos() {
        return lottoGame.getPurchasedLottos().getValue().stream()
                .map(this::countMatchedNumbers)
                .map(WinRank::fromMatchNumberCount)
                .toList();
    }

    private int countMatchedNumbers(Lotto lotto) {
        int matchNumberCount = 0;

        for(LottoNumber value : lotto.getValue()) {
            if(lottoGame.getWinningNumbers().contains(value)) {
                matchNumberCount++;
            }
        }

        if (matchNumberCount == 5) {
            if (lotto.contains(lottoGame.getBonusNumber().getValue())) {
                matchNumberCount = 7;
            }
        }
        return matchNumberCount;
    }
}
