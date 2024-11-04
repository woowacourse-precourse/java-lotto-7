package lotto.validation;

import lotto.constant.LottoConstant;
import lotto.exception.LottoException;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberValidator extends LottoValidator{

    // 당첨 번호
    public static List<Integer> validateLottoNumbers(String input){
        isEmpty(input);
        List<Integer> list = getNumberList(input);
        checkDuplicateNumber(list);
        validateNumbersRange(list);
        validateMaximumNumbersCount(input);
        return list;
    }
    // 구분자가 쉼표 아닐 경우

    // 입력한 숫자가 중복될 경우
    public  static void checkDuplicateNumber(List<Integer> list){
        Set<Integer> set = new HashSet<>(list);
       if(!(set.size()==list.size())){
           throw new IllegalArgumentException(LottoException.DUPLICATED_NUMBERS.getMessage());
       }
    }

    // 입력한 숫자의 개수가 6개가 아닐 경우
    private  static void validateMaximumNumbersCount(String input){
        if(getNumberList(input).size()!=LottoConstant.LOTTO_NUMBER_COUNT){
            throw new IllegalArgumentException(LottoException.INVALID_NUMBER_COUNT.getMessage());
        }
    }

    private  static List<Integer> getNumberList(String input){
        List<Integer> numbersList = Arrays.stream(input.split(","))
                .map(Integer::parseInt) // 문자열을 Integer로 변환
                .collect(Collectors.toList()); // 리스트로 수집
        return numbersList;
    }

    // 1~45 사이의 숫자가 아닌 걸 입력했을 경우
    private  static void validateNumbersRange(List<Integer> list){
        for(Integer number:list){
            validateNumberRange(number);
        }
    }

    private  static void validateNumberRange(int number){
        if(!(number>=LottoConstant.LOTTO_MIN_NUMBER && number<=LottoConstant.LOTTO_MAX_NUMBER)){
            throw new IllegalArgumentException(LottoException.INVALID_NUMBER.getMessage());
        }
    }

    // 보너스 번호
    public  static Integer validateBonusNumber(List<Integer> list, int bonusNumber){
        validateNumberRange(bonusNumber);
        checkDuplicateBonusNumber(list, bonusNumber);
        return bonusNumber;
    }

    private  static void checkDuplicateBonusNumber(List<Integer> list, int bonus){
        for(Integer number:list){
            if(number==bonus){
                throw new IllegalArgumentException(LottoException.DUPLICATE_BONUS_NUMBER.getMessage());
            }
        }
    }
}
