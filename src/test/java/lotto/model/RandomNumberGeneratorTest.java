package lotto.model;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    @Test
    @DisplayName("랜덤 숫자를 생성할 수 있다.")
    void should_GenerateRandomNumber() {
        // given
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        // when
        int randomNumber = randomNumberGenerator.generate();
        // then
        Assertions.assertThat(randomNumber).isBetween(1, 45);
    }
}