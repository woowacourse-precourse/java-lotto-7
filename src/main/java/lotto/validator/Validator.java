package lotto.validator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class Validator {
    private static final String ERROR_INVALID_NUMERIC = "[ERROR] 로또 번호는 숫자 형식이어야 합니다.";
    private static final String ERROR_INVALID_AMOUNT_UNIT = "[ERROR] 금액은 1,000원 단위입니다.";
    private static final String ERROR_INVALID_NUMBER_RANGE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private static final String ERROR_INVALID_LOTTO_NUMBER_COUNT = "[ERROR] 로또 번호는 6개의 숫자여야 합니다.";
    private static final String ERROR_INVALID_LOTTO_NUMBER_DUPLICATE = "[ERROR] 로또 번호는 중복되면 안 됩니다.";
    private static final String ERROR_INVALID_LOTTO_FORMAT = "[ERROR] 숫자와 콤마만 입력 가능합니다.";
    private static final String ERROR_INVALID_BONUS_DUPLICATE = "[ERROR] 보너스 번호가 당첨번호와 중복됩니다.";

    public static int validateLottoAmount(String inputAmount) {
        int amount = validateNumeric(inputAmount);
        validateAmountUnit(amount);
        return amount;
    }

    public static List<Integer> validateWinningLotto(String inputWinningLotto) {
        List<Integer> winningLotto = new ArrayList<>();
        validateInputWinningLottoFormat(inputWinningLotto);
        List<String> numbers = List.of(inputWinningLotto.split(","));
        for (String number : numbers) {
            int winningLottoNumber = validateNumeric(number);
            validateLottoNumberRange(winningLottoNumber);
            winningLotto.add(winningLottoNumber);
        }
        validateNumberCount(winningLotto);
        validateLottoDuplicate(winningLotto);
        return winningLotto;
    }

    public static int validateBonusNumber(String inputBonus) {
        int bonus = validateNumeric(inputBonus);
        validateLottoNumberRange(bonus);
        return bonus;
    }

    public static int validateNumeric(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMERIC);
        }
    }

    public static void validateAmountUnit(int input) {
        if (input % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_INVALID_AMOUNT_UNIT);
        }
    }

    public static void validateLottoNumberRange(int input) {
        if (input < 1 || input > 45) {
            throw new IllegalArgumentException(ERROR_INVALID_NUMBER_RANGE);
        }
    }

    public static void validateNumberCount(List<Integer> winningLotto) {
        if (winningLotto.size() != 6) {
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER_COUNT);
        }
    }

    public static void validateLottoDuplicate(List<Integer> winningLotto) {
        Set<Integer> checkDuplicate = new HashSet<>(winningLotto);
        if(checkDuplicate.size()!= winningLotto.size()){
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_NUMBER_DUPLICATE);
        }
    }

    public static void validateInputWinningLottoFormat(String input){
        String regex = "[^0-9,]";
        if(Pattern.compile(regex).matcher(input).find()){
            throw new IllegalArgumentException(ERROR_INVALID_LOTTO_FORMAT);
        }
    }

    public static void validateBonusDuplicate(List<Integer> winningLotto, int bonusNumber){
        if(winningLotto.contains(bonusNumber)){
            throw new IllegalArgumentException(ERROR_INVALID_BONUS_DUPLICATE);
        }
    }
}
