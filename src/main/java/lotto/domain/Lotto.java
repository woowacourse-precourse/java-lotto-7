package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.dto.LottoWinResult;
import lotto.enums.LottoCriteria;
import lotto.enums.LottoErrorMessage;
import lotto.exception.LottoInputException;
import lotto.utility.NumberUtility;
import lotto.validator.LottoValidator;

public class Lotto {

    private final List<Integer> numbers;
    private static final String PRINT_NUMBERS_PREFIX = "[";
    private static final String PRINT_NUMBERS_POSTFIX = "]" + System.lineSeparator();

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if(NumberUtility.isDuplicateNumberExists(numbers)){
            throw new LottoInputException(LottoErrorMessage.DUPLICATE_NUMBERS);
        }
        if(!LottoValidator.isInRangeLottoNumbers(numbers)){
            throw new LottoInputException(LottoErrorMessage.INVALID_NUMBER);
        }
        if (numbers.size() != 6) {
            throw new LottoInputException(LottoErrorMessage.LOTTO_WINNING_INVALID_SIZE);
        }
    }

    public LottoWinResult getResult(List<Integer> winningNumbers, int bonusNumber) {
        int winCount = getWinningCount(winningNumbers);
        boolean isBonus = isBonus(bonusNumber);
        if(winCount == LottoCriteria.BONUS_LOTTO_NUM.getCriteriaVal() && isBonus){
            winCount = LottoCriteria.BONUS_CASE_LOTTO_NUM.getCriteriaVal();
        }
        return new LottoWinResult(winCount,isBonus,LottoCalculator.cal(winCount,isBonus));
    }

    private boolean isBonus(int bonusNumber) {
        return numbers.stream()
                .anyMatch((num) -> num == bonusNumber);
    }

    private int getWinningCount(List<Integer> winningNumbers) {
        int winCount = 0;
        for(Integer curNum : numbers){
            boolean isMatch = winningNumbers.stream()
                    .anyMatch((num) -> num == curNum);
            if(isMatch){
                winCount++;
            }
        }
        return winCount;
    }

    public String getLottoNumberStr(){
        String numbersStr=  numbers.stream()
                .map((number) -> number + "")
                .collect(Collectors.joining(", "));
        return PRINT_NUMBERS_PREFIX + numbersStr + PRINT_NUMBERS_POSTFIX;
    }
}
