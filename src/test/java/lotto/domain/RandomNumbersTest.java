package lotto.domain;

import lotto.constant.Constant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RandomNumbersTest {
    @Test
    @DisplayName("범위에 맞는 랜덤 숫자 사이즈 테스트")
    public void randomNumbersTest() {
        List<Integer> randomNumbers = RandomNumbers.getRandomNumbers();
        assertThat(randomNumbers.size()).isEqualTo(Constant.LOTTO_NUMBER_SIZE);
    }
}