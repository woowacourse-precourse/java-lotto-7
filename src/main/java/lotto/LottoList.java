package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoList {

    public static int lottoNumber(int inputMoney){
        int lottoNumber = inputMoney / 1000;

        return lottoNumber;
    }

    public static List<Lotto> drawingLotto(int lottoNumber){
        List<Lotto> lottoList = new ArrayList<>();

        for(int i = 0; i < lottoNumber; i++){
            List<Integer> tmpLottoList = Randoms.pickUniqueNumbersInRange(1, 45, 6);

            Collections.sort(tmpLottoList);
            lottoList.add(new Lotto(tmpLottoList));
        }

        return lottoList;
    }

}