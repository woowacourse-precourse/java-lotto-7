package lotto.machine;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.constants.LottoConstants.*;

public class LottoMachine {

    public static List<Lotto> generateLottos(int purchaseAmount) {
        int count = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Integer> numbers = generateLottoNumbers();
            lottos.add(new Lotto(numbers));
        }

        return lottos;
    }

    public static List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN, LOTTO_NUMBER_MAX, LOTTO_NUMBER_COUNT));
        Collections.sort(numbers);
        return numbers;
    }
}
