package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    public static final int LOTTO_NUMBER_QUANTITY = 6;

    private final List<Ball> numbers;

    public static Lotto with(List<Integer> numbers) {
        List<Ball> balls = numbers.stream().map(Ball::valueOf).toList();
        return new Lotto(balls);
    }

    public Lotto(List<Ball> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Ball> numbers) {
        if (numbers.size() != LOTTO_NUMBER_QUANTITY) {
            throw new IllegalArgumentException(String.format("[ERROR] 로또 번호는 %d개여야 합니다.", LOTTO_NUMBER_QUANTITY));
        }
        isDuplicate(numbers);
    }

    private void isDuplicate(List<Ball> balls) {
        Set<Ball> s = new HashSet<>();
        for (Ball ball : balls) {
            if (!s.add(ball)) {
                throw new IllegalArgumentException(
                        String.format("[ERROR] 중복된 로또 번호가 있습니다: (%s).", ball)
                );
            }
        }
    }

    public boolean hasBall(Ball ball) {
        return numbers.contains(ball);
    }

    public int countMatch(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::hasBall)
                .count();
    }

    public List<Integer> getNumbers() {
        return numbers.stream()
                .map(Ball::getNumber)
                .toList();
    }
}

