package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {

    public List<Integer> generateLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int generateBonusNumber(List<Integer> numbers) {
        int bonus;
        do {
            bonus = Randoms.pickNumberInRange(1, 45);
        } while (numbers.contains(bonus));
        return bonus;
    }



}
