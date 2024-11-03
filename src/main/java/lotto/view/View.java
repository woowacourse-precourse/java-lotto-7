package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.WinningPrize;

public class View {
    public static void promptForPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static long inputLottoPurchaseAmount() {
        String amountInput = Console.readLine();
        validatePurchaseAmount(amountInput);
        return Long.parseLong(amountInput);
    }

    private static void validatePurchaseAmount(String inputValue) {
        validateEmpty(inputValue);
        validateNumeric(inputValue);
    }

    private static void validateEmpty(String inputValue) {
        if (inputValue == null || inputValue.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력값이 없습니다.");
        }
    }

    private static void validateNumeric(String inputValue) {
        try {
            long amount = Long.parseLong(inputValue);
            validateNegative(amount);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자 형식이 아닙니다.");
        }
    }
    private static void validateNegative(long amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 금액은 음수가 될 수 없습니다.");
        }
    }







    public static void promptForWinningLotto() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void promptForWinningBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printLottoResults(LottoResult lottoResult, double returnRate) {
        System.out.println("\n당첨 통계");
        System.out.println("---");

        Map<WinningPrize, Integer> results = lottoResult.getResults();
        for (WinningPrize winningPrize : WinningPrize.values()) {
            if (winningPrize != WinningPrize.NONE_PRIZE) {
                System.out.printf("%s (%,d원) - %d개%n",
                        winningPrize.getDescription(),
                        winningPrize.getPrize(),
                        results.get(winningPrize));
            }
        }

        System.out.printf("총 수익률은 %.1f%%입니다.%n", returnRate);
    }



    public static List<Integer> inputWinningLotto() {
        String winningLottoInput = Console.readLine();
        validateEmpty(winningLottoInput);
        validateCommaFormat(winningLottoInput);
        return convertToNumbers(winningLottoInput);
    }

    public static int inputWinningBonusNumber() {
        String winningBonusNumberInput = Console.readLine();
        validateEmpty(winningBonusNumberInput);
        validateNumeric(winningBonusNumberInput);

        return Integer.parseInt(winningBonusNumberInput);
    }



    private static void validateCommaFormat(String input) {
        List<String> numbers = splitInputByComma(input);
        validateNumberFormat(numbers);
    }

    private static List<String> splitInputByComma(String input) {
        return Arrays.asList(input.split(","));
    }

    private static void validateNumberFormat(List<String> numbers) {
        for (String number : numbers) {
            validateNumber(number.trim());
        }
    }

    private static void validateNumber(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 쉼표(,)로 구분된 숫자만 입력 가능합니다.");
        }
    }

    private static List<Integer> convertToNumbers(String input) {
        List<String> numberStrings = splitInputByComma(input);
        List<Integer> numbers = new ArrayList<>();

        for (String numberStr : numberStrings) {
            numbers.add(Integer.parseInt(numberStr.trim()));
        }

        return numbers;
    }



    public static void printException(IllegalArgumentException e) {
        System.out.println("[ERROR] : " + e.getMessage());
    }




    public static void printPurchaseResult(Lottos purchasedLottos) {
        printPurchaseCount(purchasedLottos);
        printLottoNumbers(purchasedLottos);
    }

    private static void printPurchaseCount(Lottos purchasedLottos) {
        System.out.println(purchasedLottos.getSize() + "개를 구매했습니다.");
    }

    private static void printLottoNumbers(Lottos purchasedLottos) {
        List<Lotto> lottos = purchasedLottos.getLottos();
        for (Lotto lotto : lottos) {
            List<Integer> numbers = lotto.getNumbers();
            List<Integer> sortedNumbers = new ArrayList<>(numbers);
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }



}