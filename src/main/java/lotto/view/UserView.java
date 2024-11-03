package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.Result;
import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoArgumentException;

import java.util.*;
import java.util.stream.Collectors;

public class UserView {
    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final String PRINT_NUMBER_LOTTO_LIST_MESSAGE = "개를 구매했습니다.";
    private static final String PRINT_LOTTO_RESULT_MESSAGE = "\n당첨 통계\n---";
    private static final String PRINT_RESULT_SUFFIX = "개";
    private static final String PRINT_TOTAL_PRIZE_RATE_MESSAGE = "총 수익률은 %.1f%%입니다.";

    public static int printAndGetAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        return getAmount();
    }

    private static int getAmount() {
        try {
            return checkAmount(Console.readLine());
        } catch (LottoArgumentException e) {
            System.out.println(e.getMessage());
            return getAmount();
        }
    }

    private static int checkAmount(String inputAmount) {
        if (inputAmount == null || inputAmount.equals("\n") || inputAmount.isBlank()) {
            throw new LottoArgumentException(LottoErrorMessage.INVALID_INPUT_ERROR);
        }

        try {
            int amount = Integer.parseInt(inputAmount);

            if (amount < 1000) {
                throw new LottoArgumentException(LottoErrorMessage.LESS_MIN_AMOUNT_ERROR);
            }

            if (amount % 1000 != 0) {
                throw new LottoArgumentException(LottoErrorMessage.DIV_1_000_AMOUNT_ERROR);
            }

            return amount;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    public static void printRandomNumbersList(int number, List<Lotto> lottoList) {
        System.out.println("\n" + number + PRINT_NUMBER_LOTTO_LIST_MESSAGE);
        getNumbersList(lottoList);
    }

    private static void getNumbersList(List<Lotto> lottoList) {
        for (Lotto lotto : lottoList) {
            System.out.println(lotto.toString());
        }
    }

    public static List<Integer> printAndGetWinNumbers() {
        System.out.println(INPUT_WIN_NUMBERS_MESSAGE);
        return getWinNumbers();
    }

    private static List<Integer> getWinNumbers() {
        try {
            return checkWinNumbers(Console.readLine());
        } catch (LottoArgumentException e) {
            System.out.println(e.getMessage());
            return getWinNumbers();
        }
    }

    private static List<Integer> checkWinNumbers(String inputWinNumbers) {
        if (inputWinNumbers == null || inputWinNumbers.equals("\n") || inputWinNumbers.isBlank()) {
            throw new LottoArgumentException(LottoErrorMessage.INVALID_INPUT_ERROR);
        }

        try {
            List<Integer> winNumbers = Arrays
                    .stream(inputWinNumbers.split(","))
                    .map(String::strip)
                    .map(Integer::parseInt)
                    .toList();

            if (winNumbers.size() != 6) {
                throw new LottoArgumentException(LottoErrorMessage.WIN_NUMBERS_COUNT_ERROR);
            }

            if (!checkValidRangeNumbers(winNumbers)) {
                throw new LottoArgumentException(LottoErrorMessage.NUMBERS_RANGE_ERROR);
            }

            if (checkDuplicateNumbers(winNumbers)) {
                throw new LottoArgumentException(LottoErrorMessage.WIN_NUMBERS_DUPLICATE_ERROR);
            }

            return winNumbers;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.WIN_NUMBERS_CONTAINS_LETTER_ERROR);
        }
    }

    private static boolean checkValidRangeNumbers(List<Integer> winNumbers) {
        return winNumbers.stream().allMatch(number -> 1 <= number && number <= 45);
    }

    private static boolean checkDuplicateNumbers(List<Integer> winNumbers) {
        Set<Integer> duplicateNumbers = new HashSet<>();
        return winNumbers.stream().anyMatch(number -> !duplicateNumbers.add(number));
    }

    public static int printAndGetBonusNumber(List<Integer> winNumbers) {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return getBonusNumber(winNumbers);
    }

    private static int getBonusNumber(List<Integer> winNumbers) {
        try {
            return checkBonusNumbers(Console.readLine(), winNumbers);
        } catch (LottoArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winNumbers);
        }
    }

    private static int checkBonusNumbers(String inputBonusNumber, List<Integer> winNumbers) {
        if (inputBonusNumber == null || inputBonusNumber.equals("\n") || inputBonusNumber.isBlank()) {
            throw new LottoArgumentException(LottoErrorMessage.INVALID_INPUT_ERROR);
        }

        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);

            if (bonusNumber < 1 || 45 < bonusNumber) {
                throw new LottoArgumentException(LottoErrorMessage.NUMBERS_RANGE_ERROR);
            }

            if (checkDuplicateWinNumbersAndBonusNumber(bonusNumber, winNumbers)) {
                throw new LottoArgumentException(LottoErrorMessage.DUPLICATE_WIN_BONUS_NUMBER_ERROR);
            }

            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.NOT_NUMBER_ERROR);
        }
    }

    private static boolean checkDuplicateWinNumbersAndBonusNumber(int bonusNumber, List<Integer> winNumbers) {
        return winNumbers.stream().anyMatch(number -> number == bonusNumber);
    }

    public static void printLottoResult(Result result, int amount) {
        System.out.println(PRINT_LOTTO_RESULT_MESSAGE);

        for (Ranking ranking : Ranking.values()) {
            System.out.println(ranking.getRankResult() + result.getWinCount(ranking) + PRINT_RESULT_SUFFIX);
        }

        printWinPrizeRate(result, amount);
    }

    private static void printWinPrizeRate(Result result, int amount) {
        double winPrizeRate = result.getWinPrize() / (double) amount * 100;
        System.out.printf(PRINT_TOTAL_PRIZE_RATE_MESSAGE + "%n", Math.round(winPrizeRate * 10) / 10.0);
    }
}
