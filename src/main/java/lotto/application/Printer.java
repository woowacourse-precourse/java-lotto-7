package lotto.application;

import java.util.List;
import lotto.domain.Lottos;
import lotto.domain.prizelotto.PrizeLotto;

public interface Printer {

    void print(String message);

    void printNewLine();

    void printPurchaseResult(int quantity, Lottos lottos);

    void printPrizeResult(List<PrizeLotto> prizeLottos, double profit);
}
