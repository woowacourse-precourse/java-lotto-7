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
        for (String token : tokens) {
            int number = Integer.parseInt(token);
            lottoNum.add(number);
        }
        Collections.sort(lottoNum);
        return lottoNum;
    }
}
