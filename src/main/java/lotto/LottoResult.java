package lotto;

public class LottoResult {

    private void recordMatchResult(int matchCount, boolean matchBonus) {
        Rank rank = Rank.getRank(matchCount, matchBonus);
        rank.increaseCount();
    }

    public void evaluateLottoResults(LottoTicket lottoTicket, WinningNumbers winningNumbers) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            int mathCount = winningNumbers.countMatchingNumbers(lotto);
            boolean matchBonus = winningNumbers.isBonusMatched(lotto);
            recordMatchResult(mathCount, matchBonus);
        }
    }

    public double calculateRateOfReturn(int amount) {
        int total = 0;
        for (Rank rank : Rank.values()) {
            total += rank.getCount() * rank.getPrize();
        }
        double rateOfReturn = ((double) total / amount) * 100;
        return Math.round(rateOfReturn * 100) / 100.0;
    }

    public void displayRateOfReturn(double rateOfReturn) {
        System.out.printf("총 수익률은 " + rateOfReturn + "%%입니다.");
    }

    public void displayWinningStatistics() {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.println(rank);
            }
        }
    }

}
