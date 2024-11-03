package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static constant.Message.*;

public class Application {
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmount();

        ArrayList<Lotto> lottoTickets = generateLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);

        ArrayList<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber(winningNumbers);

        LottoResult lottoResult = new LottoResult(lottoTickets, winningNumbers, bonusNumber);
        lottoResult.print();
    }

    private static String getInputString(String message) {
        System.out.println("\n" + message);
        return Console.readLine();
    }

    private static void validateNumericString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NON_NUMERIC_STRING.getMessage());
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException(ERROR_NON_POSITIVE_STRING.getMessage());
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_NON_THOUSAND_UNIT.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        while (true) {
            String purchaseAmountInput = getInputString(INPUT_REQUEST_PURCHASE_AMOUNT.getMessage());
            try {
                return getValidatedPurchaseAmount(purchaseAmountInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validatePurchaseAmount(String purchaseAmountInput) {
        validateNumericString(purchaseAmountInput);
        int purchaseAmount = Integer.parseInt(purchaseAmountInput);
        validatePositiveNumber(purchaseAmount);
        validateThousandUnit(purchaseAmount);
    }

    private static int getValidatedPurchaseAmount(String purchaseAmountInput) {
        validatePurchaseAmount(purchaseAmountInput);
        return Integer.parseInt(purchaseAmountInput);
    }

    private static int calculateLottoCount(int purchaseAmount) {
        return purchaseAmount / 1000;
    }

    private static ArrayList<Lotto> generateLottoTickets(int purchaseAmount) {
        int lottoCount = calculateLottoCount(purchaseAmount);
        ArrayList<Lotto> lottoTickets = new ArrayList<>();

        for (int count = 0; count < lottoCount; count++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoNumbers);
            lottoTickets.add(new Lotto(lottoNumbers));
        }
        return lottoTickets;
    }

    private static void printLottoTickets(ArrayList<Lotto> lottoTickets) {
        System.out.println("\n" + lottoTickets.size() + PRINT_LOTTO_TICKETS_SIZE.getMessage());
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    private static void validateWinningNumbersCount(String[] winningNumbersInputSplits) {
        if (winningNumbersInputSplits.length != 6) {
            throw new IllegalArgumentException(ERROR_WINNING_NUMBERS_COUNT.getMessage());
        }
    }

    private static void validateNumericStrings(String[] winningNumbersInputSplits) {
        for (String winningNumberInputSplit : winningNumbersInputSplits) {
            try {
                validateNumericString(winningNumberInputSplit);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ERROR_INCLUDING_NON_NUMERIC_NUMBER.getMessage());
            }
        }
    }

    private static void validateLottoNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ERROR_OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
        }
    }

    private static void validateLottoNumbersInRange(ArrayList<Integer> numbers) {
        for (int number : numbers) {
            try {
                validateLottoNumberInRange(number);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException(ERROR_INCLUDING_OUT_OF_LOTTO_NUMBER_RANGE.getMessage());
            }
        }
    }

    private static ArrayList<Integer> parseIntWinningNumbers(String[] winningNumbersInputSplits) {
        ArrayList<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumbersInputSplit : winningNumbersInputSplits) {
            winningNumbers.add(Integer.parseInt(winningNumbersInputSplit));
        }
        return winningNumbers;
    }

    public static void validateUniqueNumbers(ArrayList<Integer> numbers) {
        HashSet<Integer> set = new HashSet<>();
        for (int number : numbers) {
            if (!set.add(number)) {
                throw new IllegalArgumentException(ERROR_DUPLICATE_NUMBERS.getMessage());
            }
        }
    }

    private static void validateWinningNumbers(String[] winningNumbersInputSplits) {
        validateWinningNumbersCount(winningNumbersInputSplits);
        validateNumericStrings(winningNumbersInputSplits);
        ArrayList<Integer> winningNumbers = parseIntWinningNumbers(winningNumbersInputSplits);
        validateLottoNumbersInRange(winningNumbers);
        validateUniqueNumbers(winningNumbers);
    }

    private static ArrayList<Integer> getValidatedWinningNumbers(String[] winningNumbersInputSplits) {
        validateWinningNumbers(winningNumbersInputSplits);
        return parseIntWinningNumbers(winningNumbersInputSplits);
    }

    private static ArrayList<Integer> getWinningNumbers() {
        while (true) {
            String winningNumbersInput = getInputString(INPUT_REQUEST_WINNING_NUMBERS.getMessage());
            String[] winningNumbersInputSplits = winningNumbersInput.split(",");
            try {
                return getValidatedWinningNumbers(winningNumbersInputSplits);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validateNewNumber(ArrayList<Integer> winningNumbers, int bonusNumber) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_NON_NEW_NUMBER.getMessage());
        }
    }

    private static void validateBonusNumber(ArrayList<Integer> winningNumbers, String bonusNumberInput) {
        validateNumericString(bonusNumberInput);
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        validateLottoNumberInRange(bonusNumber);
        validateNewNumber(winningNumbers, bonusNumber);
    }

    private static int getValidatedBonusNumber(ArrayList<Integer> winningNumbers, String bonusNumberInput) {
        validateBonusNumber(winningNumbers, bonusNumberInput);
        return Integer.parseInt(bonusNumberInput);
    }

    private static int getBonusNumber(ArrayList<Integer> winningNumbers) {
        while (true) {
            String bonusNumberInput = getInputString("보너스 번호를 입력해 주세요.");
            try {
                return getValidatedBonusNumber(winningNumbers, bonusNumberInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
