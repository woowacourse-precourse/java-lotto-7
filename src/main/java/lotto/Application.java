package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.CustomError;
import lotto.enums.LottoResultType;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    private static LottoMachine lottoMachine = new LottoMachine();

    public static void main(String[] args) {
        int purchaseAmount = promptPurchaseAmount();
        List<Lotto> lottos = lottoMachine.purchaseLotto(purchaseAmount);
        printLottosNum(lottos);
        List<Integer> winningNumbers = promptWinningNumbers();
        int bonusNumber = promptBonusNumber(winningNumbers);
        List<LottoResultType> lottoResults = lottoMachine.checkLottoResult(lottos, winningNumbers, bonusNumber);
        int totalPrizeMoney = lottoResults.stream()
                .mapToInt(LottoResultType::getPrizeMoney)
                .sum();
        printLottoResults(purchaseAmount, totalPrizeMoney, lottoResults);
        Console.close();
    }

    public static int promptPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmount = Console.readLine();

            if (isValidPurchaseAmount(purchaseAmount)) {
                return Integer.parseInt(purchaseAmount.trim());
            }

            handleInvalidPurchaseAmount();
        }
    }

    public static void printLottosNum(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());
        for (Lotto lotto : lottos) {
            System.out.println(
                    lotto.getNumbers().stream()
                            .sorted()
                            .toList()
            );
        }
    }

    public static List<Integer> promptWinningNumbers() {
        while (true) {
            System.out.println();
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbers = Console.readLine();

            if (isValidWinningNumbers(winningNumbers)) {
                return Arrays.stream(winningNumbers.split(",", -1))
                        .map(String::trim)
                        .map(Integer::parseInt)
                        .toList();
            }

            handleInvalidWinningNumbers();
        }
    }

    public static int promptBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();

            if (isValidBonusNumber(bonusNumber, winningNumbers)) {
                return Integer.parseInt(bonusNumber.trim());
            }

            handleInvalidBonusNumber();
        }
    }

    private static void printLottoResults(int purchaseAmount, int totalPrizeMoney, List<LottoResultType> lottoResults) {
        System.out.println();
        System.out.println("당첨 통계\n---");
        for (LottoResultType lottoResultType : LottoResultType.hasPrizeMoneyLottoResultType()) {
            printLottoResultByType(lottoResultType, lottoResults);
        }
        printEarningRate(purchaseAmount, totalPrizeMoney);
    }

    private static void printLottoResultByType(LottoResultType lottoResultType, List<LottoResultType> lottoResults) {
        String message = "{0}개 일치 ({1}원) - {2}개";
        if (lottoResultType == LottoResultType.SECOND_PLACE) {
            message = "{0}개 일치, 보너스 볼 일치 ({1}원) - {2}개";
        }

        long count = lottoResults.stream()
                .filter(lottoResult -> lottoResult == lottoResultType)
                .count();
        System.out.println(
                MessageFormat.format(
                        message, lottoResultType.getMatchCnt(), lottoResultType.getPrizeMoney(), count
                )
        );
    }

    private static void printEarningRate(int purchaseAmount, int totalPrizeMoney) {
        double profitRate = ((double) totalPrizeMoney / purchaseAmount) * 100;
        DecimalFormat df = new DecimalFormat("#,##0.0");
        String formattedProfitRate = df.format(profitRate);

        System.out.println("총 수익률은 " + formattedProfitRate + "%입니다.");
    }

    public static boolean isValidPurchaseAmount(String purchaseAmount) {
        if (purchaseAmount.isBlank()) {
            return false;
        }

        try {
            return Integer.parseInt(purchaseAmount.trim()) >= 1000 && Integer.parseInt(purchaseAmount.trim()) % 1000 == 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean isValidWinningNumbers(String winningNumbers) {
        String[] splitWinningNumbers = winningNumbers.split(",", -1);

        return !isBlank(winningNumbers) &&
                containsComma(winningNumbers) &&
                !hasDuplicationInWinningNumbers(splitWinningNumbers) &&
                hasSixNumbers(splitWinningNumbers) &&
                areNumbersInRange(splitWinningNumbers);
    }

    public static boolean isValidBonusNumber(String bonusNumberStr, List<Integer> winningNumbers) {
        return !isBlank(bonusNumberStr.trim()) &&
                areNumberInRange(bonusNumberStr.trim()) &&
                !isBonusNumInWinningNumbers(bonusNumberStr.trim(), winningNumbers);
    }

    private static void handleInvalidPurchaseAmount() {
        try {
            throw new IllegalArgumentException(CustomError.INVALID_PURCHASE_INPUT.getErrorMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleInvalidWinningNumbers() {
        try {
            throw new IllegalArgumentException(CustomError.INVALID_LOTTO_NUM_INPUT.getErrorMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void handleInvalidBonusNumber() {
        try {
            throw new IllegalArgumentException(CustomError.INVALID_BONUS_NUM_INPUT.getErrorMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static boolean isBlank(String input) {
        return input.isBlank();
    }

    private static boolean containsComma(String input) {
        return input.contains(",");
    }

    private static boolean hasDuplicationInWinningNumbers(String[] numbers) {
        Set<String> uniqueNumbers = new HashSet<>(Arrays.asList(numbers));
        return uniqueNumbers.size() != numbers.length;
    }

    private static boolean isBonusNumInWinningNumbers(String bonusNumberStr, List<Integer> winningNumbers) {
        int bonusNumber = Integer.parseInt(bonusNumberStr);
        for (Integer winningNumber : winningNumbers) {

            if (bonusNumber == winningNumber) {
                return true;
            }
        }

        return false;
    }

    private static boolean hasSixNumbers(String[] numbers) {
        if (numbers.length != 6) {
            return false;
        }

        for (String number : numbers) {

            if (number.isBlank()) {
                return false;
            }
        }
        return true;
    }

    private static boolean areNumberInRange(String number) {
        return number.trim().matches("^(?:[1-9]|[1-3][0-9]|4[0-5])$");
    }

    private static boolean areNumbersInRange(String[] numbers) {
        for (String number : numbers) {

            if (!areNumberInRange(number)) {
                return false;
            }
        }
        return true;
    }
}
