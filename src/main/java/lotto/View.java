package lotto;

import static lotto.AppConstants.INPUT_NOT_INTEGER;
import static lotto.AppConstants.INVALID_BONUS_NUMBERS_INPUT;
import static lotto.AppConstants.INVALID_WINNING_NUMBERS_INPUT;
import static lotto.AppConstants.LOTTO_NUMBER_MAX;
import static lotto.AppConstants.LOTTO_NUMBER_MIN;
import static lotto.AppConstants.LOTTO_PRICE;
import static lotto.AppConstants.MONEY_LESS_THAN_1000;
import static lotto.AppConstants.MONEY_NOT_DIVIDED_BY_1000;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class View {

    public static int inputLottoPurchaseMoney(String displayMessage) {
        int number = 0;
        boolean validInput = false;
        while (!validInput) {
            System.out.println(displayMessage);
            String input = Console.readLine();
            try {
                number = Integer.parseInt(input);
                validatePurchaseCondition(number);
                validInput = true;
            } catch (NumberFormatException numberFormatException) {
                System.out.println(INPUT_NOT_INTEGER);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return number;
    }

    public static HashSet<Integer> inputWinningNumbers(String displayMessage) {
        HashSet<Integer> winningNumbers = new HashSet<>();
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println(displayMessage);
                String input = Console.readLine();
                List<Integer> numbers = parseStr2Integers(input);
                winningNumbers = checkValidLottoNumbers(numbers);
                validInput = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return winningNumbers;
    }

    public static int inputBonusNumber(String displayMessage, HashSet<Integer> winningNumbers) {
        boolean validInput = false;
        while (!validInput) {
            try {
                System.out.println(displayMessage);
                int number = Integer.parseInt(Console.readLine());
                isAlreadyWinningNumber(winningNumbers, number);
                checkNumberInLottoRange(number);
                return number;
            } catch (IllegalArgumentException e) {
                System.out.println(INVALID_BONUS_NUMBERS_INPUT);
            }
        }
        return 0;
    }

    private static void isAlreadyWinningNumber(HashSet<Integer> winningNumbers, int number) {
        if (winningNumbers.contains(number)) {
            throw new IllegalArgumentException();
        }
    }

    //쉼표로 시작하거나 끝날때. 쉼표와 쉼표 사이 공백이 있을때, 숫자와 공백이 같은 토큰에 있을때, 공백으로 시작할떄, 입력끝에 엔터 제외 다른 공백이 있을때
        //숫자 외에 다른게 있을떄. 연속되는 쉼표가 있을 떄.
    private static List<Integer> parseStr2Integers(String input) throws IllegalArgumentException {
        List<Integer> numbers = new ArrayList<>();
        StringTokenizer strtok = new StringTokenizer(input, ",");
        checkStrBothSides(input);
        while (strtok.hasMoreTokens()) {
            try {
                int luckyNumber = Integer.parseInt(strtok.nextToken());
                numbers.add(luckyNumber);
            } catch (NumberFormatException numberFormatException) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT);
            }
        }
        return numbers;
    }

    private static void checkStrBothSides(String input) {
        if (input.startsWith(",") || input.endsWith(",")) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT);
        }
    }

    //개수체크,중복체크, 숫자범위체크
    private static HashSet<Integer> checkValidLottoNumbers(List<Integer> numbers) throws IllegalArgumentException {
        HashSet<Integer> verifiedNumbers = new HashSet<>();
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT);
        }
        for (int number : numbers) {
            checkNumberInLottoRange(number);
            if (!verifiedNumbers.add(number)) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT);
            }
        }
        return verifiedNumbers;
    }

    private static boolean checkNumberInLottoRange(int number) {
        if (number < LOTTO_NUMBER_MIN || number > LOTTO_NUMBER_MAX) {
                throw new IllegalArgumentException(INVALID_WINNING_NUMBERS_INPUT);
        }
        return true;
    }
    private static void validatePurchaseCondition(int money) throws IllegalArgumentException {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(MONEY_LESS_THAN_1000);
        }
        if (money % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(MONEY_NOT_DIVIDED_BY_1000);
        }
    }
}
