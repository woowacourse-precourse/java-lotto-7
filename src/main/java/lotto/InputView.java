package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {
    private final int PURCHASE_AMOUNT = LottoGameInformation.PURCHASE_PRICE.getValue();

    public int inputPurchaseAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                return validateAndParseMoney(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public LottoPrize inputLottoPrize() {
        while (true) {
            try {
                System.out.println("\n당첨 번호를 입력해 주세요.");
                String inputPrizeNumbers = Console.readLine();
                List<Integer> prizeNumbers = validateAndParseLottoNumbers(inputPrizeNumbers);

                System.out.println("\n보너스 번호를 입력해 주세요.");
                String inputBonusNumber = Console.readLine();
                int bonusNumber = validateAndParseNumber(inputBonusNumber);

                return new LottoPrize(prizeNumbers, bonusNumber);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int validateAndParseMoney(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 공백으로 입력되었습니다.");
        }

        int money = 0;

        try {
            money = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자여야 합니다.");
        }

        if (money < PURCHASE_AMOUNT) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + PURCHASE_AMOUNT + "원 이상이어야 합니다.");
        }
        if (money % PURCHASE_AMOUNT != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 " + PURCHASE_AMOUNT + " 단위로 입력해야 합니다.");
        }
        return money;
    }

    public List<Integer> validateAndParseLottoNumbers(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim)
                    .map(this::validateAndParseNumber)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private int validateAndParseNumber(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 공백으로 입력되었습니다.");
        }

        int number = 0;
        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 숫자여야 합니다.");
        }
        return number;
    }
}
