package lotto;

import lotto.exception.lottoNumber.*;
import lotto.exception.lottoPrice.InvalidThousandUnitException;
import lotto.exception.lottoPrice.MinimumPriceException;
import lotto.exception.lottoPrice.NullPriceException;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Validator {
    private static final String DELIMITER = ",";
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final int MIN_PRICE = 1000;
    private static final int DIVISOR = 1000;
    public void isValidPrice(String input){
        if(input.isEmpty()){
            throw new NullPriceException();
        }
        try{
            int price = Integer.parseInt(input);
            checkMinimumPrice(price);
            checkIsDivisibleByThousand(price);
        } catch (NumberFormatException e){
            System.out.println("[ERROR] "+ e.getMessage());
        }
    }

    public void isValidLottoNumbers(String input){
        if(input.isEmpty()){
            throw new NullLottoNumberException();
        }
        checkIsExistsDelimiter(input);
        List<String> lottoNumbers = Arrays.stream(input.split(DELIMITER))
                .map(String::trim)
                .collect(Collectors.toList());
        checkIsAllNumbers(lottoNumbers);
        checkValidRange(lottoNumbers);
        checkLottoCount(lottoNumbers);
        checkIsDistinct(lottoNumbers);
    }

    private void checkIsDistinct(List<String> lottoNumbers) {
        if (lottoNumbers.size() != lottoNumbers.stream().distinct().count()) {
            throw new DuplicatedNumberException();
        }
    }

    private void checkLottoCount(List<String> lottoNumbers) {
        if(lottoNumbers.size()!=LOTTO_COUNT){
            throw new InvalidLottoCountException();
        }
    }

    private void checkValidRange(List<String> lottoNumbers) {
        for(String currentNumber : lottoNumbers){
            int number = Integer.parseInt(currentNumber);
            if(number < MIN_NUMBER || number > MAX_NUMBER){
                throw new OutOfRangeNumberException();
            }
        }
    }

    private void checkIsAllNumbers(List<String> lottoNumbers) {
        for(String currentNumber : lottoNumbers){
            try{
                Integer.parseInt(currentNumber);
            } catch (NumberFormatException e){
                throw new InvalidNumberException();
            }
        }
    }

    private void checkIsExistsDelimiter(String input) {
        if(!input.contains(DELIMITER)){
            throw new NotFoundDelimiterException();
        }
    }

    private void checkIsDivisibleByThousand(int price) {
        if(price % DIVISOR !=0){
            throw new InvalidThousandUnitException();
        }
    }

    private void checkMinimumPrice(int price) {
        if(price < MIN_PRICE){
            throw new MinimumPriceException();
        }
    }

}
