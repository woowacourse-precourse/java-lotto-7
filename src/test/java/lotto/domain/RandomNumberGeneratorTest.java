package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class RandomNumberGeneratorTest {

    @RepeatedTest(1000)
    void 숫자_생성_범위_중복성_테스트() {
        List<Integer> generateNumbers = RandomNumberGenerator.generate();

        long count = generateNumbers.stream()
                .distinct()
                .filter(num -> num <= 45 && num >= 1)
                .count();

        Assertions.assertThat(count).isEqualTo(6);
    }

    @RepeatedTest(100)
    void 숫자_생성_범위_초과_테스트() {
        List<Integer> generateNumbers = RandomNumberGenerator.generate();

        long count = generateNumbers.stream()
                .filter(num -> num > 45)
                .count();

        Assertions.assertThat(count).isEqualTo(0);
    }

    @RepeatedTest(100)
    void 숫자_생성_범위_미만_테스트() {
        List<Integer> generateNumbers = RandomNumberGenerator.generate();

        long count = generateNumbers.stream()
                .filter(num -> num < 1)
                .count();

        Assertions.assertThat(count).isEqualTo(0);
    }

    @Test
    void 숫자_생성_독립성_테스트() {
        List<Integer> generateNumbers = RandomNumberGenerator.generate();
        int testRuns = 100;
        int allowedCount = 5;
        int count = 0;

        for (int i = 0; i < testRuns; i++) {
            List<Integer> temp = new ArrayList<>(generateNumbers);
            List<Integer> newGenerated = RandomNumberGenerator.generate();
            temp.retainAll(newGenerated);

            if (temp.size() == 6) {
                count++;
            }
        }
        Assertions.assertThat(count).isLessThan(allowedCount);
    }
}
