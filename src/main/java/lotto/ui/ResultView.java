package lotto.ui;

import lotto.model.Lotto;
import lotto.model.LottoGame;

import java.util.List;

public interface ResultView {
    void displayLottos(List<Lotto> lottos);
    void printResult(LottoGame lottoGame);
}
