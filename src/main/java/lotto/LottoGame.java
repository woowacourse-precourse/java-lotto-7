package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;

    public void start() {
        int purchaseAmount = getValidatePurchaseAmount();

        int lottoCount = calculateLottoCount(purchaseAmount);
        printLottoCount(lottoCount);

        List<List<Integer>> lottoNumbers = generateLottoNumbers(lottoCount);
        printLottoNumbers(lottoNumbers);

        List<Integer> winningNumbers = getValidateWinningNumbers();
        System.out.println("당첨 번호: " + winningNumbers);
    }

    private int getValidatePurchaseAmount() {
        while (true) {
            int amount = getInputAmount();
            if (amount != -1 && isValidAmount(amount)) {
                return amount;
            }
        }
    }

    private int getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
            return -1;
        }
    }

    private boolean isValidAmount(int amount) {
        if (amount <= 0 || amount % LOTTO_PRICE != 0) {
            System.out.println("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.");
            return false;
        }
        return true;
    }

    private int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

    private void printLottoCount(int count) {
        System.out.printf("%d개를 구매했습니다.%n", count);
    }

    private List<List<Integer>> generateLottoNumbers(int count) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_COUNT);
            Collections.sort(numbers);
            lottoNumbers.add(numbers);
        }
        return lottoNumbers;
    }

    private void printLottoNumbers(List<List<Integer>> lottoNumbers) {
        for (List<Integer> numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    private List<Integer> getValidateWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요. (쉼표로 구분된 6개의 숫자)");
                String input = Console.readLine().trim();
                List<Integer> winningNumbers = parseWinningNumbers(input);
                new Lotto(winningNumbers); // Lotto 객체 생성 시 유효성 검사 수행
                return winningNumbers;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private List<Integer> parseWinningNumbers(String input) {
        if (!input.contains(",")) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 쉼표(,)를 기준으로 구분합니다.");
        }


        String[] splitInput = input.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String numStr : splitInput) {
            try {
                int number = Integer.parseInt(numStr.trim());
                winningNumbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 입력에 유효하지 않은 문자가 포함되어 있습니다. 숫자만 입력해 주세요.");
            }
        }
        return winningNumbers;
    }
}

