package lotto.ui;

import lotto.domain.Lotto;

import java.util.List;

public interface ResultView {
    void displayLottos(List<Lotto> lottos);
}
