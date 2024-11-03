package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.utils.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomNumberTest {

    @DisplayName("랜덤번호를 생성할 때, 6자리의 랜덤번호가 생성된다")
    @Test
    void create_random_number_test() {
        //given
        List<Integer> testRandomNumbers = RandomNumber.create();
        //when, then
        assertThat(testRandomNumbers.size()).isEqualTo(6);
    }

    @DisplayName("랜덤번호를 생성할 때, 중복된 값이 존재해서는 안 된다")
    @RepeatedTest(100)
    void random_number_duplicate_test() {
        //given
        List<Integer> testRandomNumbers = RandomNumber.create();
        Set<Integer> verifyTestRandomNumbers = new HashSet<>(testRandomNumbers);
        //when, then
        assertThat(verifyTestRandomNumbers.size()).isEqualTo(6);
    }

    @DisplayName("랜덤번호의 범위는 항상 1보다 크거나 같고, 45보다 작거나 같아야한다")
    @RepeatedTest(100)
    void random_number_range_test() {
        //given
        List<Integer> testRandomNumbers = RandomNumber.create();
        for (Integer testRandomNumber : testRandomNumbers) {
            assertThat(testRandomNumber).isBetween(1, 45);
        }
    }

}
