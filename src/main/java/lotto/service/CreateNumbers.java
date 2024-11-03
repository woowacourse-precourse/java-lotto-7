package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CreateNumbers {
    private List<List<Integer>> numbers = new ArrayList<>();

    public void numbersList(int number) {
        for (int i = 0; i < number; i++) {
            numbers.add(create());
        }
    }

    private List<Integer> create() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public List<List<Integer>> getNumbers() {
        return numbers;
    }
}
