package lotto.domain;

import static lotto.constant.ExceptionMessage.DUPLICATE_BONUS;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.vo.LottoNumber;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class WinningLottoTest {

    @Nested
    class 당첨_번호_생성_테스트 {
        @Test
        void 당첨_번호와_보너스_번호로_당첨_로또를_생성한다() {
            // given
            Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber bonusNumber = LottoNumber.from(7);

            // when
            WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);

            // then
            assertThat(winningLotto).isNotNull();
        }

        @Test
        void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
            // given
            Lotto winningNumbers = Lotto.from(List.of(1, 2, 3, 4, 5, 6));
            LottoNumber duplicatedBonus = LottoNumber.from(1);

            // when & then
            assertThatThrownBy(() -> WinningLotto.of(winningNumbers, duplicatedBonus))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage(DUPLICATE_BONUS.message());
        }
    }

    @Nested
    class 당첨_번호_매칭_테스트 {
        @Test
        void 모든_번호가_일치하면_1등이다() {
            // given
            WinningLotto winningLotto = WinningLotto.of(
                    Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                    LottoNumber.from(7)
            );
            Lotto userLotto = Lotto.from(List.of(1, 2, 3, 4, 5, 6));

            // when
            LottoRank rank = winningLotto.match(userLotto);

            // then
            assertThat(rank).isEqualTo(LottoRank.FIRST);
        }

        @Test
        void 순서가_다르더라도_번호가_일치하면_당첨된다() {
            // given
            WinningLotto winningLotto = WinningLotto.of(
                    Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                    LottoNumber.from(7)
            );
            Lotto userLotto = Lotto.from(List.of(6, 5, 4, 3, 2, 1));

            // when
            LottoRank rank = winningLotto.match(userLotto);

            // then
            assertThat(rank).isEqualTo(LottoRank.FIRST);
        }

        @ParameterizedTest
        @CsvSource({
                "1, 2, 3, 4, 5, 7, SECOND",    // 5개 일치 + 보너스 번호 일치
                "1, 2, 3, 4, 5, 8, THIRD",     // 5개 일치 (보너스 번호 불일치)
                "1, 2, 3, 4, 7, 8, FOURTH",    // 4개 일치
                "1, 2, 3, 7, 8, 9, FIFTH"      // 3개 일치
        })
        void 일치하는_번호_개수와_보너스_번호_일치_여부에_따라_당첨_등수가_결정된다(
                int n1, int n2, int n3, int n4, int n5, int n6, LottoRank expectedRank) {
            // given
            WinningLotto winningLotto = WinningLotto.of(
                    Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                    LottoNumber.from(7)
            );
            Lotto userLotto = Lotto.from(List.of(n1, n2, n3, n4, n5, n6));

            // when
            LottoRank rank = winningLotto.match(userLotto);

            // then
            assertThat(rank).isEqualTo(expectedRank);
        }

        @ParameterizedTest
        @CsvSource({
                "7, 8, 9, 10, 11, 12",     // 0개 일치
                "1, 7, 8, 9, 10, 11",      // 1개 일치
                "1, 2, 7, 8, 9, 10"        // 2개 일치
        })
        void 일치하는_번호가_3개_미만이면_낙첨된다(int n1, int n2, int n3, int n4, int n5, int n6) {
            // given
            WinningLotto winningLotto = WinningLotto.of(
                    Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                    LottoNumber.from(7)
            );
            Lotto userLotto = Lotto.from(List.of(n1, n2, n3, n4, n5, n6));

            // when
            LottoRank rank = winningLotto.match(userLotto);

            // then
            assertThat(rank).isEqualTo(LottoRank.MISS);
        }

        @Test
        void 보너스_번호만_일치하는_경우_낙첨된다() {
            // given
            WinningLotto winningLotto = WinningLotto.of(
                    Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                    LottoNumber.from(7)
            );
            Lotto userLotto = Lotto.from(List.of(7, 8, 9, 10, 11, 12));

            // when
            LottoRank rank = winningLotto.match(userLotto);

            // then
            assertThat(rank).isEqualTo(LottoRank.MISS);
        }

        @Test
        void 두개_일치하고_보너스_번호가_일치해도_낙첨된다() {
            // given
            WinningLotto winningLotto = WinningLotto.of(
                    Lotto.from(List.of(1, 2, 3, 4, 5, 6)),
                    LottoNumber.from(7)
            );
            Lotto userLotto = Lotto.from(List.of(1, 2, 7, 8, 9, 10));

            // when
            LottoRank rank = winningLotto.match(userLotto);

            // then
            assertThat(rank).isEqualTo(LottoRank.MISS);
        }
    }
}