package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.Ranking;
import lotto.domain.Result;
import lotto.exception.LottoErrorMessage;
import lotto.exception.LottoArgumentException;

import java.util.*;

import static lotto.validation.LottoNumbersValidation.*;
import static lotto.validation.MoneyValidation.isValidateAmount;

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
        isValidateInput(inputAmount);

        try {
            int amount = Integer.parseInt(inputAmount);
            isValidateAmount(amount);
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
        isValidateInput(inputWinNumbers);

        try {
            List<Integer> winNumbers = Arrays
                    .stream(inputWinNumbers.split(","))
                    .map(String::strip).map(Integer::parseInt)
                    .toList();
            isValidateLottoNumbers(winNumbers);
            return winNumbers;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.WIN_NUMBERS_CONTAINS_LETTER_ERROR);
        }
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
        isValidateInput(inputBonusNumber);

        try {
            int bonusNumber = Integer.parseInt(inputBonusNumber);
            isValidateBonusNumber(bonusNumber, winNumbers);
            return bonusNumber;
        } catch (NumberFormatException e) {
            throw new LottoArgumentException(LottoErrorMessage.NOT_NUMBER_ERROR);
        }
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

    private static void isValidateInput(String input) {
        if(input == null || input.equals("\n") || input.isBlank()) {
            throw new LottoArgumentException(LottoErrorMessage.INVALID_INPUT_ERROR);
        }
    }
}
