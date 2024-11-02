package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    private static final String NUMERIC_REGEX = "^[0-9]+$";

    public String getLottoMoney(){
        return Console.readLine();
    }

    public List<Integer> getLottoNumber(String number){

        List<Integer> lottoNumbers = Arrays.stream(number.split(","))
                                        .map(Integer::parseInt)
                                        .toList(); // 리스트에 담기

        return lottoNumbers;
    }

    public int getBonusNumber(){
        return Integer.parseInt(Console.readLine());
    }

    public int validateLottoMoney(String lottoMoney){
        if(!lottoMoney.matches(NUMERIC_REGEX)){
            throw new IllegalArgumentException("[ERROR] 로또 금액은 숫자만 입력할 수 있습니다.");
        }

        if(Integer.parseInt(lottoMoney) < 0){
            throw new IllegalArgumentException("[ERROR] 로또 금액은 양수만 입력할 수 있습니다.");
        }

        if(Integer.parseInt(lottoMoney) % 1000!=0){
            throw new IllegalArgumentException("[ERROR] 로또 금액은 1000원 단위로만 입력할 수 있습니다.");
        }

        return Integer.parseInt(lottoMoney);
    }




}
