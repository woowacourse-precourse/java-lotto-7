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

}
