package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public List<Lotto> generatingNumbers(int numberOfTickets) {
        List<Lotto> LottoNumbers = new ArrayList<>();
        for (int ticket = 0; ticket < numberOfTickets; ticket++) {
            List<Integer> numbersGenerated = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> mutableNumbers = new ArrayList<>(numbersGenerated);
            Collections.sort(mutableNumbers);
            LottoNumbers.add(new Lotto(mutableNumbers));
        }
        return LottoNumbers;
    }
}