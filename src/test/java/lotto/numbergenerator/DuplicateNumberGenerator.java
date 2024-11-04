package lotto.numbergenerator;

import java.util.List;

import lotto.model.numbergenerator.NumberGenerator;

public class DuplicateNumberGenerator implements NumberGenerator {

    @Override
    public List<Integer> generateNumber() {
        return List.of(1, 2, 3, 4, 5, 5);
    }
}
