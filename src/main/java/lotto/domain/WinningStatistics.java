package lotto.domain;

import java.util.List;

public class WinningStatistics {

    public static void checkWinningResult(Purchaser purchaser, WinningNumbers winningNumbers, BonusNumber bonusNumber) {
        WinningInfo.resetWinningTicketCount();
        List<Lotto> purchasedLotto = purchaser.getPurchasedLotto();
        for (Lotto lotto : purchasedLotto) {
            int place = lotto.findPlace(winningNumbers, bonusNumber);
            updateWinningTicketCount(place);
        }
    }

    private static void updateWinningTicketCount(int place) {
        for (WinningInfo info : WinningInfo.values()) {
            if (place == info.getPlace()) {
                info.win();
            }
        }
    }

    public static double calculateEarningRate(Budget budget) {
        int amount = budget.getAmount();
        int earnings = 0;
        for (WinningInfo info : WinningInfo.values()) {
            earnings += info.getPrizeMoney() * info.getWinningTicketCount();
        }
        return (double) earnings / amount * 100;
    }
}
