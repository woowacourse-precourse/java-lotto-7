package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {
    void generateLotto();

    void printLottos(List<Lotto> lottos);

    void printWinningStatistics(List<Integer> winningNumbers);

    void printRateOfReturn();
}