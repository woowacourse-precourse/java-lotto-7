package lotto;

import java.util.Map;

public class WinningTypes {

    private Map<Integer, WinningType> winningTypes;

    private WinningType bonusWinning;

    public WinningTypes(Map<Integer, WinningType> winningTypes, WinningType bonusWinning) {
        this.winningTypes = winningTypes;
        this.bonusWinning = bonusWinning;
    }

    public WinningType getWinning(int count) {
        try {
            return new WinningType(winningTypes.get(count));
        } catch (NullPointerException e) {
            return new WinningType(-1, -1);
        }
    }

    public WinningType getBonusWinning() {
        return new WinningType(bonusWinning);
    }
}
