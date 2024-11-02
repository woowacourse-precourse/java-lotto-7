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

    public List<Integer> findMatchNumber() {
        int PRICE = 1000;
        int lottoPurchase = convertStringToInt(InputView.lottoPurchase());
        int count = theNumberOfLotto(lottoPurchase, PRICE);
        List<List<Integer>> lotto = totalLotto(count);
        List<Integer> duplicateCountList = new ArrayList<>();

        Set<Integer> set = new HashSet<>(numbers);

        for (List<Integer> numbers : lotto) {
            long duplicateCount = numbers.stream()
                    .filter(set::contains)
                    .count();

            duplicateCountList.add((int) duplicateCount);
        }

        return duplicateCountList;
    }

    public List<Integer> findMatchNumberCount(List<Integer> duplicateCountList) {
        // 0부터 5까지의 인덱스를 가진 리스트를 초기화 (모든 값은 0)
        List<Integer> result = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 0, 0, 0));

        // 각 숫자의 개수를 계산하여 해당 인덱스에 저장
        for (int number : duplicateCountList) {
            result.set(number, result.get(number) + 1);
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto lotto = new Lotto(numbers);

        lotto.findMatchNumberCount(lotto.findMatchNumber());
    }
}
