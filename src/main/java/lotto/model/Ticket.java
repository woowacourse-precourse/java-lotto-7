package lotto.model;

import java.util.List;

/**
 * 구매한 로또번호
 */
public class Ticket {

    private final List<Integer> numbers;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
