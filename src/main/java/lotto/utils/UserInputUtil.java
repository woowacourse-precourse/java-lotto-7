package lotto.utils;

import lotto.constants.RegExConstants;
import lotto.exceptions.LottoNumbersException;
import lotto.exceptions.PurchaseUnitException;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class UserInputUtil {
    private static final String PURCHASE_REQUEST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_NUMBERS_REQUEST_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String LOTTO_NUMBERS_DELIMITER = ",";
    private static final int LOTTO_NUMBERS_SIZE = 6;
    public static long takePurchaseBudget() {
        while (true) {
            try {
                System.out.println(PURCHASE_REQUEST_MESSAGE);
                final String rawPurchaseAmount = readLine();
                return validatePurchaseAmount(rawPurchaseAmount);
            } catch (PurchaseUnitException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> takeLottoNumbers() {
        while (true) {
            try {
                System.out.println(LOTTO_NUMBERS_REQUEST_MESSAGE);
                final String rawPurchaseAmount = readLine();
                return validateLottoNumbers(rawPurchaseAmount);
            } catch (LottoNumbersException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static List<Integer> validateLottoNumbers(final String rawInput) {
        Matcher matcher = Pattern.compile(RegExConstants.LOTTO_NUMBERS_REGEX.getRegex())
                .matcher(rawInput);
        if (!matcher.matches()) {
            throw new LottoNumbersException();
        }
        List<Integer> numbers = Arrays.stream(rawInput.split(LOTTO_NUMBERS_DELIMITER))
                .map(Integer::parseInt)
                .distinct()
                .collect(Collectors.toList());
        if (numbers.size() != LOTTO_NUMBERS_SIZE) {
            throw new LottoNumbersException();
        }
        return numbers;
    }

    private static long validatePurchaseAmount(final String rawInput) {
        long parsedPurchaseAmount;

        try {
            parsedPurchaseAmount = Long.parseLong(rawInput);
        } catch (NumberFormatException e) {
            throw new PurchaseUnitException();
        }

        if (parsedPurchaseAmount % 1000 != 0 || parsedPurchaseAmount < 0) {
            throw new PurchaseUnitException();
        }
        return parsedPurchaseAmount;
    }
}
