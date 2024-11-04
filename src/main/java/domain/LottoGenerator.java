package domain;

import static java.util.Collections.sort;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    //로또 번호 발행
    public List<Integer> generate() {
        List<Integer> lottoNumbers;
        lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        //Randoms.pickUniqueNumbersInRange -> 불변 객체여서 새로운 리스트에 넣어 sort해줌
        List<Integer> sortedLottoNumbers = new ArrayList<>(lottoNumbers);
        sort(sortedLottoNumbers);
        return sortedLottoNumbers;
    }
}
