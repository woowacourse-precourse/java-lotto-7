package lotto.io;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LottoConverterTest {

    LottoConverter lottoConverter;

    @BeforeEach
    void setUp() {
        lottoConverter = new LottoConverter();
    }

    @Test
    void 유저가_구매한_로또_개수_가져오기() throws Exception {
        // given
        String price = "10000";

        // when
        int lottoCount = lottoConverter.getLottoCount(price);

        // then
        assertThat(lottoCount).isEqualTo(10);
    }

    @Test
    void 유저가_구매한_금액이_1000원으로_나누어_떨어지지_않으면_예외가_발생한다() throws Exception {
        // given
        String price = "100001";

        // when // then
        assertThatThrownBy(() -> lottoConverter.getLottoCount(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 금액은 1,000원 단위어야 합니다.");
    }

    @Test
    void 유저가_숫자_외의_값을_입력하면_예외가_발생한다() throws Exception {
        // given
        String price = "asd";

        // when // then
        assertThatThrownBy(() -> lottoConverter.getLottoCount(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 숫자만 입력 가능합니다.");
    }

}