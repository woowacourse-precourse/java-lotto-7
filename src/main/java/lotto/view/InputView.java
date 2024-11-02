package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public void getMoneyInput(){
        System.out.println("구입 입력을 입력해주세요.");
        getLottoMoney();
    }

    public void getLottoInput(){
        System.out.println("당첨 번호를 입력해 주세요.");
        getLottoNumber();
    }

    public void getBonusInput(){
        System.out.printf("보너스 번호 입력해 주세요.");
        getBonusNumber();
    }

    public String getLottoMoney(){
        return Console.readLine();
    }

    public String getLottoNumber(){
        return Console.readLine();
    }

    public List<Integer> getLottoNumber(String number){

        List<Integer> lottoNumbers = Arrays.stream(number.split(","))
                                        .map(Integer::parseInt)
                                        .toList();

        return lottoNumbers;
    }

    public String getBonusNumber(){
        return Console.readLine();
    }




}
