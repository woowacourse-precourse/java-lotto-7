package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    private static final String ASK_PurchaseAmount="구입금액을 입력해 주세요.";
    private static final String ASK_WinningNumber="당첨 번호를 입력해 주세요.";
    private static final String ASK_BounsNumber="보너스 번호를 입력해 주세요.";
    private static final String ERROR_PurchaseAmount="[ERROR] 구입 금액은 양수인 1000원 단위로 입력해주세요.";
    private static final String ERROR_RangeValidWinningNumber="[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_CommaValidWinningNumber="[ERROR] 당첨 번호는 쉼표로 구분되어야 합니다.";
    private static final String ERROR_OverlapValidWinningNumber="[ERROR] 당첨 번호는 중복된 숫자일 수 없습니다.";
    private static final String ERROR_RangeValidBounsNumber="[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.";


    public static int input_purchaseAmount() {
        while (true) {
            System.out.println(ASK_PurchaseAmount);
            String input_purchase_amount = readLine();
            try {
                return validatePurchaseAmount(input_purchase_amount);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static Lotto input_winningNumber() {
        while (true) {
            System.out.println(ASK_WinningNumber);
            String input_winning_number = readLine();
            try {
                return validateWinningNumber(input_winning_number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    public static int input_bounsNumber() {
        while (true) {
            System.out.println(ASK_BounsNumber);
            String input_bouns_number = readLine();
            try {
                return validateBounsNumber(input_bouns_number);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    private static int validatePurchaseAmount(String purchase_amount) {
        if (!check_invalidAmount(purchase_amount)) {
            throw new IllegalArgumentException(ERROR_PurchaseAmount);
        }
        return Integer.parseInt(purchase_amount);
    }

    private static Lotto validateWinningNumber(String input_winning_number) {
        if (!isRangeValidWinningNumber(input_winning_number)) {
            throw new IllegalArgumentException(ERROR_RangeValidWinningNumber);
        }
        if (!isCommaWinngingnumber(input_winning_number)) {
            throw new IllegalArgumentException(ERROR_CommaValidWinningNumber);
        }
        if (!isOverlapWinningnumber(input_winning_number)) {
            throw new IllegalArgumentException(ERROR_OverlapValidWinningNumber);
        }
        return parseWinningNumbers(input_winning_number);
    }

    private static int validateBounsNumber(String input_bouns_number) {
        if (!isRangeBounsNumber(input_bouns_number)) {
            throw new IllegalArgumentException(ERROR_RangeValidBounsNumber);
        }
        return parseBounsNumber(input_bouns_number);
    }

    private static boolean isRangeBounsNumber(String input_bouns_number) {
        int bounsNumber = parseBounsNumber(input_bouns_number);
        return bounsNumber >= 1 && bounsNumber <= 45;
    }

    private static boolean isRangeValidWinningNumber(String input_winning_number) {
        String[] winning_numbers = input_winning_number.split(",");
        for (String number : winning_numbers) {
            int valid_number = Integer.parseInt(number.trim());
            if (valid_number < 1 || valid_number > 45) return false;
        }
        return true;
    }

    private static boolean isOverlapWinningnumber(String input_winning_number) {
        Set<Integer> winning_number_set = new HashSet<>();
        String[] winning_numbers = input_winning_number.split(",");
        for (String number : winning_numbers) {
            int valid_number = Integer.parseInt(number.trim());
            if (!winning_number_set.add(valid_number)) return false;
        }
        return true;
    }

    private static boolean isCommaWinngingnumber(String input_winning_number) {
        return input_winning_number.contains(",");
    }

    private static Lotto parseWinningNumbers(String input_winning_number) {
        List<Integer> numbers = Arrays.stream(input_winning_number.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
        return new Lotto(numbers);
    }

    private static int parseBounsNumber(String input_bouns_number) {
        return Integer.parseInt(input_bouns_number);
    }

    private static boolean check_invalidAmount(String purchase_amount) {
        return (purchase_amount.matches("^[0-9]+$") && Integer.parseInt(purchase_amount) % 1000 == 0 && Integer.parseInt(purchase_amount) > 0);
    }
}
