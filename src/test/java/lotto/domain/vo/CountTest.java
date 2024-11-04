package lotto.domain.vo;

import lotto.exception.LottoException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 10, 50, 100})
    void 로또_개수가_범위_내일_때_정상_생성된다(int validLottoCount) {
        // given // when
        Count count = Count.newInstance(validLottoCount);

        // then
        assertThat(count.lottoCount()).isEqualTo(validLottoCount);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void 로또_개수가_최소_범위보다_작을_경우_예외가_발생한다(int invalidLottoCount) {
        // given // when // then
        assertThatThrownBy(() -> Count.newInstance(invalidLottoCount))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 로또 구매 수량은 1장 이상 100장 이하이어야 합니다. 다시 입력해 주세요.");
    }


    @ParameterizedTest
    @ValueSource(ints = {101, 150})
    void 로또_개수가_최대_범위보다_클_경우_예외가_발생한다(int invalidLottoCount) {
        // given // when // then
        assertThatThrownBy(() -> Count.newInstance(invalidLottoCount))
                .isInstanceOf(LottoException.class)
                .hasMessage("[ERROR] 로또 구매 수량은 1장 이상 100장 이하이어야 합니다. 다시 입력해 주세요.");
    }
}
