package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputView {

    public String getLottoMoney(){
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
