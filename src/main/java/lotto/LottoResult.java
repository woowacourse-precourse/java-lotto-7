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

    public void displayWinningStatistics() {
        System.out.println("당첨 통계\n---");
        for (Rank rank : Rank.values()) {
            if (rank != Rank.NONE) {
                System.out.println(rank);
            }
        }
    }

}
