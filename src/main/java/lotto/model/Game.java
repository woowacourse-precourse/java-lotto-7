package lotto.model;

import java.util.Collections;
import java.util.List;
import lotto.model.purchase.LottoStore;

public class Game {
    private final LottoStore lottoStore;
    private List<Lotto> issuedLottos;
    private WinningNumber winningNumber;

    public Game(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
        this.issuedLottos = List.of();
        winningNumber = new WinningNumber();
    }

    public void purchaseLottos(int amount) {
        issuedLottos = Collections.unmodifiableList(lottoStore.purchaseLottoTickets(amount));
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }

    public void setWinningNumber(List<Integer> winningNumbers) {
        winningNumber.setWinningNumbers(new Lotto(winningNumbers));
    }
}
