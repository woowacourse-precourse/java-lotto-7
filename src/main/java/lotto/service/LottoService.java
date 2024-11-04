package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.GenerateLottos;
import lotto.utils.Parsing;
import lotto.utils.Validator;

import java.util.List;

public class LottoService {
    Validator validator;
    Parsing parsing;
    GenerateLottos generateLottos;

    public LottoService(Validator validator, Parsing parsing, GenerateLottos generateLottos){
        this.validator = validator;
        this.parsing = parsing;
        this.generateLottos = generateLottos;
    }


    //로또 발행 수량
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

    //수량만큼 로또 발행
    public List<Lotto> issueLottos(int lottoQuantity){
        for(int i=0; i<lottoQuantity; i++){
            generateLottos.addLotto(generateLottos.generateLotto());
        }
        return generateLottos.getLottos();
    }
}
