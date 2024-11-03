package lotto.domain.lottoGeneratir;

import java.util.List;

public interface LottoGenerator<L, W> {
    L generateLottos(List<List<Integer>> randomNumbers);
    W generateWinningLotto(List<Integer> numbers, int bonusNumber);
}
