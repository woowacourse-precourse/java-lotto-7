package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Input {
    private static final Pattern isWinningNumberPattern = Pattern.compile("^(0?[1-9]|[1-3][0-9]|4[0-5])(,(0?[1-9]|[1-3][0-9]|4[0-5])){5}$");

    public static String inputPrice() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String price = Console.readLine();
            try {
                validatePrice(price);
                return price;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputWinningNumber() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumber = Console.readLine();
            try {
                validateWinningNumber(winningNumber);
                return winningNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static String inputBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();
            try {
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void validatePrice(String input) throws IllegalArgumentException {
        validateInputNumeric(input);
        Integer price = Integer.parseInt(input);
        validatePriceDivisible(price);
    }

    private static void validateWinningNumber(String input) throws IllegalArgumentException {
        isWinningNumberFormat(input);
    }

    private static void validateBonusNumber(String input) throws IllegalArgumentException {
        validateInputNumeric(input);
        Integer bonusNumber = Integer.parseInt(input);
        validateBonusNumberInRange(bonusNumber);
    }

    private static void validateInputNumeric(String price) {
        try {
            Integer.parseInt(price);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 금액은 자연수여야 합니다.");
        }
    }

    private static void validatePriceDivisible(Integer price) {
        if (price % 1000 != 0) {
            throw new NumberFormatException("[ERROR] 금액은 1000원 단위로만 가능합니다.");
        }
    }

    private static void isWinningNumberFormat(String input) {
        if (!isWinningNumberPattern.matcher(input).matches()) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 올바른 형식이여야 합니다.(6개의 1-45 사이의 자연수를 겹치지 않게 , 기준으로 입력)");
        }
    }

    private static void validateBonusNumberInRange(Integer bonusNumber) {
        if (!(bonusNumber > 0 && bonusNumber < 46)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이에 하나의 숫자여야 합니다.");
        }
    }

}
