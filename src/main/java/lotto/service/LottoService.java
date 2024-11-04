package lotto.service;

import lotto.utils.Parsing;
import lotto.utils.Validator;

public class LottoService {
    Validator validator;
    Parsing parsing;
    public LottoService(Validator validator, Parsing parsing){
        this.validator = validator;
        this.parsing = parsing;
    }
    public int lottoQuantity(String purchaseInput){
        if(!validator.isPositiveInteger(purchaseInput)){
            throw new IllegalArgumentException("[ERROR] 양의 정수를 입력해주세요.");
        }

        int purchase = parsing.stringToInteger(purchaseInput);

        if(!validator.isDivisibleBy1000(purchase)){
            throw new IllegalArgumentException("[ERROR] 1,000원 단위로 입력해주세요.");
        }

        return purchase/1000;
    }
}
