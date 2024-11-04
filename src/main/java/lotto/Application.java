package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.function.Supplier;

public class Application {

    public static void main(String[] args) {
        LottoShop shop = new LottoShop();
        int money = repeatUntilNoException(() -> inputMoney());
        List<Lotto> lottos = shop.sell(money);
        printLottos(lottos);
    }

    private static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String rawMoney = Console.readLine().trim();

        InputValidator.validateNaturalNumber(rawMoney);
        int money = Integer.parseInt(rawMoney);

        InputValidator.validateLottoAmountUnit(money);
        InputValidator.validateMaxPurchaseAmount(money);

        return Integer.parseInt(rawMoney);
    }

    private static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    private static <T> T repeatUntilNoException(Supplier<T> inputFunction) {
        while (true) {
            try {
                return inputFunction.get();
            } catch (IllegalArgumentException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
