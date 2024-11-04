package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LottoModel {
    public Lotto getLottoNumber(){
        // 로또 번호 랜덤 생성 및 저장
        List<Integer> numbers = new LinkedList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        Lotto lotto = new Lotto(numbers);

        return lotto;
    }
}
