package lotto.domain;

import static lotto.constant.LottoMessage.COUNT_MESSAGE;

import java.util.EnumMap;
import java.util.List;

public class WinningResult {
    private static final String ZERO_PERCENT = "0.0";
    private static final String TENTH_PLACE_VALUE = "%.1f";
    private static final int COUNT_INITIALIZE = 0;

    private final EnumMap<WinningRank, Integer> winningCount;
    private long prizeMoney;
    private final WinningRank[] winningRanks = WinningRank.values();

    public WinningResult() {
        this.winningCount = new EnumMap<>(WinningRank.class);

        for (int i = 1; i < winningRanks.length; i++) {
            winningCount.put(winningRanks[i], COUNT_INITIALIZE);
        }
    }

    public void checkPurchaseLotto(PurchaseLotto purchaseLotto, WinningLotto winningLotto) {
        List<Integer> winningNumbers = winningLotto.getWinningNumbers().getNumbers();
        int bonusNumber = winningLotto.getBonusNumber();

        for (Lotto lotto : purchaseLotto.getPurchasedLottos()) {
            WinningRank winningRank = compareLottoNumbers(lotto, winningNumbers, bonusNumber);
            updateWinningCount(winningRank);
        }
    }

    public WinningRank compareLottoNumbers(Lotto lotto, List<Integer> winningNumbers, int bonusNumber) {
        int matchCount = 0;
        boolean matchBonus = false;

        for (int number : lotto.getNumbers()) {
            if (winningNumbers.contains(number)) {
                matchCount++;
                continue;
            }

            if (bonusNumber == number) {
                matchBonus = true;
            }
        }
        return getLottoRank(matchCount, matchBonus);
    }

    public WinningRank getLottoRank(int matchCount, boolean matchBonus) {
        return WinningRank.getRank(matchCount, matchBonus);
    }

    private void updateWinningCount(WinningRank winningRank) {
        if (!winningRank.equals(WinningRank.NONE)) {
            winningCount.put(winningRank, winningCount.get(winningRank) + 1);
            prizeMoney += winningRank.getPrizeMoney();
        }
    }

    public String getWinningStatistics() {
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < winningRanks.length; i++) {
            sb.append(winningRanks[i].getMessage())
                    .append(winningCount.get(winningRanks[i]))
                    .append(COUNT_MESSAGE.getMessage());
        }

        return sb.toString();
    }

    public String getRateOfReturn(int amount) {
        if (prizeMoney == 0) {
            return ZERO_PERCENT;
        }

        return String.format(TENTH_PLACE_VALUE, getRate(amount));
    }

    private double getRate(int amount) {
        return (double) prizeMoney / amount * 100;
    }

    public void setPrizeMoney(long prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
}
