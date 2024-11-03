package service;

import lotto.Lotto;

import java.util.List;

public interface LottoService {

    List<Lotto> generateLottos(int amount);
}
