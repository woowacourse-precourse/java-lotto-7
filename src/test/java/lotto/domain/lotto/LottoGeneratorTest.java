package lotto.domain.lotto;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class LottoGeneratorTest {

    @Test
    void 로또_생성시_로또는_NULL이_아니다() {
        //given
        LottoGenerator lottoGenerator = new LottoGenerator();

        //when
        Lotto lotto = lottoGenerator.generate();

        //then
        assertNotNull(lotto);
    }
}
