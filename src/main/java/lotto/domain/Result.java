package lotto.domain;

public class Result {
    private int matchCount3;
    private int matchCount4;
    private int matchCount5;
    private int matchCount5Bonus;
    private int matchCount6;
    private int totalProfit;

    private Prize prize = new Prize();

    public Result() {
        this.matchCount3 = 0;
        this.matchCount4 = 0;
        this.matchCount5 = 0;
        this.matchCount5Bonus = 0;
        this.matchCount6 = 0;
        this.totalProfit = 0;
    }

    public void addResultCount(Match match) {
        if (match == Match.MATCH_3) {
            matchCount3++;
            totalProfit += prize.getPrize(match);
        }
        if (match == Match.MATCH_4) {
            matchCount4++;
            totalProfit += prize.getPrize(match);
        }
        if (match == Match.MATCH_5) {
            matchCount5++;
            totalProfit += prize.getPrize(match);
        }
        if (match == Match.MATCH_5_WITH_BONUS) {
            matchCount5Bonus++;
            totalProfit += prize.getPrize(match);
        }
        if (match == Match.MATCH_6) {
            matchCount6++;
            totalProfit += prize.getPrize(match);
        }
    }

    public int getTotalProfit() {
        return totalProfit;
    }

    public int getMatchCount3() {
        return matchCount3;
    }

    public int getMatchCount4() {
        return matchCount4;
    }

    public int getMatchCount5() {
        return matchCount5;
    }

    public int getMatchCount5Bonus() {
        return matchCount5Bonus;
    }

    public int getMatchCount6() {
        return matchCount6;
    }

    public Prize getPrize() {
        return prize;
    }
}
