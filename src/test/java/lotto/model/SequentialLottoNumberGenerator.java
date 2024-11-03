package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class SequentialLottoNumberGenerator implements LottoNumbersGenerator {

    private int sequence = 1;

    @Override
    public List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            numbers.add(sequence++);
            if (45 < sequence) {
                sequence = 1;
            }
        }
        return List.copyOf(numbers);
    }

}
