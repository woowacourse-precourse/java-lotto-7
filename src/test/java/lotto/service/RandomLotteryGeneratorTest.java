package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomLotteryGeneratorTest {

    private RandomLotteryGenerator randomLotteryGenerator;

    @BeforeEach
    void setUp() {
        randomLotteryGenerator = new RandomLotteryGenerator();
    }

    @Test
    @DisplayName("1 ~ 45 사이의 숫자 중 중복되지 않는 6개의 숫자를 뽑아서 로또를 랜덤으로 생성할 수 있다.")
    void 중복되지_않는_6개의_숫자를_뽑아서_로또를_랜덤으로_생성할_수_있다(){
        //given
        //when
        Lotto lotto = randomLotteryGenerator.generateEachLotto();

        //then
        assertThat(lotto.getNumbers())
                .hasSize(6) // 숫자가 6개인지 확인
                .doesNotHaveDuplicates() // 중복이 없는지 확인
                .allMatch(number -> number >= 1 && number <= 45);
    }

}