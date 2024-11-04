package util;

import lotto.Lotto;

import java.util.ArrayList;

public class LottoParsing {
    public Lotto pasingLottoNumberToModel(String lottoNumberStr){
        String[] lottoNumbers = lottoNumberStr.split(",");

        ArrayList<Integer> lotto = new ArrayList<>();
        for(String number: lottoNumbers){
            lotto.add(Integer.parseInt(number));
        }
        return new Lotto(lotto);
    }
}
