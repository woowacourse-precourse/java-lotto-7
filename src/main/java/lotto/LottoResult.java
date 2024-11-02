package lotto;

import java.util.Arrays;

public class LottoResult {
    int winningCount;
    int bonusCount;

    public LottoResult(int winningCount, int bonusCount) {
        this.winningCount = winningCount;
        this.bonusCount = bonusCount;
    }

    public int getWinningCount() {
        return winningCount;
    }

    public int getBonusCount() {
        return bonusCount;
    }


    public void tt() {
        for (WinningPrize str:WinningPrize.values()){
            if (str.winningCount == getWinningCount() && str.bonusCount <= getBonusCount()){
                System.out.println(winningCount+" "+bonusCount);
                str.setTotalCount();
                return;
            }
        }

        Arrays.stream(WinningPrize.values()).filter(e -> e.winningCount == winningCount && e.bonusCount == bonusCount).count();
    }
}
