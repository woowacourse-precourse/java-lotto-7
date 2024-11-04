package lotto;

import java.util.Objects;

public class Ball {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int TOTAL_BALLS_INDEX = END_NUMBER + 1;

    // 1 ~ 45 까지의 공이 1개씩만 생성하는 것을 보장해주기 위함
    // 또한, 편의상 index 혼동을 방지하기 위해 배열 인덱스를 1부터 시작
    private static final Ball[] lottoBalls = new Ball[TOTAL_BALLS_INDEX];
    static {
        for (int number = START_NUMBER; number <= END_NUMBER; number++) {
            lottoBalls[number] = new Ball(number);
        }
    }

    private final int number;

    public static Ball valueOf(int number) {
        if (isNotBetweenStartAndEndNumber(number)) {
            throw new IllegalArgumentException(
                    String.format("[ERROR] 번호는 %d~%d사이의 번호여야 합니다.", START_NUMBER, END_NUMBER));
        }
        return lottoBalls[number];
    }

    private Ball(int number) {
        this.number = number;
    }

    private static boolean isNotBetweenStartAndEndNumber(int number) {
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
