package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.TreeSet;

public class LottoService {
    public TreeSet<Integer> makeLottoNumber() {
        TreeSet<Integer> LottoNumbers = new TreeSet<>();
        List<Integer> LottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);

        for (int numbers : LottoNumber) {
            LottoNumbers.add(numbers);
        }

        return LottoNumbers;

    }




}
