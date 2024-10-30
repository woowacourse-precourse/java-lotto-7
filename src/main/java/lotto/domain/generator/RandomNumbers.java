package lotto.domain.generator;

import java.util.ArrayList;
import java.util.List;

public class RandomNumbers {

    private final List<RandomNumber> randomNumbers;

    public RandomNumbers() {
        this.randomNumbers = new ArrayList<>();
    }

    public void addRandomNumber(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            randomNumbers.add(RandomNumber.generate());
        }
    }
}
