package lotto;

import java.util.List;

public interface Output {
    void printLottoNumberList(List<Lotto> lottos);
    void printTotalResult(int[] result);
    void printProfit(float profit);
}
