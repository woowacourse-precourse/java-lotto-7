package lotto;

import static lotto.utils.Constants.LOTTO_NUMBERS_SIZE;
import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.LottoBundle;
import org.junit.jupiter.api.Test;

class LottoBundleTest {

    @Test
    void 로또_묶음_생성_기능_테스트() {
        // given
        int count = 8;

        // when
        LottoBundle lottoBundle = LottoBundle.of(count);

        // then
        assertThat(lottoBundle.getLotteries())
                .hasSize(count)
                .allSatisfy(lotto -> assertThat(lotto.getNumbers()).hasSize(LOTTO_NUMBERS_SIZE));
    }
}