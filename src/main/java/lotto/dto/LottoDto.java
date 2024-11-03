package lotto.dto;

import java.util.List;
import lotto.domain.Lotto;

public class LottoDto {
    private final int payment;
    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final int bonus;

    public LottoDto(int payment, List<Lotto> lottos, List<Integer> winningNumbers, int bonus) {
        this.payment = payment;
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }

    public int getPayment() {
        return payment;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonus() {
        return bonus;
    }
}
