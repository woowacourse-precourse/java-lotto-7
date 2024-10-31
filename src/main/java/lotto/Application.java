package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {

    public static final String INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 입력값은 숫자여야 합니다.";
    public static final String INVALID_MONEY_FORMAT_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";

    public static void main(String[] args) {
        Integer purchaseMoney = null;

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                var moneyInput = Console.readLine();
                purchaseMoney = validateIntegerInput(moneyInput);
                validatePurchaseMoney(purchaseMoney);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        var purchasedLottos = buyLottos(purchaseMoney);
        // TODO: 추가 기능 구현
    }

    private static List<Lotto> buyLottos(Integer purchaseMoney) {
        var lottoCount = purchaseMoney / 1000;
        List<Lotto> purchasedLottos = new ArrayList<>();

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLottos.add(lotto);
        }

        return purchasedLottos;
    }

    public static Integer validateIntegerInput(String input) {
        try {
            var number = Integer.parseInt(input);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validatePurchaseMoney(Integer purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_FORMAT_MESSAGE);
        }
    }
}
