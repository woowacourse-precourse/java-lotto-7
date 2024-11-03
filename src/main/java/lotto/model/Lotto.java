package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.validator.LottoWinningNumbersValidator;

public class Lotto {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        LottoWinningNumbersValidator.validateWinningNumbers(numbers);
        this.numbers = numbers;
    }

    public List<Integer> lottoNumbers() {
        return numbers;
    }

    public int countMatchingNumbers(List<Integer> winningNumbers) {
        int matchCount = 0;
        for (Integer number : this.numbers) {
            if (winningNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static List<Lotto> makeRandomLottos(int numberOfTickets) {
        List<Lotto> lottos = new ArrayList<>();
        Set<List<Integer>> uniqueLottoSets = new HashSet<>();
        while (lottos.size() < numberOfTickets) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_NUMBER_SIZE));
            Collections.sort(numbers);
            if (uniqueLottoSets.add(numbers)) {
                lottos.add(new Lotto(numbers));
            }
        }
        return lottos;
    }


}
