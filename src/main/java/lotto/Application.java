package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoSystem system = new LottoSystem();
        System.out.println(StringPool.INSERT_MONEY);
        List<Lotto> boughtLottos = system.buyLotto(Integer.parseInt(Console.readLine()));
        system.printSoldLottos(boughtLottos);
        System.out.print(System.lineSeparator());
        System.out.println(StringPool.INSERT_WINNING_NUMBERS);
        system.setWinningNumbers(Console.readLine());
    }
}

