package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserLotto {
    private List<Integer> numbers;

    public UserLotto(List<Integer> numbers) {
        this.numbers = sortNumbers(numbers);
    }

    public List<Integer> sortNumbers(List<Integer> unsortedList) {
        ArrayList<Integer> sortedList = new ArrayList<>(unsortedList);
        Collections.sort(sortedList);
        return sortedList;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
