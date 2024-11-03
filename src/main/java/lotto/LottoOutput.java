package lotto;

public class LottoOutput {
    public void showWinningLotto(int[] rewardCounts) {
        for (LottoReward reward : LottoReward.values()) {
            if (reward == LottoReward.BOOM) {
                continue;
            }
            System.out.print(reward.getMatch() + "개 일치");
            if (reward.isBonus()) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf(" (%,d원) - %d개\n", reward.getPrize(), rewardCounts[reward.ordinal()]);
        }
    }

    public void showReturnPrice(double returnPrice) {
        System.out.println("총 수익률은 " + returnPrice + "%입니다.");
    }
}
