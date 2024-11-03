package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        io.Print.print(io.Print.MONEY_INPUT_MESSAGE);
        int lottoNumber = exception.Handler.getLottoQuantity();

        io.Print.print(lottoNumber + io.Print.NUMBER_PRINT_MESSAGE);
        List<Lotto> lottos = Lottos.getLottos(lottoNumber);
        lotto.Lotto.printLottos(lottos);

        io.Print.print(io.Print.NUMBERS_INPUT_MESSAGE);
        Lotto winningLotto = Lottos.getWinningLotto();

        io.Print.print(io.Print.BONUS_NUMBER_INPUT_MESSAGE);
        int bonusNumber = Lottos.getBonusNumber(winningLotto);

        List<Integer> rank = Lottos.countRank(lottos, winningLotto, bonusNumber);
        String statistic = Lottos.getResult(rank, lottoNumber);
        io.Print.print(statistic);
    }
}
