package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.domain.Results;

import java.util.stream.IntStream;

public interface OutputView {

    void showLottos(Lottos lottos);

    void showResults(Results results, Money money);

    String isSecond(Result result, Integer rank);

}
