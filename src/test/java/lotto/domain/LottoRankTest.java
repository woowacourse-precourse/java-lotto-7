package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;

class LottoRankTest {

    @Nested
    class 당첨_등수_결정_테스트 {
        @ParameterizedTest
        @CsvSource({
                "6, false, FIRST",     // 1등: 6개 일치
                "5, true,  SECOND",    // 2등: 5개 + 보너스
                "5, false, THIRD",     // 3등: 5개 일치
                "4, false, FOURTH",    // 4등: 4개 일치
                "4, true,  FOURTH",    // 4등: 4개 일치 + 보너스 (보너스 무관)
                "3, false, FIFTH",     // 5등: 3개 일치
                "3, true,  FIFTH",     // 5등: 3개 일치 + 보너스 (보너스 무관)
                "2, false, MISS",      // 낙첨: 2개 일치
                "2, true,  MISS",      // 낙첨: 2개 일치 + 보너스
                "1, false, MISS",      // 낙첨: 1개 일치
                "0, false, MISS"       // 낙첨: 0개 일치
        })
        void 일치하는_번호_개수와_보너스_번호_일치_여부로_등수가_결정된다(int matchCount, boolean hasBonusMatch, LottoRank expected) {
            // when
            LottoRank rank = LottoRank.valueOf(matchCount, hasBonusMatch);

            // then
            assertThat(rank).isEqualTo(expected);
        }

        @Test
        void 오직_5개_일치인_경우에만_보너스_번호를_확인한다() {
            // when & then
            assertSoftly(softly -> {
                // 5개 일치하는 경우
                softly.assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
                softly.assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);

                // 다른 개수가 일치하는 경우 보너스 번호 일치 여부 무관
                softly.assertThat(LottoRank.valueOf(4, true)).isEqualTo(LottoRank.FOURTH);
                softly.assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
                softly.assertThat(LottoRank.valueOf(3, true)).isEqualTo(LottoRank.FIFTH);
                softly.assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
            });
        }
    }

    @Nested
    class 당첨금_정보_테스트 {
        @Test
        void 당첨_등수별_상금을_정확히_반환한다() {
            assertSoftly(softly -> {
                softly.assertThat(LottoRank.FIRST.getPrizeAmount()).isEqualTo(2_000_000_000);
                softly.assertThat(LottoRank.SECOND.getPrizeAmount()).isEqualTo(30_000_000);
                softly.assertThat(LottoRank.THIRD.getPrizeAmount()).isEqualTo(1_500_000);
                softly.assertThat(LottoRank.FOURTH.getPrizeAmount()).isEqualTo(50_000);
                softly.assertThat(LottoRank.FIFTH.getPrizeAmount()).isEqualTo(5_000);
                softly.assertThat(LottoRank.MISS.getPrizeAmount()).isZero();
            });
        }
    }

    @Nested
    class 당첨_여부_판단_테스트 {
        @ParameterizedTest
        @EnumSource(value = LottoRank.class, mode = EnumSource.Mode.EXCLUDE, names = "MISS")
        void 낙첨이_아닌_모든_등수는_당첨으로_판단한다(LottoRank rank) {
            assertThat(LottoRank.isWinning(rank)).isTrue();
        }

        @Test
        void MISS는_당첨이_아니다() {
            assertThat(LottoRank.isWinning(LottoRank.MISS)).isFalse();
        }
    }

    @Nested
    class 당첨_정보_속성_테스트 {
        @Test
        void 등수별_일치_번호_개수를_정확히_반환한다() {
            assertSoftly(softly -> {
                softly.assertThat(LottoRank.FIRST.getMatchCount()).isEqualTo(6);
                softly.assertThat(LottoRank.SECOND.getMatchCount()).isEqualTo(5);
                softly.assertThat(LottoRank.THIRD.getMatchCount()).isEqualTo(5);
                softly.assertThat(LottoRank.FOURTH.getMatchCount()).isEqualTo(4);
                softly.assertThat(LottoRank.FIFTH.getMatchCount()).isEqualTo(3);
                softly.assertThat(LottoRank.MISS.getMatchCount()).isZero();
            });
        }

        @Test
        void 보너스_번호_일치_여부를_정확히_반환한다() {
            assertSoftly(softly -> {
                softly.assertThat(LottoRank.FIRST.hasBonusMatch()).isFalse();
                softly.assertThat(LottoRank.SECOND.hasBonusMatch()).isTrue();
                softly.assertThat(LottoRank.THIRD.hasBonusMatch()).isFalse();
                softly.assertThat(LottoRank.FOURTH.hasBonusMatch()).isFalse();
                softly.assertThat(LottoRank.FIFTH.hasBonusMatch()).isFalse();
                softly.assertThat(LottoRank.MISS.hasBonusMatch()).isFalse();
            });
        }
    }
}
