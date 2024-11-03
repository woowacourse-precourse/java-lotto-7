package lotto.domain.lottoGeneratir;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.Lotto;
import lotto.dto.WinningLotto;

public class RandomLottoGenerator implements LottoGenerator<List<Lotto>,WinningLotto> {
    @Override
    public List<Lotto> generateLottos(List<List<Integer>> randomNumbers) {
        List<Lotto> lottos = new ArrayList<>();

        for(int i = 0; i < randomNumbers.size(); i++){
            lottos.add(generateLotto(randomNumbers.get(i)));
        }

        return lottos;
    }

    private Lotto generateLotto(List<Integer> lottoNumbers){
        return new Lotto(lottoNumbers);
    }

    @Override
    public WinningLotto generateWinningLotto(List<Integer> numbers, int bonusNumber) {
        return new WinningLotto(numbers, bonusNumber);
    }
}
