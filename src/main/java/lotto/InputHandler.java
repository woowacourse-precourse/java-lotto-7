package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.LottoConstants.LOTTO_PRICE;
import static lotto.LottoConstants.MAX_RANDOM_NUMBER;
import static lotto.LottoConstants.MIN_RANDOM_NUMBER;
import static lotto.LottoConstants.NUMBER_COUNT;

import java.util.ArrayList;
import java.util.List;

public class InputHandler {
    public static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = readLine();
        try {
            int amount = Integer.parseInt(input);
            validatePurchaseAmount(amount);
            System.out.println();
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("[ERROR] 0 이상의 값을 입력해야 합니다.");
        }
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] " + LOTTO_PRICE + "원으로 나누어 떨어지는 값을 입력해야 합니다.");
        }
    }


    public static WinningNumbers getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = readLine();
        List<Integer> winningNumbers = parseWinningNumbers(input);

        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = readLine();
        int bonusNumber = parseNumber(bonusInput);

        return new WinningNumbers(winningNumbers, bonusNumber);
    }

    private static List<Integer> parseWinningNumbers(String input) {
        String[] tokens = input.split(",");
        if (tokens.length != NUMBER_COUNT) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 " + NUMBER_COUNT + "개의 숫자여야 합니다.");
        }
        List<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            numbers.add(parseNumber(token.trim()));
        }
        return numbers;
    }

    private static int parseNumber(String token) {
        int number;
        try {
            number = Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        
        if (number < MIN_RANDOM_NUMBER || number > MAX_RANDOM_NUMBER) {
            throw new IllegalArgumentException(
                    "[ERROR] " + MIN_RANDOM_NUMBER + "~" + MAX_RANDOM_NUMBER + "사이의 숫자만 입력해야 합니다.");
        }

        return number;
    }
}