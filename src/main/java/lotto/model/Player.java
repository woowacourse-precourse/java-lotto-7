package lotto.model;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

import lotto.model.WinningMatch;

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

    public List<Lotto> getLottos() {
        return lottos;
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

    public WinningNumbers getWinningNumbers() {
        return winningNumbers; // WinningNumbers 반환
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
}
