package lotto.validator;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public final class Validator {
    private final static String NEGATIVE_NUMBER_ERROR_MESSAGE = "[ERROR] 입력값이 0 미만입니다.";
    private final static String LOTTO_NUMBER_ERROR_MESSGAE = "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.";
    private final static String DUPLICATED_NUMBER_ERROR_MESSAGE = "[ERROR] 입력된 당첨 번호 중에서 중복되는 숫자가 있습니다.";
    private final static String NUMBERS_SIZE_ERROR_MESSAGE = "[ERROR] 로또 번호는 6개여야 합니다.";
    private final static String AMOUNT_IN_THOUSNADS_ERROR_MESSAGE = "[ERROR] 로또 구입 비용이 1,000원으로 나눠떨어지지 않습니다.";
    private final static String BONUS_IN_WINNINGS_ERROR_MESSAGE = "[ERROR] 보너스 번호가 이미 당첨 번호에 포함되고 있습니다.";

    private final static Integer LOTTO_PRICE = 1000;
    private final static Integer LOTTO_RANGE_START = 1;
    private final static Integer LOTTO_RANGE_END = 45;
    private final static Integer LOTTO_NUMBER_SIZE = 6;
    private final static Integer ZERO_NUMBER = 0;


    public static void validatePurchaseAmount(Integer purchaseAmount) throws IllegalArgumentException {
        validateNegative(purchaseAmount);
        validateAmountInThousands(purchaseAmount);
    }

    public static void validateWinningNumber(List<Integer> winnings) throws IllegalArgumentException {
        validateDupliacation(winnings);
        validateLottoNumberInList(winnings);
        validateNumbersSize(winnings);

        winnings.forEach(number -> validateNegative(number));
    }

    public static void validateBonusNumber(Integer bonus) throws IllegalArgumentException {
        validateNegative(bonus);
        validateLottoNumber(bonus);
    }

    public static void validateBonusNumberInWinningNumber(List<Integer> winnings, Integer number) throws IllegalArgumentException {
        List<Integer> winningsInBonus = winnings.stream()
                .filter(winning -> number.equals(winning))
                .collect(Collectors.toList());

        if(!winningsInBonus.isEmpty()) {
            System.out.println(BONUS_IN_WINNINGS_ERROR_MESSAGE);
            throw new IllegalArgumentException(BONUS_IN_WINNINGS_ERROR_MESSAGE);
        }
    }

    private static void validateNegative(Integer number) throws IllegalArgumentException {
        if(number<ZERO_NUMBER) {
            System.out.println(NEGATIVE_NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException(NEGATIVE_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateNumbersSize(List<Integer> winnings) throws IllegalArgumentException {
        if(winnings.size()!=LOTTO_NUMBER_SIZE) {
            System.out.println(NUMBERS_SIZE_ERROR_MESSAGE);
            throw new IllegalArgumentException(NUMBERS_SIZE_ERROR_MESSAGE);
        }
    }

    private static void validateAmountInThousands(Integer amount) throws IllegalArgumentException {
        if(amount % LOTTO_PRICE!=ZERO_NUMBER){
            System.out.println(AMOUNT_IN_THOUSNADS_ERROR_MESSAGE);
            throw new IllegalArgumentException(AMOUNT_IN_THOUSNADS_ERROR_MESSAGE);
        }
    }

    private static void validateDupliacation(List<Integer> winnings) throws IllegalArgumentException {
        Set<Integer> notDuplicatedNumbers = Set.copyOf(winnings);
        if(winnings.size() != notDuplicatedNumbers.size()){
            System.out.println(DUPLICATED_NUMBER_ERROR_MESSAGE);
            throw new IllegalArgumentException(DUPLICATED_NUMBER_ERROR_MESSAGE);
        }
    }

    private static void validateLottoNumberInList(List<Integer> winnings) throws IllegalArgumentException {
        winnings.forEach(
                number -> {
                    if(number < LOTTO_RANGE_START || number > LOTTO_RANGE_END){
                        System.out.println(LOTTO_NUMBER_ERROR_MESSGAE);
                        throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSGAE);
                    }
                });
    }

    private static void validateLottoNumber(Integer number) throws IllegalArgumentException {
        if(number < LOTTO_RANGE_START || number > LOTTO_RANGE_END){
            System.out.println(LOTTO_NUMBER_ERROR_MESSGAE);
            throw new IllegalArgumentException(LOTTO_NUMBER_ERROR_MESSGAE);
        }
    }



}
