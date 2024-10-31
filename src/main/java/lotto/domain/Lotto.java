package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;
    private int matchNumber;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers(){
        return numbers;
    }

    public void increaseMatchNumber() {
        matchNumber++;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
