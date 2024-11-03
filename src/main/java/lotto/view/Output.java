package lotto.view;

import lotto.domain.Lottos;

public interface Output {
    void outputError(Exception exception);
    void showLottos(Lottos lottos);
    void goToNext();
}
