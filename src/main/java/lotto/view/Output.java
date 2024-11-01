package lotto.view;

import java.util.List;
import lotto.domain.Lotto;

public interface Output {

    void printlnMessage(PrintMessage printMessage);

    void printBuyResult(Integer purchase);

    void printLotto(List<Lotto> lottos);

    void printWinningDetail(List<String> winning);

    void printProfitRate(float profit);
}
