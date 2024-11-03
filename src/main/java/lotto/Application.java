package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Integer money = Input.inputMoney();
        List<Lotto> lottos = Lotto.start(money);
        List <Integer> winNumbers = Input.inputWinNumbers();
        Integer bonusNumber = Input.inputBonusNumber(winNumbers);

        LottoStatistics statistics = new LottoStatistics();

        for (Lotto lotto : lottos) {
            LottoResult result = lotto.checkWinning(winNumbers, bonusNumber);
            statistics.recordWin(result);
        }

        Print.printStatistics(statistics.getStatistics());
    }
}
