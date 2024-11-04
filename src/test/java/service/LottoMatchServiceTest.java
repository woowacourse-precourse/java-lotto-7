package service;

import lotto.service.LottoMatchService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoMatchServiceTest {

    @Test
    void calculateMatchCount_ShouldReturnCorrectMatchCount() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 7, 8, 9);

        // when
        int matchCount = LottoMatchService.calculateMatchCount(lottoNumbers, userNumbers);

        // then
        assertThat(matchCount).isEqualTo(3);
    }

    @Test
    void calculateMatchCount_ShouldReturnZero_WhenNoMatches() {
        // given
        List<Integer> lottoNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> userNumbers = Arrays.asList(7, 8, 9, 10, 11, 12);

        // when
        int matchCount = LottoMatchService.calculateMatchCount(lottoNumbers, userNumbers);

        // then
        assertThat(matchCount).isEqualTo(0);
    }

    @Test
    void calculateBonusMatch_ShouldReturnTrue_WhenMatchCountIsFiveAndContainsBonus() {
        // given
        int matchCount = 5;
        int bonusNumber = 7;
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 7);

        // when
        boolean hasBonusMatch = LottoMatchService.calculateBonusMatch(matchCount, bonusNumber, userNumbers);

        // then
        assertThat(hasBonusMatch).isTrue();
    }

    @Test
    void calculateBonusMatch_ShouldReturnFalse_WhenMatchCountIsFiveAndDoesNotContainBonus() {
        // given
        int matchCount = 5;
        int bonusNumber = 7;
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 8);

        // when
        boolean hasBonusMatch = LottoMatchService.calculateBonusMatch(matchCount, bonusNumber, userNumbers);

        // then
        assertThat(hasBonusMatch).isFalse();
    }

    @Test
    void calculateBonusMatch_ShouldReturnFalse_WhenMatchCountIsNotFive() {
        // given
        int matchCount = 4;
        int bonusNumber = 7;
        List<Integer> userNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        // when
        boolean hasBonusMatch = LottoMatchService.calculateBonusMatch(matchCount, bonusNumber, userNumbers);

        // then
        assertThat(hasBonusMatch).isFalse();
    }
}
