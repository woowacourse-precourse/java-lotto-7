package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {

    public static final String INTEGER_INPUT_ERROR_MESSAGE = "[ERROR] 입력값은 숫자여야 합니다.";
    public static final String INVALID_MONEY_FORMAT_MESSAGE = "[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.";
    public static final String NUMBER_RANGE_ERROR_MESSAGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";

    public static void main(String[] args) {
        int purchaseMoney = getPurchaseMoney();
        List<Lotto> purchasedLottos = buyLotto(purchaseMoney);
        Lotto winningLotto = getWinningLotto();
        int bonusNumber = getBonusNumber();

        List<LottoRank> lottoRanks = purchasedLottos.stream()
                .map(lotto -> Lotto.compareLotto(winningLotto, bonusNumber, lotto))
                .collect(Collectors.toList());

        Map<LottoRank, Integer> lottoRankCounts = LottoRank.lottoRankCounts(lottoRanks);
        LottoRank.printLottoRanks(lottoRankCounts);

        float totalPrize = LottoRank.calculateTotalPrize(lottoRanks);
        float profitRate = calculateProfitRate(totalPrize, purchaseMoney);
        System.out.printf("총 수익률은 %.1f%%입니다.", profitRate);
    }

    private static int getPurchaseMoney() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String moneyInput = Console.readLine();
                int money = validateIntegerInput(moneyInput);
                validatePurchaseMoney(money);
                System.out.println();
                return money;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Lotto> buyLotto(int purchaseMoney) {
        int lottoCount = purchaseMoney / 1000;
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

    private static Lotto getWinningLotto() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String winningLottoInput = Console.readLine();
                return validateWinningLottoInput(winningLottoInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBonusNumber() {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String bonusNumberInput = Console.readLine();
                int bonusNumber = validateIntegerInput(bonusNumberInput);
                validateNumberRange(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validateNumberRange(int number) {
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
            return new Lotto(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static int validateIntegerInput(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INTEGER_INPUT_ERROR_MESSAGE);
        }
    }

    public static void validatePurchaseMoney(int purchaseMoney) {
        if (purchaseMoney % 1000 != 0) {
            throw new IllegalArgumentException(INVALID_MONEY_FORMAT_MESSAGE);
        }
    }

    public static float calculateProfitRate(float totalPrize, float purchaseMoney) {
        if (purchaseMoney == 0) {
            return 0f;
        }
        return (totalPrize / purchaseMoney) * 100;
    }
}
