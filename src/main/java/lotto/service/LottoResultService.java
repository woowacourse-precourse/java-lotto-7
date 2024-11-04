package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;

public class LottoResultService {
    public List<Integer> getResult(List<Lotto> purchasedLotto, Lotto winningNumber, int bonusNumber) {
        List<Integer> result = Arrays.asList(0,0,0,0,0);

        for (Lotto lotto : purchasedLotto) {
            int count = countMatchingNumbers(lotto, winningNumber);
            updateResultList(result, count, lotto.getNumbers(), bonusNumber);
        }

        return result;
    }

    private int countMatchingNumbers(Lotto lotto, Lotto winningNumber) {
        int count = 0;
        List<Integer> numbers = lotto.getNumbers();
        for (int number : winningNumber.getNumbers()) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    private void updateResultList(List<Integer> result, int count, List<Integer> numbers, int bonusNumber) {
        int index = getResultIndex(count, numbers, bonusNumber);
        if (index != -1) {
            int tmp = result.get(index);
            result.set(index, tmp + 1);
        }
    }

    private int getResultIndex(int count, List<Integer> numbers, int bonusNumber) {
        if (count == 3) {
            return 0;
        }
        if (count == 4) {
            return 1;
        }
        if (count == 5) {
            return numbers.contains(bonusNumber) ? 3 : 2;
        }
        if (count == 6) {
            return 4;
        }
        return -1;
    }
}
