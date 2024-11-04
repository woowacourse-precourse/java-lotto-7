package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.TestConstants.*;
import static lotto.common.Constants.*;
import static org.junit.jupiter.api.Assertions.*;

class WinningNumbersTest {
    @Test
    @DisplayName("6개의 중복되지 않는 숫자를 넣으면 당첨 숫자가 잘 생성된다.")
    void getWinningNumbers () {
        // given
        String rawWinningNumbers = VALID_WINNING_NUMBERS;

        // when
        WinningNumbers winningNumbers = new WinningNumbers(rawWinningNumbers);

        // then
        assertTrue(winningNumbers.compareNumbers(WINNING_NUMBERS));
    }

    @Test
    @DisplayName("당첨 숫자가 숫자가 아닐 경우 에러를 반환한다.")
    void winningNumbersIsNotNumber () {
        // given
        String rawWinningNumbers = INVALID_WINNING_NUMBERS;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_WINNING_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자 중 하나라도 1보다 작을 경우 에러를 반환한다.")
    void winningNumberIsUnderMax () {
        // given
        String rawWinningNumbers = UNDER_WINNING_NUMBERS_RANGE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_WINNING_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자 중 하나라도 45를 넘을 경우 에러를 반환한다.")
    void winningNumberIsUpperMax () {
        // given
        String rawWinningNumbers = UP_WINNING_NUMBERS_RANGE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_WINNING_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자의 개수가 6보다 작을 경우 에러를 반환한다.")
    void winningNumberSizeIsSmall () {
        // given
        String rawWinningNumbers = UNDER_WINNING_NUMBERS_SIZE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_LOTTO_SIZE, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자의 개수가 6보다 클 경우 에러를 반환한다.")
    void winningNumberSizeIsBig () {
        // given
        String rawWinningNumbers = UP_WINNING_NUMBERS_SIZE;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_LOTTO_SIZE, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자가 중복될 경우 에러를 반환한다.")
    void winningNumberSizeIsDuplicated () {
        // given
        String rawWinningNumbers = DUPLICATED_WINNING_NUMBERS;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            new WinningNumbers(rawWinningNumbers);
        });

        assertEquals(ERROR_PROMPT + INVALID_DUPLICATE_WINNING_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("당첨 숫자와 중복되지 않는 유효한 보너스 숫자를 넣으면 보너스 번호가 잘 생성된다.")
    void getBonusNumber () {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS);
        String rawBonusNumber = VALID_BONUS_NUMBER;

        // when
        winningNumbers.addBonusNumber(rawBonusNumber);

        // then
        assertTrue(winningNumbers.compareBonusNumber(BONUS_NUMBER));
    }

    @Test
    @DisplayName("보너스 숫자가 숫자가 아닐 경우 에러를 반환한다.")
    void BonusNumberIsNotNumber () {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS);
        String rawBonusNumber = BONUS_NUMBER_NOT_NUMERIC;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.addBonusNumber(rawBonusNumber);
        });

        assertEquals(ERROR_PROMPT + INVALID_BONUS_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("보너스 숫자가 1보다 작을 경우 에러를 반환한다.")
    void BonusNumberIsUnderMax () {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS);
        String rawBonusNumber = UNDER_BONUS_NUMBER;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.addBonusNumber(rawBonusNumber);
        });

        assertEquals(ERROR_PROMPT + INVALID_BONUS_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("보너스 숫자가 45를 넘을 경우 에러를 반환한다.")
    void BonusNumberIsUpperMax () {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS);
        String rawBonusNumber = UP_BONUS_NUMBER;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.addBonusNumber(rawBonusNumber);
        });

        assertEquals(ERROR_PROMPT + INVALID_BONUS_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("보너스 숫자가 당첨 숫자와 중복될 경우 에러를 반환한다.")
    void bonusNumberIsDuplicatedWithWinningNumbers () {
        // given
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS);
        String rawBonusNumber = DUPLICATED_BONUS_NUMBER;

        // when & then
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            winningNumbers.addBonusNumber(rawBonusNumber);
        });

        assertEquals(ERROR_PROMPT + INVALID_DUPLICATE_BONUS_NUMBER, exception.getMessage());
    }

    @Test
    @DisplayName("당첨된 랭크를 잘 반환한다.")
    void getLottoRank () {
        // given
        Lotto lotto = new Lotto(LOTTO_NUMBERS_WITH_MATCH_3);
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS);
        winningNumbers.addBonusNumber(VALID_BONUS_NUMBER);

        // when
        LottoRank lottoRank = winningNumbers.getLottoRank(lotto);

        // then
        assertEquals(LottoRank.MATCH_3_NUMBERS, lottoRank);

    }

    @Test
    @DisplayName("당첨된 랭크들을 잘 반환한다.")
    void getLottoRanks () {
        // given
        List<Lotto> lottos = List.of(
                new Lotto(LOTTO_NUMBERS_WITH_NO_MATCH),
                new Lotto(LOTTO_NUMBERS_WITH_MATCH_3),
                new Lotto(LOTTO_NUMBERS_WITH_MATCH_5_AND_BONUS_NUMBER)
        );

        Lottos savedLottos = new Lottos(lottos);
        WinningNumbers winningNumbers = new WinningNumbers(VALID_WINNING_NUMBERS);
        winningNumbers.addBonusNumber(VALID_BONUS_NUMBER);

        // when
        List<LottoRank> lottoRanks = winningNumbers.getLottoRanks(savedLottos);

        // then
        assertEquals(lottoRanks.size(), lottos.size());

        assertEquals(LottoRank.UN_RANK, lottoRanks.get(0));
        assertEquals(LottoRank.MATCH_3_NUMBERS, lottoRanks.get(1));
        assertEquals(LottoRank.MATCH_5_NUMBERS_WITH_BONUS_NUMBER, lottoRanks.get(2));
    }


}