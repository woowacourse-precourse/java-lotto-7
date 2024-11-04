package lotto.model.domain;

import lotto.dto.LottoDto;
import lotto.dto.LottoWinningNumbersDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LottoWinningNumbersTest {

    @Test
    @DisplayName("유효한 당첨 번호와 보너스 번호가 주어지면 LottoWinningNumbers 객체가 성공적으로 생성된다")
    void givenValidWinningNumbersAndBonusNumber_whenCreatingLottoWinningNumbers_thenObjectIsCreated() {
        // given
        LottoWinningNumbersDto validDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );

        // when
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(validDto);

        // then
        assertNotNull(lottoWinningNumbers);
        assertEquals(List.of(1, 2, 3, 4, 5, 6), lottoWinningNumbers.getWinningNumbers().getNumbers());
        assertEquals(7, lottoWinningNumbers.getBonusNumber());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    void givenDuplicateBonusNumber_whenCreatingLottoWinningNumbers_thenThrowsException() {
        // given
        LottoWinningNumbersDto duplicateBonusDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                6
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(duplicateBonusDto));
    }

    @Test
    @DisplayName("getWinningNumbers 메서드는 올바른 당첨 번호 목록을 반환한다")
    void whenCallingGetWinningNumbers_thenReturnsCorrectWinningNumbers() {
        // given
        LottoWinningNumbersDto validDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(validDto);

        // when
        Lotto resultWinningNumbers = lottoWinningNumbers.getWinningNumbers();

        // then
        assertEquals(List.of(1, 2, 3, 4, 5, 6), resultWinningNumbers.getNumbers());
    }

    @Test
    @DisplayName("getBonusNumber 메서드는 올바른 보너스 번호를 반환한다")
    void whenCallingGetBonusNumber_thenReturnsCorrectBonusNumber() {
        // given
        LottoWinningNumbersDto validDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                7
        );
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(validDto);

        // when
        int resultBonusNumber = lottoWinningNumbers.getBonusNumber();

        // then
        assertEquals(7, resultBonusNumber);
    }

    @Test
    @DisplayName("보너스 번호가 45를 초과하면 예외가 발생한다")
    void givenBonusNumberGreaterThan45_whenCreatingLottoWinningNumbers_thenThrowsException() {
        // given
        LottoWinningNumbersDto outOfRangeBonusDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                46
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(outOfRangeBonusDto));
    }

    @Test
    @DisplayName("보너스 번호가 0 이하이면 예외가 발생한다")
    void givenBonusNumberLessThan1_whenCreatingLottoWinningNumbers_thenThrowsException() {
        // given
        LottoWinningNumbersDto outOfRangeBonusDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6)),
                0
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(outOfRangeBonusDto));
    }

    @Test
    @DisplayName("로또 번호가 6개가 아닐 때 예외가 발생한다")
    void givenInvalidNumberOfWinningNumbers_whenCreatingLottoWinningNumbers_thenThrowsException() {
        // given
        LottoWinningNumbersDto invalidCountDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5)),
                7
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(invalidCountDto));

        // given
        LottoWinningNumbersDto extraCountDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5, 6, 7)),
                8
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(extraCountDto));
    }

    @Test
    @DisplayName("로또 번호가 1~45 범위를 벗어날 때 예외가 발생한다")
    void givenOutOfRangeWinningNumbers_whenCreatingLottoWinningNumbers_thenThrowsException() {
        // given
        LottoWinningNumbersDto zeroNumberDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(0, 2, 3, 4, 5, 6)),
                7
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(zeroNumberDto));

        // given
        LottoWinningNumbersDto overNumberDto = new LottoWinningNumbersDto(
                new LottoDto(List.of(1, 2, 3, 4, 5, 46)),
                7
        );

        // when & then
        assertThrows(IllegalArgumentException.class, () -> new LottoWinningNumbers(overNumberDto));
    }
}