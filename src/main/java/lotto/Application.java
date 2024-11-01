package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Lotto;

public class Application {
    public static void main(String[] args) {
        int lottoAmount = purchaseLottos();
        List<Lotto> lottos = issueLottos(lottoAmount);
        printIssuedLottos(lottos);
        Lotto winningNumbers = pickWinningNumbers();
        int bonusNumber = pickBonusNumber(winningNumbers);

        Map<WinningRank, Integer> winningResult = drawLottos(lottos, winningNumbers, bonusNumber);
        printWinningRanks(winningResult);

        int earnings = calculateEarnings(winningResult);
        double earningsRate = calculateEarningsRate(earnings, lottoAmount * 1000);
        printEarningsRate(earningsRate);
    }

    private static int purchaseLottos() {
        try {
            String purchaseAmountInput = inputPurchaseAmount();
            int purchaseAmount = countLottoAmount(purchaseAmountInput);
            return purchaseAmount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseLottos();
        }
    }

    public static List<Lotto> issueLottos(int purchaseAmount) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            lottos.add(issueOneLotto(pickAscendingNumbers()));
        }
        return lottos;
    }

    private static void printIssuedLottos(List<Lotto> lottos) {
        System.out.println(String.format("\n%d개를 구매했습니다.", lottos.size()));
        for (Lotto lotto : lottos) {
            StringBuilder issuedLottos = new StringBuilder("[");
            List<Integer> numbers = lotto.getNumbers();
            for (int i = 0; i < 6; i++) {
                issuedLottos.append(numbers.get(i));
                if (i == 5) {
                    issuedLottos.append("]");
                    break;
                }
                issuedLottos.append(", ");
            }
            System.out.println(issuedLottos);
        }
    }

    private static Lotto pickWinningNumbers() {
        try {
            String winningNumbersInput = inputWinningNumbers();
            return registerWinningNumbers(winningNumbersInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return pickWinningNumbers();
        }
    }

    private static int pickBonusNumber(Lotto winningNumbers) {
        try {
            String bonusNumberInput = inputBonusNumber();
            return registerBonusNumber(bonusNumberInput, winningNumbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return pickBonusNumber(winningNumbers);
        }
    }

    public static Map<WinningRank, Integer> drawLottos(List<Lotto> lottos, Lotto winningNumbers, int bonusNumber) {
        Map<WinningRank, Integer> winningResult = initializeWinningResult();
        for (Lotto lotto : lottos) {
            int matchingAmount = winningNumbers.drawEachLotto(lotto);
            boolean matchesBonusNumber = drawBonusNumber(lotto, bonusNumber);
            WinningRank winningRank = WinningRank.findWinningStatusByMatchingAmount(matchingAmount, matchesBonusNumber);

            int lastWinningLottoAmount = winningResult.get(winningRank);
            winningResult.replace(winningRank, lastWinningLottoAmount + 1);
        }
        return winningResult;
    }

    private static void printWinningRanks(Map<WinningRank, Integer> winningResult) {
        System.out.println("\n당첨 통계\n---");
        for (WinningRank winningRank : WinningRank.findWinningRanksInAscendingOrder()) {
            String matchingAmountMessage = WinningRank.findMatchingAmountMessage(winningRank);
            System.out.println(String.format(
                    matchingAmountMessage + "(%s원) - %d개"
                    , winningRank.getMatchingAmount()
                    , winningRank.getPriceString()
                    , winningResult.get(winningRank)
            ));
        }
    }

    public static int calculateEarnings(Map<WinningRank, Integer> winningResult) {
        int earnings = 0;
        for (WinningRank winningRank : WinningRank.findWinningRanksInAscendingOrder()) {
            earnings += winningRank.getPrice() * winningResult.get(winningRank);
        }
        return earnings;
    }

    public static double calculateEarningsRate(int earnings, int expense) {
        return ((double) earnings) / expense * 100;
    }

    private static void printEarningsRate(double earningsRate) {
        System.out.println(String.format(
                "\n총 수익률은 %.1f%%입니다."
                , Math.round(earningsRate * 10) / 10.0
        ));
    }

    private static Map<WinningRank, Integer> initializeWinningResult() {
        Map<WinningRank, Integer> winningResult = new HashMap<>();
        for (WinningRank winningRank : WinningRank.values()) {
            winningResult.put(winningRank, 0);
        }
        return winningResult;
    }

    public static boolean drawBonusNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public static int registerBonusNumber(String bonusNumberInput, Lotto winningNumbers) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 1 이상 45 이하의 정수를 입력해주세요.");
        }
        winningNumbers.validateDuplicationWithBonusNumber(bonusNumber);
        return bonusNumber;
    }

    private static String inputBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        validateInputInteger(bonusNumberInput);
        return bonusNumberInput;
    }

    private static String inputWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String winningNumbersInput = Console.readLine();
        validateInputValue(winningNumbersInput);
        return winningNumbersInput;
    }

    public static Lotto registerWinningNumbers(String winningNumbersInput) {
        try {
            List<Integer> winningNumbers = new ArrayList<>();
            for (String winningNumber : winningNumbersInput.split(",", -1)) {
                winningNumbers.add(Integer.parseInt(winningNumber.trim()));
            }
            return new Lotto(winningNumbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자값만 입력해주세요.");
        }
    }

    public static Lotto issueOneLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    private static String inputPurchaseAmount() {
        System.out.println("\n구입금액을 입력해 주세요.");
        String purchaseAmount = Console.readLine();
        validateInputInteger(purchaseAmount);
        return purchaseAmount;
    }

    public static void validateInputInteger(String inputInteger) {
        validateInputValue(inputInteger);
        if (!inputInteger.matches("^[1-9]\\d*$")) {
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }
        if (inputInteger.length() > 10) {
            throw new IllegalArgumentException("[ERROR] 10자리 이하의 금액을 입력해주세요.");
        }
    }

    public static void validateInputValue(String inputValue) {
        if (inputValue == null
                || inputValue.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 값을 입력해주세요.");
        }
    }

    public static int countLottoAmount(String purchaseAmountInput) {
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000 단위의 금액을 입력해주세요.");
        }
        return purchaseAmount / 1000;
    }

    public static List<Integer> pickAscendingNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted() // 오름차순 정렬
                .collect(Collectors.toList());
    }
}
