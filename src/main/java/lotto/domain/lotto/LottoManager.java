package lotto.domain.lotto;

import lotto.utils.RandomNumbersSelector;
import lotto.utils.SortUtils;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final LottoNumbersGenerator lottoNumbersGenerator;
    private List<Lotto> lottos;

    public LottoManager(LottoNumbersGenerator lottoNumbersGenerator) {
        this.lottoNumbersGenerator = lottoNumbersGenerator;
        this.lottos = new ArrayList<>();
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void createLottos(int buyLottoCount) {
        for (int i = 0; i < buyLottoCount; i++) {
            List<Integer> randomNumbers = RandomNumbersSelector.selectRandomNumbers();
            List<Integer> lottoNumbers = lottoNumbersGenerator.generateLottoNumbers(randomNumbers);
            List<Integer> sortedLottoNumbers = SortUtils.sortNumbers(lottoNumbers);
            createLottosByRandomNumbers(sortedLottoNumbers);
        }
    }

    private void createLottosByRandomNumbers(List<Integer> randomNumbers) {
        Lotto lotto = new Lotto(randomNumbers);
        lottos.add(lotto);
    }
}
