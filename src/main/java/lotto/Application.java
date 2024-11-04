package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        RandomLotto randomLotto = RandomLotto.getInstance();
        IOManager ioManager = new IOManager();

        ioManager.moneyInput();
        List<Integer> numbers = ioManager.numbersInput();
        Lotto lotto = new Lotto(numbers);
        int bonusNumber = ioManager.bonusInput();

    }
}
