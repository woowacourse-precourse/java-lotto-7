package lotto;

public class LottoResult {
    private int countOf3Match = 0;
    private int countOf4Match = 0;
    private int countOf5Match = 0;
    private int countOf5MatchAndBonus = 0;
    private int countOf6Match = 0;

    public void winningResult(int matchCount, boolean bonusMatch) {
        if (matchCount == 3) {
            countOf3Match++;
        } else if (matchCount == 4) {
            countOf4Match++;
        } else if (matchCount == 5) {
            if (bonusMatch) { // 보너스 번호와 일치하는 경우
                countOf5MatchAndBonus++;
            } else { // 보너스 번호와 일치하지 않는 경우
                countOf5Match++;
            }
        } else if (matchCount == 6) {
            countOf6Match++;
        }
    }

    public int getCountOf3Match() {
        return countOf3Match;
    }

    public int getCountOf4Match() {
        return countOf4Match;
    }

    public int getCountOf5Match() {
        return countOf5Match;
    }

    public int getCountOf5MatchAndBonus() {
        return countOf5MatchAndBonus;
    }

    public int getCountOf6Match() {
        return countOf6Match;
    }

    public int totalWinningPrize() {
        int winningPrize = 0;
        winningPrize += countOf3Match * 5000;
        winningPrize += countOf4Match * 50000;
        winningPrize += countOf5Match * 1500000;
        winningPrize += countOf5MatchAndBonus * 30000000;
        winningPrize += countOf6Match * 2000000000;
        return winningPrize;
    }
}
