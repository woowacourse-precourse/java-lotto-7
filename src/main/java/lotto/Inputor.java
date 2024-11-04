package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;

public class Inputor {
    private static final int LOTTO_PRICE = 1000;
    public static final int INCORRECT_RESULT = -1;

    public static int getLottoDrawCount() {

        int lottoDrawCount;
        System.out.println("구입 금액을 입력해 주세요");

        do {
            lottoDrawCount = getLottoDrawCount(readLine());
        } while (lottoDrawCount == INCORRECT_RESULT);

        return lottoDrawCount;
    }
    public static List<Integer> getDrawnNumbers() {

        System.out.println("당첨 번호를 입력해 주세요.");

        List<Integer> drawnNumbers;

        do {
            drawnNumbers = getDrawnNumber(readLine().split(","));
        } while (drawnNumbers == null || drawnNumbers.isEmpty());

        return drawnNumbers;
    }
    public static Integer getBounsNumbers() {
        System.out.println("보너스 번호를 입력해 주세요.");

        Integer bonusNumber;

        do {
            bonusNumber = getBonusNumber();
        } while (bonusNumber == INCORRECT_RESULT);

        return bonusNumber;
    }

    private static Integer getBonusNumber() {
        try {
            return parseBonusNumber(readLine());
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return INCORRECT_RESULT;
        }
    }

    private static Integer parseBonusNumber(String input) throws IllegalArgumentException {
        try {
            Integer bonusNumber = Integer.valueOf(input);
            validateLottoNumber(bonusNumber);
            return bonusNumber;
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 정수를 입력 해야 합니다.");
        }
    }


    private static List<Integer> getDrawnNumber(String[] input) {
        try {
            return extractDrawnNumber(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
            return null;
        }
    }

    private static List<Integer> extractDrawnNumber(String[] input) throws IllegalArgumentException{
        try {
            if (input.length == 6) {
                return Arrays.stream(input)
                        .map(value -> validateLottoNumber(Integer.parseInt(value)))
                        .toList();
            }
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6자리를 입력 해야 합니다.");
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 숫자만 입력 해야 합니다.");
        }
    }

    private static int validateLottoNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException("[ERROR] 번호는 1과 45 사이의 숫자를 입력 해야 합니다." );
        }

        return number;
    }

    private static int getLottoDrawCount(String input) {
        int lottoDrawCount = INCORRECT_RESULT;

        try {
            int money = validateInput(input);
            lottoDrawCount = money / LOTTO_PRICE;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }

        return lottoDrawCount;
    }

    private static int validateInput(String input) {
        int money = parseMoney(input);
        validateMoney(money);
        return money;
    }

    private static int parseMoney(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 정수로 입력해 주세요.");
        }
    }

    private static void validateMoney(int money) throws IllegalArgumentException {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000 단위로 입력해 주세요.");
        }

        if (money < 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 음수일 수 없습니다.");
        }
    }

}
