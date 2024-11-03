package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.rank.LottoPrice;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

@SuppressWarnings("NonAsciiCharacters")
class LottoPriceTest {

    @ParameterizedTest
    @EnumSource(LottoPrice.class)
    void 모든_인스턴스가_올바른_값을_반환한다(LottoPrice lottoPrice) {
        // when
        int actualPrice = LottoPrice.getByLottoCount(lottoPrice.getLottoCount(), lottoPrice.isBonus());

        // then
        assertThat(actualPrice).isEqualTo(lottoPrice.getLottoPrice());
    }

    @ParameterizedTest
    @EnumSource(LottoPrice.class)
    void 로또_가격이_일치한다(LottoPrice lottoPrice) {
        // given
        int price = lottoPrice.getLottoPrice();

        // when & then
        assertThat(lottoPrice.isSameLottoPrice(price)).isTrue();
    }

    @ParameterizedTest
    @CsvSource({
            "3, false, 5000",
            "4, false, 50000",
            "5, false, 1500000",
            "5, true, 30000000",
            "6, false, 2000000000",
    })
    void 유효한_등수는_당첨금을_반환한다(int lottoCount, boolean isBonus, int expected) {
        // when
        int actual = LottoPrice.getByLottoCount(lottoCount, isBonus);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource({
            "1, false, 0",
            "2, false, 0",
            "7, true, 0",
    })
    void 유효하지_않은_등수는_0원을_반환한다(int lottoCount, boolean isBonus, int expected) {
        // when
        int actual = LottoPrice.getByLottoCount(lottoCount, isBonus);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
