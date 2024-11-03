package lotto.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {
    private final int purchaseAmount;
    private final List<Lotto> lottos;
    private WinningNumbers winningNumbers; // WinningNumbers 추가
    private int winningMoney;

    public Player(int perchaseAmount) {
        this.purchaseAmount = perchaseAmount;
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
        List<String> LottoNumbers = new ArrayList<>();
        for (Lotto lotto : lottos) {
            LottoNumbers.add(lotto.toFormattedString());
        }
        return LottoNumbers;
    }

    public void setWinningNumbers(WinningNumbers winningNumbers) {
        this.winningNumbers = winningNumbers; // WinningNumbers 설정
    }

    public List<Integer> checkWinning() {
        List<Integer> winningRank = new ArrayList<>(Collections.nCopies(WinningMatch.values().length, 0));
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
        String roundFormat = "%.".concat(Integer.toString(1).concat("f"));
        return String.format(roundFormat, (double) winning * 100 / purchaseAmount).concat("%");
    }
}
