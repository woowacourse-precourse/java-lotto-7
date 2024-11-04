package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RandomLotto randomLotto = RandomLotto.getInstance();
        IOManager ioManager = new IOManager();

        int inputMoney = ioManager.moneyInput();
        List<Integer> numbers = ioManager.numbersInput();
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = ioManager.bonusInput();

        randomLotto.lottoCheck(lotto, bonusNumber);
        double rate = randomLotto.winningRateCalculator(inputMoney);
        ioManager.printPrizeCount(rate);
    }
}
