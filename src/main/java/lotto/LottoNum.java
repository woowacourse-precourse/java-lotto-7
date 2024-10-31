package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNum {
    private List<Lotto> lottos = new ArrayList<>();

    public LottoNum(int money){
        checkMoney(money);
    }

    private void checkMoney(int money){
        if(money % 1000 != 0){
            throw new IllegalArgumentException("1000원으로 나누어 떨어지지 않습니다.");
        }
    }
}
