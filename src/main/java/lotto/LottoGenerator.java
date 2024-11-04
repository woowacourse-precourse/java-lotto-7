package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGenerator {

    public static List<Lotto> generateLottos(int purchaseAmount) {
        int numberOfLottos = purchaseAmount / 1000;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6)); // 불변 리스트를 수정 가능한 리스트로 복사
            Collections.sort(numbers);
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public static int generateBonusNumber(List<Integer> winningNumbers) {
        int bonusNumber;
        do {
            bonusNumber = Randoms.pickNumberInRange(1, 45);
        } while (winningNumbers.contains(bonusNumber));
        return bonusNumber;
    }
}
