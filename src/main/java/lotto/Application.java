package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static final String INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 입력값은 숫자여야 합니다.";
    public static final String INVALID_MONEY_FORMAT_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void main(String[] args) {
        Integer purchaseMoney = null;

        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                var moneyInput = Console.readLine();
                purchaseMoney = validateIntegerInput(moneyInput);

                validatePurchaseMoney(purchaseMoney);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        var purchasedLottos = buyLotto(purchaseMoney);
        Lotto winningLotto = null;

        Integer bonusNumber = null;

        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                var winningLottoInput = Console.readLine();

                winningLotto = validateWinningLottoInput(winningLottoInput);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                var bonusNumberInput = Console.readLine();

                bonusNumber = validateIntegerInput(bonusNumberInput);
                validateNumberRange(bonusNumber);
                System.out.println();
                break;
            } catch (IllegalArgumentException e) {

            }
        }

        List<PointResult> pointResults = new ArrayList<>();

        // TODO: 추가 기능 구현
        for (Lotto purchasedLotto : purchasedLottos) {
            var pointResult = Lotto.compareLotto(winningLotto, bonusNumber, purchasedLotto);
            pointResults.add(pointResult);
        }
    }

    public static Integer validateNumberRange(Integer number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR_MESSAGE);
        }
        return number;
    }

    public static Lotto validateWinningLottoInput(String winningLottoInput) {
        try {
            List<Integer> numbers = Arrays.stream(winningLottoInput.split(","))
                    .map(Application::validateIntegerInput)
                    .map(Application::validateNumberRange)
                    .collect(Collectors.toList());

            Lotto winningLotto = new Lotto(numbers);
            return winningLotto;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Lotto> buyLotto(Integer purchaseMoney) {
        var lottoCount = purchaseMoney / 1000;
        List<Lotto> purchasedLottos = new ArrayList<>();
        System.out.println(lottoCount + "개를 구매했습니다.");

        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            purchasedLottos.add(lotto);
            Lotto.printLotto(lotto);
        }

        System.out.println();
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
