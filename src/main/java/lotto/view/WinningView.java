package lotto.view;

import lotto.message.WinningInputMessage;

public class WinningView {

    public static void requestWinningInput() {
        System.out.println("\n" + WinningInputMessage.REQUEST_LOTTO_WINNING_NUMBER.getMessage());
    }

    public static void requestBonusInput() {
        System.out.println("\n" + WinningInputMessage.REQUEST_LOTTO_BONUS_NUMBER.getMessage());
    }
}
