package lotto.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoResults {
    private final List<Lotto> userLottos;
    private final Lotto winningLotto;
    private final int bonusNumber;
    private final Map<Rank, Integer> resultMap = new HashMap<>();

    public LottoResults(List<Lotto> userLottos, Lotto winningLotto, int bonusNumber) {
        this.userLottos = userLottos;
        this.winningLotto = winningLotto;
        this.bonusNumber = bonusNumber;
        initializeResultMap();
    }

    private void initializeResultMap() {
        return;
    }

    public int calculateResult(List<Integer> winningNumbers, List<Integer> userNumbers, int bonusNumber) {
        return (int) winningNumbers.stream().filter(userNumbers::contains).count();
    }

    public Map<Rank, Integer> getResultMap() {
        return resultMap;
    }
}
