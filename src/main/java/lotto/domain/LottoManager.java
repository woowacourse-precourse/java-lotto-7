package lotto.domain;

import lotto.utils.RandomNumbersSelector;

import java.util.ArrayList;
import java.util.List;

public class LottoManager {
    private final LottoGenerator lottoGenerator;
    private List<Lotto> lottos;

    public LottoManager(LottoGenerator lottoGenerator) {
        this.lottoGenerator = lottoGenerator;
        this.lottos = new ArrayList<>();
    }

    public void createLottosByRandomNumbers(int buyLottoCount) {
        for (int i = 0; i < buyLottoCount; i++) {
            List<Integer> randomNumbers = RandomNumbersSelector.selectRandomNumbers();
            List<Integer> lottoNumbers = lottoGenerator.generateLottoNumbers(randomNumbers);
            Lotto lotto = new Lotto(lottoNumbers);
            lottos.add(lotto);
        }
    }
}
