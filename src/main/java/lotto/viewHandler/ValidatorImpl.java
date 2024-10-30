package lotto.viewHandler;

import lotto.viewHandler.validator.LottoNumberRangeValidator;
import lotto.viewHandler.validator.LottoNumberSplit;
import lotto.viewHandler.validator.LottoPurchaseUnitValidator;
import lotto.viewHandler.validator.ParseInt;

import java.util.List;

public class ValidatorImpl {
    private final ParseInt parseInt;
    private final LottoNumberRangeValidator lottoNumberRangeValidator;
    private final LottoPurchaseUnitValidator lottoPurchaseUnitValidator;
    private final LottoNumberSplit lottoNumberSplit;

    public ValidatorImpl(ParseInt parseInt,
                         LottoNumberRangeValidator lottoNumberRangeValidator,
                         LottoPurchaseUnitValidator lottoPurchaseUnitValidator,
                         LottoNumberSplit lottoNumberSplit) {
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