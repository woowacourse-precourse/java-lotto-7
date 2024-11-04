package lotto.domain.lotto;

import java.util.HashSet;
import java.util.List;

public class Lotto {

    public static final int LOTTO_BALL_COUNT = 6;

    private final List<LottoBall> lottoBalls;

    private Lotto(List<LottoBall> lottoBalls) {
        validate(lottoBalls);
        this.lottoBalls = lottoBalls;
    }

    public static Lotto issue(final List<Integer> numbers) {
        return new Lotto(numbers.stream()
                .map(LottoBall::draw)
                .toList()
        );
    }

    public int calculateMatchingCount(final Lotto other) {
        return (int) lottoBalls.stream()
                .filter(other.lottoBalls::contains)
                .count();
    }

    public boolean has(final LottoBall lottoBall) {
        return lottoBalls.contains(lottoBall);
    }

    private void validate(List<LottoBall> lottoBalls) {
        validateLottoBallCount(lottoBalls);
        validateDuplication(lottoBalls);
    }

    private void validateLottoBallCount(final List<LottoBall> lottoBalls) {
        if (lottoBalls.size() != LOTTO_BALL_COUNT) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplication(final List<LottoBall> lottoBalls) {
        if (new HashSet<>(lottoBalls).size() != LOTTO_BALL_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복되지 않아야 합니다.");
        }
    }

    public List<Integer> numbers() {
        return lottoBalls.stream()
                .map(LottoBall::number)
                .sorted()
                .toList();
    }

    @Override
    public String toString() {
        return "Lotto" + lottoBalls;
    }

}
