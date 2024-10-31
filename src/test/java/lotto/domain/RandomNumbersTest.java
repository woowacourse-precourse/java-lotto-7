package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

class RandomNumbersTest {
    @Test
    @DisplayName("")

    public void randomNumbersTest() {
        List<Integer> randomNumbers = RandomNumbers.getRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(6);
    }
}