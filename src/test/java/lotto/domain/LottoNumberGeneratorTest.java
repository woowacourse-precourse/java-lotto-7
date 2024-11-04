package lotto.domain;

import lotto.util.Limit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 발행 검증")
class LottoNumberGeneratorTest {
    @Test
    @DisplayName("발행된 로또 번호가 1~45 사이인지")
    void issuedLottoNumberIsBetweenRange() {
        assertThat(LottoNumberGenerator.create().generate())
                .allMatch(number -> number >= Limit.MIN_RANGE && number <= Limit.MAX_RANGE);
    }

    @Test
    @DisplayName("발행된 로또 번호가 6개의 숫자인지")
    void issuedLottoNumberHasSizeSix() {
        assertThat(LottoNumberGenerator.create().generate()).hasSize(Limit.LOTTO_SIZE);
    }

    @Test
    @DisplayName("발행된 로또 번호가 서로 중복되지 않는지")
    void issuedLottoNumberNotDuplicate() {
        assertThat(LottoNumberGenerator.create().generate()).doesNotHaveDuplicates();
    }
}