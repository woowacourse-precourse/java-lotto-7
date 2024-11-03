package lotto;

import static lotto.AppConstants.INSERT_BONUS_NUMBER;
import static lotto.AppConstants.INSERT_MONEY;
import static lotto.AppConstants.INSERT_WINNING_NUMBERS;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoSystem lottoMachine = new LottoSystem();

        int money = View.inputLottoPurchaseMoney(INSERT_MONEY);
        List<Lotto> boughtLottos = lottoMachine.buyLotto(money);

        System.out.printf("%n");
        lottoMachine.printLottoNumbers(boughtLottos);

        System.out.printf("%n");
        HashSet<Integer> numbers = View.inputWinningNumbers(INSERT_WINNING_NUMBERS);
        lottoMachine.setWinningNumbers(numbers);

        System.out.printf("%n");
        int bonusNumber = View.inputBonusNumber(INSERT_BONUS_NUMBER, lottoMachine.getWinningNumbers());
        lottoMachine.setBonusNumber(bonusNumber);

        lottoMachine.processLottoResult(boughtLottos);
        System.out.printf("%n");
        lottoMachine.printWinningStatistics();
    }
}

