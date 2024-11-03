package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(List<List<Integer>> lottoNumbers) throws IllegalStateException {
        this.lottos = new ArrayList<Lotto>();
        validate(lottoNumbers);
        for (int i = 0; i < lottoNumbers.size(); ++i) {
            this.lottos.add(new Lotto(lottoNumbers.get(i)));
        }
    }

    private void validate(List<List<Integer>> lottoNumbers) {
        for (int i = 0; i < lottoNumbers.size(); i++) {
            for (int j = i + 1; j < lottoNumbers.size(); j++) {
                checkDuplicate(lottoNumbers.get(i), lottoNumbers.get(j));
            }
        }
    }

    private void checkDuplicate(List<Integer> number1, List<Integer> number2) {
        if (number1.containsAll(number2)) {
            throw new IllegalStateException();
        }
    }

    public List<List<Integer>> showAllNumbersOfLottos() {
        List<List<Integer>> numbersOfLottos = new ArrayList<>();
        for (int i = 0; i < lottos.size(); ++i) {
            numbersOfLottos.add(lottos.get(i).numbers());
        }
        return numbersOfLottos;
    }
}
