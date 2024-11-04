package lotto.Service;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.InputValidator;

public class LottoService {
    private final InputValidator validator;

    public LottoService(InputValidator validator){
        this.validator = validator;
    }

    public int inputPurchaseAmount(){
        while(true){
            try{
                System.out.println("구입금액을 입력해 주세요.");
                String input = Console.readLine();
                return validator.validatePurchaseAmount(input);
            } catch(IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
