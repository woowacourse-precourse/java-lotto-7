package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoMachine {
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_NUMBER_LENGTH =6;
    private static final int randoms = Randoms.pickNumberInRange(MIN_RANGE, MAX_RANGE);

    private List<Lotto> lottoes;

    public List<Lotto> drawLotto(int count) {
        lottoes = new ArrayList<Lotto>(count);
        for (int i = 0; i < count; i++) {
            List<Integer> sortedNumbers = generateNumbers();
            Lotto lotto = new Lotto(sortedNumbers);
            lottoes.add(lotto);
        }
        return lottoes;
    }
    public List<Integer> generateNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>(LOTTO_NUMBER_LENGTH);

        while (uniqueNumbers.size() < LOTTO_NUMBER_LENGTH) {
            int randomNumber = randoms;
            uniqueNumbers.add(randomNumber);
        }
        List<Integer> sortedNumbers = new ArrayList<>(uniqueNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

}
