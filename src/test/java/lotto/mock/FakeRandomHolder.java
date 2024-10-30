package lotto.mock;

import java.util.ArrayList;
import java.util.List;
import lotto.lottery.service.port.RandomHolder;

public class FakeRandomHolder implements RandomHolder {

    private List<Integer> numbers = new ArrayList<>();

    public FakeRandomHolder(List<Integer> numbers) {
        this.numbers = numbers;
    }

    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

}
