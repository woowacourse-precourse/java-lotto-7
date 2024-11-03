package lotto;

import exception.Handler;
import io.Print;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        Print.print(Print.MONEY_INPUT_MESSAGE);
        int lottoQuantity = Handler.getLottoQuantity();

        Print.print(lottoQuantity + Print.NUMBER_PRINT_MESSAGE);
        List<Lotto> lottos = Lottos.getLottos(lottoQuantity);
        Lotto.printLottos(lottos);

        Print.print(Print.NUMBERS_INPUT_MESSAGE);
        Lotto winningLotto = Lottos.getWinningLotto();

        Print.print(Print.BONUS_NUMBER_INPUT_MESSAGE);
        int bonusNumber = Lottos.getBonusNumber(winningLotto);

        List<Integer> rank = Lottos.countRank(lottos, winningLotto, bonusNumber);
        String statistic = Lottos.getResult(rank, lottoQuantity);
        Print.print(statistic);
    }
}
