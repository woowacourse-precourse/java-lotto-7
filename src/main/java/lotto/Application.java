package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 1.5 형식에 맞는 구입 금액이 입력될 때까지 반복하여 입력을 받는 기능
        int purchaseAmount = getPurchaseAmount();

        // 2.4 로또 번호를 통해 구매할 로또의 개수만큼 로또 객체를 생성하는 기능
        ArrayList<Lotto> lottoTickets = generateLottoTickets(purchaseAmount);
        // 2.5 로또의 번호를 출력하는 기능
        printLottoTickets(lottoTickets);

        // 3.7 형식에 맞는 당첨 번호가 입력될 때까지 반복하여 입력을 받는 기능
        ArrayList<Integer> winningNumbers = getWinningNumbers();

        // 4.1 보너스 번호를 입력 받는 기능
        String bonusNumberInput = getInputString("보너스 번호를 입력해 주세요.");

        try {
            // 4.2 입력된 보너스 번호를 정수로 변환할 수 없는 경우 예외 처리하는 기능
            validateNumericString(bonusNumberInput);
            // 4.3 입력된 보너스 번호가 범위(1~45)에 맞지 않는 경우 예외 처리하는 기능
            int bonusNumber = Integer.parseInt(bonusNumberInput);
            validateLottoNumberInRange(bonusNumber);
            // 4.4 당첨 번호와 중복되는 보너스 번호가 입력된 경우 예외 처리하는 기능
            validateNewNumber(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static String getInputString(String message) {
        System.out.println("\n" + message);
        return Console.readLine();
    }

    private static void validateNumericString(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 정수로 변환할 수 없는 문자열입니다.");
        }
    }

    private static void validatePositiveNumber(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("[ERROR] 양의 정수가 아닙니다.");
        }
    }

    private static void validateThousandUnit(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원으로 나누어 떨어지지 않는 금액입니다.");
        }
    }

    private static int getPurchaseAmount() {
        while (true) {
            String purchaseAmountInput = getInputString("구입 금액을 입력해 주세요.");
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
        System.out.println("\n" + lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket);
        }
    }

    private static void validateWinningNumbersCount(String[] winningNumbersInputSplits) {
        if (winningNumbersInputSplits.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호가 6개가 아닙니다.");
        }
    }

    private static void validateNumericStrings(String[] winningNumbersInputSplits) {
        for (String winningNumberInputSplit : winningNumbersInputSplits) {
            try {
                validateNumericString(winningNumberInputSplit);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 정수로 변환할 수 없는 문자열이 포함되어 있습니다.");
            }
        }
    }

    private static void validateLottoNumberInRange(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위를 벗어나는 값입니다.");
        }
    }

    private static void validateLottoNumbersInRange(ArrayList<Integer> numbers) {
        for (int number : numbers) {
            try {
                validateLottoNumberInRange(number);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("[ERROR] 로또 숫자의 범위를 벗어나는 값이 포함되어 있습니다.");
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
                throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
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
            String winningNumbersInput = getInputString("당첨 번호를 입력해 주세요.");
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
            throw new IllegalArgumentException("[ERROR] 기존에 중복되는 값이 있습니다.");
        }
    }
}
