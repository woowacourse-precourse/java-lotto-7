package lotto.application;

import lotto.domain.Lottos;
import lotto.domain.PrizeNumber;

public interface Printer {

    void print(String message);

    void printPurchaseResult(int quantity, Lottos lottos);

//    void printPrizeResult(PrizeNumber prizeNumber);
}
