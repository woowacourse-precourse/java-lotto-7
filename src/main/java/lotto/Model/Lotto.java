package lotto.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.View.InputView;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
    public List<Integer> lottoNumberPublication() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return numbers;
    }

    public List<Integer> getSortedLottoNumbers() {
        List<Integer> numbers = lottoNumberPublication();
        Collections.sort(numbers);
        return numbers;
    }

    public int theNumberOfLotto(int lottoPurchase, int price) {
        return lottoPurchase / price;
    }

    public int convertStringToInt(String input) {
        return Integer.parseInt(input);
    }

    public List<List<Integer>> totalLotto(int count) {
        List<List<Integer>> publicationNumbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            publicationNumbers.add(getSortedLottoNumbers());
        }

        return publicationNumbers;
    }

    private int findLottoRank(long matchingCount, int bonusNumber) {
        boolean hasBonusMatch = numbers.contains(bonusNumber);

        if (matchingCount == 6) {
            return 1;
        } else if (matchingCount == 5 && hasBonusMatch) {
            return 2;
        } else if (matchingCount == 5) {
            return 3;
        } else if (matchingCount == 4) {
            return 4;
        } else if (matchingCount == 3) {
            return 5;
        } else {
            return 0;
        }
    }

    public List<Integer> findMatchNumber() {
        int PRICE = 1000;
        int lottoPurchase = convertStringToInt(InputView.lottoPurchase());
        int count = theNumberOfLotto(lottoPurchase, PRICE);
        int bonusNumber = convertStringToInt(InputView.bonusNumber());
        List<List<Integer>> lotto = totalLotto(count);
        List<Integer> duplicateCountList = new ArrayList<>();

        Set<Integer> set = new HashSet<>(numbers);

        for (List<Integer> numbers : lotto) {
            long duplicateCount = numbers.stream()
                    .filter(set::contains)
                    .count();

            duplicateCountList.add(findLottoRank(duplicateCount, bonusNumber));
        }

        return duplicateCountList;
    }

    public List<Integer> findMatchNumberCount(List<Integer> duplicateCountList) {

        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0));

        for (int number : duplicateCountList) {
            result.set(number, result.get(number) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        List<Integer> p = lotto.findMatchNumberCount(lotto.findMatchNumber());
        System.out.println(p);
    }
}
