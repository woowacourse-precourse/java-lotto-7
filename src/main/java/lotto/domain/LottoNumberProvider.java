package lotto.domain;

import lotto.util.RandomNumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class LottoNumberProvider {

    public List<Set<Integer>> generateAndStoreLottoNumbers(int lottoCount) {
        List<Set<Integer>> totalLottoNumbers = new ArrayList<>();
        RandomNumber randomNumber = new RandomNumber();

        for (int i = 0; i < lottoCount; i++) {
            Set<Integer> lottoNumbers = new TreeSet<>(randomNumber.getUniqueRandomNumbers());

            totalLottoNumbers.add(lottoNumbers);
        }

        return totalLottoNumbers;
    }
}
