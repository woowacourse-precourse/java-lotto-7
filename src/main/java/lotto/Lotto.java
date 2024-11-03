package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = sortLotto(numbers);
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
        validateLottoNumber(numbers);
        if (checkExistDuplNumber(numbers)) {
            throw new IllegalArgumentException("[ERROR] 중복된 숫자를 입력할 수 없습니다.");
        }
    }

    private List<Integer> sortLotto(List<Integer> beforeSortNumbers) {
        List<Integer> sortedNumbers = new ArrayList<>(beforeSortNumbers);
        Collections.sort(sortedNumbers);
        return sortedNumbers;
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    public void validateLottoNumber(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("로또번호는 1~45만 가능합니다");
            }
        }
    }

    public boolean checkExistDuplNumber(List<Integer> numbers) {
        return numbers.size() != numbers.stream().distinct().count();
    }

    public boolean isNumberInLottoResult(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }


    public int findDuplicateNumber(List<Integer> lottoNumbers) {
        Set<Integer> myNumbers = new HashSet<>(numbers);
        Set<Integer> compareNumbers = new HashSet<>(lottoNumbers);
        myNumbers.retainAll(compareNumbers);
        return myNumbers.size();
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
