package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        io.Print.print(io.Print.MONEY_INPUT_MESSAGE);
        int lottoNumber = exception.Handler.getLottoNumber();

        io.Print.print(lottoNumber + io.Print.NUMBER_PRINT_MESSAGE);
        List<Lotto> lottos = lotto.Collection.getLottos(lottoNumber);
        lotto.Lotto.printLottos(lottos);

        io.Print.print(io.Print.NUMBERS_INPUT_MESSAGE);
        Lotto winningLotto = lotto.Collection.getWinningLotto();

        io.Print.print(io.Print.BONUS_NUMBER_INPUT_MESSAGE);
        int bonusNumber = lotto.Collection.getBonusNumber(winningLotto);

        List<Integer> rank = lotto.Collection.countRank(lottos, winningLotto, bonusNumber);
        String statistic = io.Print.getStatistic(rank, lottoNumber);
        io.Print.print(statistic);
    }
}
