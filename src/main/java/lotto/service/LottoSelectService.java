package lotto.service;

import lotto.vo.Lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoSelectService {

    public Lotto getLottoSelect(String val){
        String[] values = val.split(",");
        if(values.length != 6){
            throw new IllegalArgumentException("[ERROR] 당첨번호를 잘못 입력하셨습니다.확인 후 다시 입력해주세요.");
        }
        List<Integer> result = new ArrayList<Integer>();
        for (var i = 0; i < values.length; i++) {
            result.add(Integer.parseInt(values[i]));
        }
        Lotto lotto = new Lotto(result);
        return lotto;
    }



}
