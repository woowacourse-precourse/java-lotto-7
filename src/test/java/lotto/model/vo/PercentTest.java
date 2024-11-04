package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class PercentTest {

    @Test
    void 반올림_테스트() {
        //given
        Percent percent = new Percent(1.16);

        //when
        String string = percent.toString();

        //then
        assertThat("1.2%")
                .isEqualTo(string);
    }
}
