package view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {

    public int getLottoMoney(){
        return Integer.parseInt(Console.readLine());
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



}
