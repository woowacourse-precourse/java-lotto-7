package lotto.parser;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
    public List<Integer> parseLottoNumber(String inputValue){
        List<Integer> lottoNumber = new ArrayList<>();

        for(String number: inputValue.split(",")){
            lottoNumber.add(Integer.parseInt(number));
        }

        return lottoNumber;
    }

    public int parsePrice(String inputValue){
        return Integer.parseInt(inputValue);
    }

    public int parseBonusNumber(String inputValue){
        return Integer.parseInt(inputValue);
    }
}
