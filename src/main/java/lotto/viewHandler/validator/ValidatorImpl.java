package lotto.viewHandler.validator;

import lotto.viewHandler.validator.validatorImpl.LottoNumberRangeValidator;
import lotto.viewHandler.validator.validatorImpl.LottoNumberSplit;
import lotto.viewHandler.validator.validatorImpl.LottoPurchaseUnitValidator;
import lotto.viewHandler.validator.validatorImpl.ParseInt;
import lotto.viewHandler.validator.validatorImpl.RemoveWhiteSpace;

import java.util.List;

public class ValidatorImpl {
    private final RemoveWhiteSpace removeWhiteSpace;
    private final ParseInt parseInt;
    private final LottoNumberRangeValidator lottoNumberRangeValidator;
    private final LottoPurchaseUnitValidator lottoPurchaseUnitValidator;
    private final LottoNumberSplit lottoNumberSplit;

    public ValidatorImpl(RemoveWhiteSpace removeWhiteSpace, ParseInt parseInt,
                         LottoNumberRangeValidator lottoNumberRangeValidator,
                         LottoPurchaseUnitValidator lottoPurchaseUnitValidator,
                         LottoNumberSplit lottoNumberSplit) {
        this.removeWhiteSpace = removeWhiteSpace;
        this.parseInt = parseInt;
        this.lottoNumberRangeValidator = lottoNumberRangeValidator;
        this.lottoPurchaseUnitValidator = lottoPurchaseUnitValidator;
        this.lottoNumberSplit = lottoNumberSplit;
    }

    public Integer validateMoney(String input) {
        Integer money = parseInt.validate(input);
        lottoPurchaseUnitValidator.validate(money);
        return money;
    }

    public List<Integer> validateLottoNumbers(String input) {
        return lottoNumberSplit.validate(input).stream()
                .map(number -> {
                    number = removeWhiteSpace.validate(number);
                    Integer lottoNumber = parseInt.validate(number);
                    lottoNumberRangeValidator.validate(lottoNumber);
                    return lottoNumber;
                })
                .toList();
    }

    public Integer validBonusLottoNumber(String input) {
        Integer number = parseInt.validate(input);
        lottoNumberRangeValidator.validate(number);
        return number;
    }
}