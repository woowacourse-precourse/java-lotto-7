package lotto.view;

import lotto.constant.LottoConstant;
import lotto.constant.LottoPrintMessage;
import lotto.dto.LottoIssueCountDTO;
import camp.nextstep.edu.missionutils.Console;
import lotto.dto.LottoWinNumbersDTO;
import lotto.exception.*;

import java.util.*;

public class LottoInput {

    public static LottoIssueCountDTO getIssueCount() {
        try {
            System.out.println(LottoPrintMessage.GUIDE_MESSAGE_A);

            String userInput = Console.readLine();
            int price = parsePrice(userInput);
            validatePrice(price);

            return new LottoIssueCountDTO(price);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getIssueCount();
        }
    }

    public static LottoWinNumbersDTO getWinNumbers() {
        try {
            List<Integer> exactNumbers = getExactNumbers();
            int bonusNumber = getBonusNumber();

            validateNumbersDuplicate(exactNumbers, bonusNumber);

            return new LottoWinNumbersDTO(exactNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinNumbers();
        }
    }

    private static List<Integer> getExactNumbers() throws IllegalArgumentException {
        System.out.println(LottoPrintMessage.GUIDE_MESSAGE_B);

        String exactNumbersInput = Console.readLine();
        List<Integer> exactNumbers = parseExactNumbers(exactNumbersInput);
        validateWinNumbers(exactNumbers);

        return exactNumbers;
    }

    private static int getBonusNumber() throws IllegalArgumentException {
        System.out.println(LottoPrintMessage.GUIDE_MESSAGE_C);

        String bonusNumberInput = Console.readLine();
        int bonusNumber = parseBonusNumber(bonusNumberInput);
        validateLottoNumber(bonusNumber);

        return bonusNumber;
    }

    /* =====| PARSER |===== */

    private static int parsePrice(String userInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new InvalidPriceFormatException();
        }
    }

    private static List<Integer> parseExactNumbers(String userInput) throws IllegalArgumentException {
        try {
            String[] inputSplit = userInput.split(",");

            return Arrays.stream(inputSplit)
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new InvalidExactNumberFormatException();
        }
    }

    private static int parseBonusNumber(String userInput) throws IllegalArgumentException {
        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new InvalidBonusNumberFormatException();
        }
    }

    /* =====| VALIDATION |===== */

    private static boolean validatePrice(int price) throws IllegalArgumentException {
        if (price % 1000 > 0) {
            throw new InvalidPriceValueException();
        }

        return true;
    }

    private static boolean validateWinNumbers(List<Integer> winNumbers) throws IllegalArgumentException {
        if (winNumbers.size() != 6) {
            throw new InvalidExactNumberFormatException();
        }

        validateNumbersDuplicate(winNumbers);

        for (int winNumber : winNumbers) {
            validateLottoNumber(winNumber);
        }

        return true;
    }

    private static boolean validateLottoNumber(int lottoNumber) throws IllegalArgumentException {
        if (
                lottoNumber < LottoConstant.MIN_LOTTO_NUMBER ||
                        lottoNumber > LottoConstant.MAX_LOTTO_NUMBER
        ) {
            throw new InvalidLottoNumberRangeException();
        }

        return true;
    }

    private static boolean validateNumbersDuplicate(List<Integer> numbers, Integer... args) {
        Set<Integer> testSet = new HashSet<>(numbers);
        int numbersCount = numbers.size();
        if ( args.length > 0 ) {
            testSet.addAll(Arrays.asList(args));
            numbersCount += args.length;
        }

        if ( testSet.size() != numbersCount ) {
            throw new DuplicateLottoNumberException();
        }

        return true;
    }
}