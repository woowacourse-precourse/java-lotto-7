package lotto;

import java.util.Objects;

public class Ball {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;

    private final int number;

    public Ball(int number) {
        if (isNotBetweenStartAndEndNumber(number)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 번호는 %d~%d사이의 번호여야 합니다.", START_NUMBER, END_NUMBER));
        }
        this.number = number;
    }

    private boolean isNotBetweenStartAndEndNumber(int number) {
        return !(START_NUMBER <= number && number <= END_NUMBER);
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return "Ball{" +
               "number=" + number +
               '}';
    }
}
