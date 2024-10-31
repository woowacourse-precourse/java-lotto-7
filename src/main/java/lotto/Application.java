package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoSystem lottoMachine = new LottoSystem();

        System.out.println(StringPool.INSERT_MONEY);
        List<Lotto> boughtLottos = lottoMachine.buyLotto(Integer.parseInt(Console.readLine()));

        System.out.printf("%n");

        lottoMachine.printSoldLottos(boughtLottos);

        System.out.printf("%n");
        System.out.println(StringPool.INSERT_WINNING_NUMBERS);
        lottoMachine.setWinningNumbers(Console.readLine());

        System.out.printf("%n");
        System.out.println(StringPool.INSERT_BONUS_NUMBER);
        lottoMachine.setBonusNumber(Integer.parseInt(Console.readLine()));

        lottoMachine.processLottoResult(boughtLottos);
        System.out.printf("%n");
        lottoMachine.printWinningStatistics();

    }
}

