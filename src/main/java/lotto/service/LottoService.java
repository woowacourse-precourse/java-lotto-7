package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {

    List<Lotto> generateLottos(int amount);

    int[] getWinningCount(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber);
}
