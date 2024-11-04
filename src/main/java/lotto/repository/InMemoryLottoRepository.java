package lotto.reposi;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;

public class InMemoryLottoRepository implements LottoRepository {

    private List<List<Integer>> lottoNumbers = new ArrayList<>();
    private Lotto winningLotto;
    private Bonus bonus;

    @Override
    public void saveLottoNumbers(List<List<Integer>> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    @Override
    public List<List<Integer>> getLottoNumbers() {
        return lottoNumbers;
    }

    @Override
    public void saveWinningNumbers(Lotto winningLotto) {
        this.winningLotto = winningLotto;
    }

    @Override
    public void saveBonusNumbers(Bonus bonus) {
        this.bonus = bonus;
    }

    @Override
    public Lotto getWinningNumbers() {
        return winningLotto;
    }

    @Override
    public Bonus getBonusNumber() {
        return bonus;
    }

}
