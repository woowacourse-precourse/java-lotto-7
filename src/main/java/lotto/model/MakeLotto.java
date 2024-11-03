package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class MakeLotto {

    public int splitAmount(int amount){
        validate(amount);
        return amount / 1000;
    }
    private void validate(int amount){
        if (amount % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위입니다.");
        }
    }
    public List<Lotto> makeLottoList(int quantity){
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < quantity; i++){
            List<Integer> lotto = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoList.add(new Lotto(lotto));
        }
        return lottoList;
    }

}