package lotto;

import java.util.List;
import java.util.Set;

public class LottoGame {

    private final Integer totalPrice;
    private final List<Lotto> lottos;
    private final Set<Integer> winningNumbers;
    private final Integer bonusNumber;

    private LottoGame(Integer totalPrice, List<Lotto> lottos, Set<Integer> winningNumbers, Integer bonusNumber) {
        this.totalPrice = totalPrice;
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoGame of(Integer totalPrice, List<Lotto> lottos, Set<Integer> winningNumbers, Integer bonusNumber) {
        return new LottoGame(totalPrice, lottos, winningNumbers, bonusNumber);
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Set<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }
}
