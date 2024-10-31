package lotto.model;

import lotto.utils.InputLottoNumbersValidator;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        InputLottoNumbersValidator.validateLottoNumbers(lottos);
        this.lottos = new ArrayList<>(lottos);
    }

    public List<List<Integer>> getLottoNumbers() {
        return lottos.stream()
                .map(lotto -> new ArrayList<>(lotto.numbers))
                .collect(Collectors.toList());
    }

    public int getTotalCount() {
        return lottos.size();
    }

    public void addLotto(Lotto lotto) {
        InputLottoNumbersValidator.validateLottoNumbers(this.lottos);
        lottos.add(lotto);
    }
}
