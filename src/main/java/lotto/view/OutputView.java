package lotto.view;

import lotto.domain.Lottos;

public interface OutputView {
    void printPurchasedLottoCount(int count);

    void printLottoTickets(Lottos lottos);
}
