package lotto.validator;

import lotto.utils.Utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Validator {

    public static void validateLottoAmountIsPositiveAndDivisibleByThousand(int lottoAmount){

        if (lottoAmount <= 0 || lottoAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로 입력해 주세요.");
        }

    }

    public static void validateAllWinningNumbers(List<Integer> lottoWinningNumbers) {
        validateLottoWinningNumbersCount(lottoWinningNumbers);
        validateDuplicateWinningNumbers(lottoWinningNumbers);
        validateLottoNumberInRangeOneToFortyFive(lottoWinningNumbers);
    }

    public static void validateLottoNumberInRangeOneToFortyFive(List<Integer> lottoWinningNumbers){

        if (!lottoWinningNumbers.stream().allMatch(number -> number >= 1 && number <= 45)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 1~45 사이로 입력해 주세요.");
        }
    }

    public static void validateLottoWinningNumbersCount(List<Integer> lottoWinningNumbers){

        if(lottoWinningNumbers.size() != 6){
            throw new IllegalArgumentException("[ERROR] 당첨 번호를 6개 입력해 주세요.");
        }
    }

    public static void validateDuplicateWinningNumbers(List<Integer> lottoWinningNumbers){

        Set<Integer> duplicateCheck = new HashSet<>();

        for (Integer number : lottoWinningNumbers) {
            if (!duplicateCheck.add(number)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력했습니다.");
            }
        }
    }

    public static List<Integer> validateWinningNumberSeparatorAndNotNumber(String lottoWinningNumbers){

        try{
            if(!lottoWinningNumbers.contains(",")){
                throw new IllegalArgumentException("[ERROR] 쉼표를 이용해서 번호를 구분해 주세요.");
            }

            return Utils.splitWinningNumber(lottoWinningNumbers);

        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }

    public static Integer validateSingleBonusNumber(String bonusNumber){

        try{
            return Integer.parseInt(bonusNumber);

        }catch(NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 숫자를 하나만 입력해 주세요.");
        }
    }

    public static int validateIsNumeric(String lottoPrice) {
        try {
            return Integer.parseInt(lottoPrice);

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해 주세요.");
        }
    }
}
