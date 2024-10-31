package lotto.model;

import lotto.utils.InputLottoNumbersValidator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Lottos {
    private final Map<Integer, List<Integer>> lottoMap;
    private final int totalInvestment;

    public Lottos(int totalInvestment) {
        this.lottoMap = new HashMap<>();
        this.totalInvestment = totalInvestment;
    }

    public void addLotto(int id, List<Integer> numbers) {
        InputLottoNumbersValidator validator = new InputLottoNumbersValidator();
        validator.validateWinningNumbers(numbers);
        lottoMap.put(id, numbers);
    }

    public List<Integer> getLottoNumbers(int id) {
        return lottoMap.get(id);
    }
}
