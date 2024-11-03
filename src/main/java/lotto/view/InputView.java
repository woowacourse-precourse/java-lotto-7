package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    private final Validate validate;

    public InputView(Validate validate) {
        this.validate = validate;
    }


    public int getMoneyInput(){
        System.out.println("구입 입력을 입력해주세요.");
       return validate.validateLottoMoney(getLottoMoney());
    }

    public List<Integer> getLottoInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return validate.validateLottoNumber(getLottoNumber());
    }

    public int getBonusInput(){
        System.out.println("보너스 번호 입력해 주세요.");
        return validate.validateBonusNumber(getBonusNumber());
    }

    public String getLottoMoney(){
        return Console.readLine();
    }

    public String getLottoNumber(){
        return Console.readLine();
    }

    public String getBonusNumber(){
        return Console.readLine();
    }




}
