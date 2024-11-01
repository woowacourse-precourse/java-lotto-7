package lotto;

import static lotto.AppConstants.INSERT_BONUS_NUMBER;
import static lotto.AppConstants.INSERT_MONEY;
import static lotto.AppConstants.INSERT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoSystem lottoMachine = new LottoSystem();

        int money = View.inputLottoPurchaseMoney(INSERT_MONEY);
        List<Lotto> boughtLottos = lottoMachine.buyLotto(money);

        System.out.printf("%n");
        lottoMachine.printSoldLottos(boughtLottos);

        System.out.printf("%n");
        System.out.println(INSERT_WINNING_NUMBERS);
        lottoMachine.setWinningNumbers(Console.readLine());

        System.out.printf("%n");
        System.out.println(INSERT_BONUS_NUMBER);
        lottoMachine.setBonusNumber(Integer.parseInt(Console.readLine()));

        lottoMachine.processLottoResult(boughtLottos);
        System.out.printf("%n");
        lottoMachine.printWinningStatistics();
    }
}

