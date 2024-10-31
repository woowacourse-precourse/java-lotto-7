package lotto.model;

import lotto.utils.InputLottoNumbersValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> InputLottoNumbersValidator.validateWinningNumbers(lotto.getNumbers()));
        this.lottos = new ArrayList<>(lottos);
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                .map(Lotto::getNumbers)
                .collect(Collectors.toList());
    }

    public int getTotalCount() {
        return lottos.size();
    }

    public void addLotto(Lotto lotto) {
        InputLottoNumbersValidator.validateWinningNumbers(lotto.getNumbers());
        lottos.add(lotto);
    }
}
