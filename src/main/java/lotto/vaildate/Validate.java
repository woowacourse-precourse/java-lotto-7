package lotto.vaildate;

import java.util.List;

public class Validate {

    public static int purchasePriceValidate(String price) {
        int purchasePrice = parseIntegerValidate(price);

        if (purchasePrice % 1000 != 0 || purchasePrice < 0) {
            throw new IllegalArgumentException("[ERROR] 천원단위로 입력해주세요");
        }

        return purchasePrice / 1000;
    }

    public static int parseIntegerValidate(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자 형식으로만 입력해주세여");
        }
    }

    public static List<Integer> winningNumbersValidate(List<Integer> winningNumbers) {
        validateWinningNumberCount(winningNumbers);
        validateNumberInRange(winningNumbers);
        validateUniqueNumber(winningNumbers);
        return winningNumbers;
    }

    public static int parseIntegerBonusValidate(String value, List<Integer> winningNumbers) {
        int parsedValue = parseIntegerValidate(value);
        validateBonusNumber(parsedValue);
        bonusNumberDuplicateValidate(winningNumbers, parsedValue);
        return parsedValue;
    }

    private static void validateWinningNumberCount(List<Integer> validNumbers) {
        if (validNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    private static void validateUniqueNumber(List<Integer> winningNumbers) {
        if (winningNumbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 중복된 될수 없습니다.");
        }
    }

    private static void validateNumberInRange(List<Integer> winningNumbers) {
        if (numberIsRange(winningNumbers)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 1과 45 사이여야 합니다.");
        }
    }

    private static boolean numberIsRange(List<Integer> winningNumbers) {
        return winningNumbers.stream().anyMatch(Validate::isLottoRange);
    }

    private static boolean isLottoRange(Integer number) {
        return number < 0 || number > 45;
    }

    private static void validateBonusNumber(int number) {
        if (isLottoRange(number)) {
            throw new IllegalArgumentException("[ERROR] 올바른 보너스 번호를 입력해주세요.");
        }
    }

    private static void bonusNumberDuplicateValidate(List<Integer> winningNumbers, int bonusValidate) {
        if (winningNumbers.contains(bonusValidate)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }

}
