package lotto.back.lotto.domain.result;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import lotto.back.lotto.domain.Lotto;
import lotto.back.lotto.domain.LottoNumber;
import lotto.global.status.LottoStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultTest {

    @Test
    void 보너스_번호_중복_예외() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto prizeLotto = new Lotto(List.of(1, 2, 3, 4, 5, 7));
        LottoNumber bonusNumber = new LottoNumber(7);

        // when, then
        assertThatThrownBy(() -> new LottoResult(lotto, prizeLotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest()
    @MethodSource("prizeCheckSource")
    void 당첨_상태_지정(List<Integer> numbers, List<Integer> prizeNumbers,
                  Integer bonusNumber, LottoStatus expectedLottoStatus) {
        // given
        Lotto lotto = new Lotto(numbers);
        Lotto prizeLotto = new Lotto(prizeNumbers);
        LottoNumber bonusLottoNumber = new LottoNumber(bonusNumber);

        // when
        LottoResult lottoResult = new LottoResult(lotto, prizeLotto, bonusLottoNumber);

        // then
        Assertions.assertThat(lottoResult.getLottoStatus()).isEqualTo(expectedLottoStatus);

    }

    private static Stream<Arguments> prizeCheckSource() {
        return Stream.of(
                Arguments.of(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,6), 45, LottoStatus.FIRST),
                Arguments.of(List.of(1,2,3,4,5,45), List.of(1,2,3,4,5,6), 45, LottoStatus.SECOND),
                Arguments.of(List.of(1,2,3,4,5,6), List.of(1,2,3,4,5,8), 45, LottoStatus.THIRD),
                Arguments.of(List.of(1,2,3,4,5,6), List.of(1,2,3,4,9,10), 45, LottoStatus.FOURTH),
                Arguments.of(List.of(1,2,3,4,5,6), List.of(1,2,3,8,9,11), 45, LottoStatus.FIFTH),
                Arguments.of(List.of(1,2,3,4,5,6), List.of(1,2,8,9,10,11), 45, LottoStatus.NONE)
        );
    }

}