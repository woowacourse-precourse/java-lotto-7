package lotto;

import static java.util.Arrays.*;

import camp.nextstep.edu.missionutils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final int PURCHASE_UNIT = 1000;

    public static void main(String[] args) {
        int purchaseAmount = getValidPurchaseAmount();

        List<Lotto> lottoTickets = createLottoTickets(purchaseAmount);
        printLottoTickets(lottoTickets);

        List<Integer> winningNumbers = getValidWinningNumbers();
        int bonusNumber = getValidBonusNumber(winningNumbers);
    }

    public static void validateInput(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 비어 있습니다. 다시 입력해 주세요.");
        }

        if (input.contains(" ")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력에 공백이 포함되어 있습니다. 다시 입력해 주세요.");
        }
    }

    public static int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입 금액을 입력해주세요.");
                String input = Console.readLine();

                validateInput(input);
                int purchaseCost = validatePurchaseCostInput(input);
                validatePurchaseCost(purchaseCost);

                return purchaseCost / PURCHASE_UNIT; // 입력이 유효하면 변환 후 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 에러 메시지 출력 후 루프 반복하여 재입력 요청
            }
        }
    }

    public static int validatePurchaseCostInput(String input) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 숫자가 아닙니다. 다시 입력해 주세요.");
        }

        return Integer.parseInt(input);
    }

    public static void validatePurchaseCost(int purchaseCost) {
        if (purchaseCost < PURCHASE_UNIT) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 최소 1000원 이상이어야 합니다.");
        }

        if (purchaseCost % PURCHASE_UNIT != 0) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 로또 구입 금액은 1000원 단위로 입력해야 합니다.");
        }
    }

    public static List<Lotto> createLottoTickets(int purchaseAmount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoTickets.add(new Lotto(numbers));
            Collections.sort(numbers); // 오름차순 정렬
        }
        return lottoTickets;
    }

    public static void printLottoTickets(List<Lotto> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Integer> getValidWinningNumbers() {
        while (true) {
            try {
                System.out.println("당첨 번호를 입력해 주세요.");
                String input = Console.readLine();

                validateInput(input);
                return validateWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static List<Integer> validateWinningNumbers(String input) {
        if (!input.matches("^([0-9]{1,2},){5}[0-9]{1,2}$")) { // 1~2자리 숫자로 시작, 쉼표로 구분된 5개의 숫자, 마지막엔 쉼표 없는 숫자
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호는 쉼표로 구분된 6개의 숫자여야 합니다.");
        }

        List<Integer> numbers = stream(input.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        if (numbers.stream().anyMatch(n -> n < 1 || n > 45)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 당첨 번호는 1에서 45 사이의 숫자여야 합니다.");
        }

        if (numbers.size() != 6 || numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 중복되지 않는 6개의 숫자를 입력해 주세요.");
        }

        return numbers;
    }

    public static int getValidBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            try {
                System.out.println("보너스 번호를 입력해 주세요.");
                String input = Console.readLine();

                validateInput(input);
                return validateBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static int validateBonusNumber(String input, List<Integer> winningNumbers) {
        if (!input.matches("[0-9]+")) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 입력값이 숫자가 아닙니다. 다시 입력해 주세요.");
        }

        int bonusNumber = Integer.parseInt(input);

        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 1에서 45 사이의 숫자여야 합니다.");
        }

        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ERROR_MESSAGE + " 보너스 번호는 당첨 번호와 중복되면 안됩니다.");
        }

        return bonusNumber;
    }
}
