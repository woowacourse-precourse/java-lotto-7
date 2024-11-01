package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RandomsTest {
    @DisplayName("입력한_숫자대로_랜덤_넘버_생성_되는지_테스트")
    @Test
    void 입력한_숫자대로_랜덤_넘버_생성_되는지_테스트() {
        int number = 6;
        Randoms randoms = new Randoms(number);

        assertThat(randoms.getRandoms().size()).isEqualTo(number);
    }
}