package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoIssuer {
    public List<Lotto> generateLottos(int money) {
        List<Lotto> issuedLottos = new ArrayList<>();
        for (int i=0; i<money/1000; i++) {
            List<Integer> numbers = generateLottoNumbers();
            issuedLottos.add(new Lotto(numbers));
        }
        return issuedLottos;
    }

    private List<Integer> generateLottoNumbers() {
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }
}
