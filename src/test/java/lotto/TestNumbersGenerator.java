package lotto;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TestNumbersGenerator implements RandomIntegersGenerator {

    private Queue<Integer> integers = new ArrayDeque<>();

    TestNumbersGenerator(List<Integer> integers) {
        this.integers = new ArrayDeque<>(integers);
    }

    @Override
    public List<Integer> generate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            lottoNumbers.add(integers.poll());
        }
        return lottoNumbers;
    }
}
