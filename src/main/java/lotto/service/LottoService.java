package lotto.service;

import lotto.domain.Lotto;

import java.util.List;

public interface LottoService {

    void play(int amount, List<Integer> winNumbers, int bonusNumber);
    List<Lotto> showLottoList();
    void showResult();
}
