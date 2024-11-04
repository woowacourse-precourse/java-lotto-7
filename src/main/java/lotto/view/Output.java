package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public interface Output {
    void printLottoTickets(List<Lotto> lottos);
    void printStatistics(String statistics);
}