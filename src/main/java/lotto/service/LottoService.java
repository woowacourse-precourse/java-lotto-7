package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoService {

    public List<List<Integer>> generateLottoNumbers(int purchaseAmount) {
        List<List<Integer>> generatedLottoNumbers = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> generatedLottoNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(generatedLottoNumber);
            generatedLottoNumbers.add(generatedLottoNumber);
        }
        return generatedLottoNumbers;
    }
}
