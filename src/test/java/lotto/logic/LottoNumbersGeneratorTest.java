package lotto.logic;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoNumbersGeneratorTest {

    @Test
    void 로또_자동_추첨_테스트() {
        //given
        int count = 5;

        //when
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(count);

        //then
        assertThat(count)
                .isEqualTo(lottoNumbersGenerator.getLottos().size());
    }

    @Test
    void 로또_자동_추첨_많이_테스트() {
        //given
        int count = 100000;

        //when
        LottoNumbersGenerator lottoNumbersGenerator = new LottoNumbersGenerator(count);

        //then
        assertThat(count)
                .isEqualTo(lottoNumbersGenerator.getLottos().size());
    }
}