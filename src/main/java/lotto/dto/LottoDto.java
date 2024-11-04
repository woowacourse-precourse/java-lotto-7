package lotto.dto;

import java.util.List;
import lotto.Lotto;

public class LottoDto {

    private final List<Lotto> lottos;
    private final List<Integer> winningNumbers;
    private final Integer bonusNumber;

    private LottoDto(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        this.lottos = lottos;
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    public static LottoDto of(List<Lotto> lottos, List<Integer> winningNumbers, Integer bonusNumber) {
        return new LottoDto(lottos, winningNumbers, bonusNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public int getLottosSize() {
        return lottos.size();
    }

}

