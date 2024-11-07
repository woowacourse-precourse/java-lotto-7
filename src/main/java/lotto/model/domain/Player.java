package lotto.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.config.LottoConfig;

public class Player {
    public static final String RETURN_RATE_FORMAT = "%.1f";
    private final int purchaseAmount;
    private final List<Lotto> lottos;
    private WinningNumbers winningNumbers; // WinningNumbers 추가
    private int winningMoney;

    public Player(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.lottos = new ArrayList<>();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public void addLotto(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<String> getLottoNumbers() {
        List<String> lottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            lottoNumbers.add(lotto.toFormattedString());
        }
        return lottoNumbers;
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers;
    }

    public List<Integer> calculateWinningRanks() {
        List<Integer> winningRank = new ArrayList<>(
                Collections.nCopies(WinningMatch.values().length, LottoConfig.ZERO));
        for (Lotto lotto : lottos) {
            int rank = lotto.getResult(winningNumbers);
            if (rank >= WinningMatch.valueOfMaxMatch().getRank() && rank <= WinningMatch.valueOfMinMatch().getRank()) {
                winningMoney += WinningMatch.valueOfRank(rank).getPriceAmount();
                winningRank.set(rank - 1, winningRank.get(rank - 1) + 1);
            }
        }
        return winningRank;
    }

    public String getRateOfReturn(int winning) {
        return formatRateOfReturn(calculateRateOfReturn(winning));
    }

    private double calculateRateOfReturn(int winning) {
        return (double) winning * 100 / purchaseAmount;
    }

    private String formatRateOfReturn(double rateOfReturn) {
        return String.format(RETURN_RATE_FORMAT, rateOfReturn).concat("%");
    }
}
