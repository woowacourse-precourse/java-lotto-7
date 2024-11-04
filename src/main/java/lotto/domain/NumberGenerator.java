package lotto.domain;

import static lotto.constants.NumberConstants.LOTTO_END_NUMBER;
import static lotto.constants.NumberConstants.LOTTO_NUMBERS_SIZE;
import static lotto.constants.NumberConstants.LOTTO_START_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberGenerator {

    public List<Lotto> generatingNumbers(int numberOfTickets) {
        List<Lotto> LottoNumbers = new ArrayList<>();
        for (int ticket = 0; ticket < numberOfTickets; ticket++) {
            List<Integer> numbersGenerated = Randoms.pickUniqueNumbersInRange(LOTTO_START_NUMBER, LOTTO_END_NUMBER,
                    LOTTO_NUMBERS_SIZE);
            List<Integer> mutableNumbers = new ArrayList<>(numbersGenerated);
            Collections.sort(mutableNumbers);
            LottoNumbers.add(new Lotto(mutableNumbers));
        }
        return LottoNumbers;
    }
}