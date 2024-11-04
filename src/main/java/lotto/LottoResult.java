package lotto;

public class LottoResult {
    int[] matchCount;
    float revenueRatio;

    public LottoResult() {
        this.matchCount = new int[8];
    }

    public void addMatchCount(int matchNumberCount, boolean hasBonus) {
        // 5개 일치 + 보너스 => idx 6
        // 6개 일치 => idx 7
        if ((hasBonus && matchNumberCount == 5) || matchNumberCount == 6) matchNumberCount++;
        matchCount[matchNumberCount]++;
    }

}
