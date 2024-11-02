package lotto.model;

import java.util.List;
import java.util.stream.Stream;
import lotto.constant.WinningType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottosTest {

    @Test
    void 여섯_개가_맞으면_1등이다() {
        //given
        Lottos lottos = Lottos.create(List.of(
                List.of(1, 2, 3, 4, 5, 6)
        ));
        WinningNumbers winningNumbers = WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7, winningNumbers);

        //when
        final LottoResult result = lottos.check(winningNumbers, bonusNumber);

        //then
        Assertions.assertThat(result.getResult().get(WinningType.FIRST)).isEqualTo(1);
    }

    @Test
    void 다섯_개가_맞고_보너스_번호가_맞으면_2등이다() {
        //given
        Lottos lottos = Lottos.create(List.of(
                List.of(1, 2, 3, 4, 5, 7)
        ));
        WinningNumbers winningNumbers = WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7, winningNumbers);

        //when
        final LottoResult result = lottos.check(winningNumbers, bonusNumber);

        //then
        Assertions.assertThat(result.getResult().get(WinningType.BONUS)).isEqualTo(1);
    }

    @Test
    void 다섯_개가_맞고_보너스_번호가_안맞으면_3등이다() {
        //given
        Lottos lottos = Lottos.create(List.of(
                List.of(1, 2, 3, 4, 5, 8)
        ));
        WinningNumbers winningNumbers = WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7, winningNumbers);

        //when
        final LottoResult result = lottos.check(winningNumbers, bonusNumber);

        //then
        Assertions.assertThat(result.getResult().get(WinningType.THIRD)).isEqualTo(1);
    }

    @Test
    void 네개가_맞으면_4등이다() {
        //given
        Lottos lottos = Lottos.create(List.of(
                List.of(1, 2, 3, 4, 8, 9)
        ));
        WinningNumbers winningNumbers = WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7, winningNumbers);

        //when
        final LottoResult result = lottos.check(winningNumbers, bonusNumber);

        //then
        Assertions.assertThat(result.getResult().get(WinningType.FOURTH)).isEqualTo(1);
    }

    @Test
    void 세개가_맞으면_5등이다() {
        //given
        Lottos lottos = Lottos.create(List.of(
                List.of(1, 2, 3, 8, 9, 10)
        ));
        WinningNumbers winningNumbers = WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7, winningNumbers);

        //when
        final LottoResult result = lottos.check(winningNumbers, bonusNumber);

        //then
        Assertions.assertThat(result.getResult().get(WinningType.FIFTH)).isEqualTo(1);
    }

    @ParameterizedTest
    @MethodSource("missingLottoNumbers")
    void 일치하는_개수가_3개_미만이면_꽝이다(List<List<Integer>> numbers) {
        //given
        Lottos lottos = Lottos.create(numbers);
        WinningNumbers winningNumbers = WinningNumbers.create(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = BonusNumber.create(7, winningNumbers);

        //when
        final LottoResult result = lottos.check(winningNumbers, bonusNumber);

        //then
        Assertions.assertThat(result.getResult().get(WinningType.NONE)).isEqualTo(1);
    }

    private static Stream<Arguments> missingLottoNumbers() {
        return Stream.of(
                Arguments.of(List.of(List.of(1, 2, 8, 9, 10, 11))),
                Arguments.of(List.of(List.of(1, 8, 9, 10, 11, 12))),
                Arguments.of(List.of(List.of(8, 9, 10, 11, 12, 13)))
        );
    }
}
