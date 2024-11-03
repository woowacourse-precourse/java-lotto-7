package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    public Lottos(int size) throws IllegalStateException {
        this.lottos = new ArrayList<Lotto>(size);
        List<List<Integer>> lottoNumbers = makeLottoNumbers(size);
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

    private List<List<Integer>> makeLottoNumbers(int size) {
        List<List<Integer>> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            List<Integer> lottoCandidate = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Collections.sort(lottoCandidate);
            lottoNumbers.add(lottoCandidate);
        }
        return lottoNumbers;
    }

    public List<List<Integer>> showAllNumbersOfLottos() {
        List<List<Integer>> numbersOfLottos = new ArrayList<>();
        for (int i = 0; i < lottos.size(); ++i) {
            numbersOfLottos.add(lottos.get(i).numbers());
        }
        return numbersOfLottos;
    }
}
