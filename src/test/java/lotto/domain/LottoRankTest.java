package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.TestConstants.*;
import static lotto.common.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoRankTest {
    @Test
    @DisplayName("당첨된 숫자가 없을 경우에 UNRANK를 반환한다.")
    void unRankWithNoMatch () {
        // given
        Integer matchCount = NO_MATCH_COUNT;
        boolean bonusMatch = NO_BONUS_NUMBER;

        // when
        LottoRank lottoRank = LottoRank.findRank(matchCount, bonusMatch);

        // then
        assertEquals(lottoRank, LottoRank.UN_RANK);
    }

    @Test
    @DisplayName("당첨된 숫자가 3개일 경우에 MATCH_3_NUMBERS를 반환한다.")
    void unRankWithMatch3 () {
        // given
        Integer matchCount = MATCH_COUNT_3;
        boolean bonusMatch = NO_BONUS_NUMBER;

        // when
        LottoRank lottoRank = LottoRank.findRank(matchCount, bonusMatch);

        // then
        assertEquals(lottoRank, LottoRank.MATCH_3_NUMBERS);
    }

    @Test
    @DisplayName("당첨된 숫자가 4개일 경우에 MATCH_4_NUMBERS를 반환한다.")
    void unRankWithMatch4 () {
        // given
        Integer matchCount = MATCH_COUNT_4;
        boolean bonusMatch = NO_BONUS_NUMBER;

        // when
        LottoRank lottoRank = LottoRank.findRank(matchCount, bonusMatch);

        // then
        assertEquals(lottoRank, LottoRank.MATCH_4_NUMBERS);
    }

    @Test
    @DisplayName("당첨된 숫자가 5개일 경우에 MATCH_5_NUMBERS를 반환한다.")
    void unRankWithMatch5 () {
        // given
        Integer matchCount = MATCH_COUNT_5;
        boolean bonusMatch = NO_BONUS_NUMBER;

        // when
        LottoRank lottoRank = LottoRank.findRank(matchCount, bonusMatch);

        // then
        assertEquals(lottoRank, LottoRank.MATCH_5_NUMBERS);
    }

    @Test
    @DisplayName("당첨된 숫자가 5개이고 보너스 번호가 당첨된 경우에 MATCH_5_NUMBERS_WITH_BONUS_NUMBER를 반환한다.")
    void unRankWithMatch5AndBonusNumber () {
        // given
        Integer matchCount = MATCH_COUNT_5;
        boolean bonusMatch = HAS_BONUS_NUMBER;

        // when
        LottoRank lottoRank = LottoRank.findRank(matchCount, bonusMatch);

        // then
        assertEquals(lottoRank, LottoRank.MATCH_5_NUMBERS_WITH_BONUS_NUMBER);
    }

    @Test
    @DisplayName("당첨된 숫자가 6개일 경우에 MATCH_6_NUMBERS를 반환한다.")
    void unRankWithMatch6 () {
        // given
        Integer matchCount = MATCH_COUNT_6;
        boolean bonusMatch = NO_BONUS_NUMBER;

        // when
        LottoRank lottoRank = LottoRank.findRank(matchCount, bonusMatch);

        // then
        assertEquals(lottoRank, LottoRank.MATCH_6_NUMBERS);
    }


    @Test
    @DisplayName("당첨된 숫자가 6개보다 클 경우에 에러를 반환한다.")
    void upMatchCount () {
        // given
        Integer matchCount = UP_MATCH_COUNt;
        boolean bonusMatch = NO_BONUS_NUMBER;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoRank.findRank(matchCount, bonusMatch);
        });

        assertEquals(ERROR_PROMPT + INVALID_MATCH_COUNT, exception.getMessage());

    }

    @Test
    @DisplayName("당첨된 숫자가 0개보다 작을 경우에 에러를 반환한다.")
    void underMatchCount () {
        // given
        Integer matchCount = UP_MATCH_COUNt;
        boolean bonusMatch = NO_BONUS_NUMBER;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            LottoRank.findRank(matchCount, bonusMatch);
        });

        assertEquals(ERROR_PROMPT + INVALID_MATCH_COUNT, exception.getMessage());

    }

}