package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumber {

    public LottoNumber(){
    }

    public static List<Integer> winLottoNumber(String number_str) {
        List<Integer> lottoNum = new ArrayList<>();
        String[] tokens = number_str.trim().split(",");
        try{
            for (String token : tokens) {
                int number = Integer.parseInt(token);
                lottoNum.add(number);
            }
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException("");//입력값이 문자일때,비었을때
        }
        Collections.sort(lottoNum);
        return lottoNum;
    }
}
