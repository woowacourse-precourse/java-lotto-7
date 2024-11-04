package lotto.dto;

import lotto.exception.LottoExceptionStatus;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class WinningLotteryDtoTest {

    @Test
    @DisplayName("올바른 당첨 로또 번호 입력")
    void validWinningLottery(){

        List<Integer> winningLottery = List.of(1, 2, 3, 4, 5, 6);

        WinningLotteryDto test = new WinningLotteryDto(winningLottery);

        assertThat(test.winningLottery()).isEqualTo(winningLottery);
    }

    @Test
    @DisplayName("중복된 숫자가 당첨 로또 번호로 입력")
    void invalidWinningLottery_shouldThrowNumberSizeException(){

        List<Integer> winningLottery = List.of(1, 2, 3, 4, 6, 6);

        assertThatThrownBy(() -> new WinningLotteryDto(winningLottery))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionStatus.INVALID_WINNING_NUMBER_DUPLICATE.getMessage());
    }

    @Test
    @DisplayName("범위를 넘어선 당첨 번호 입력")
    void invalidWinningLottery_shouldThrowNumberRangeException(){

        List<Integer> winningLottery = List.of(1, 2, 3, 4, 6, 100);


        assertThatThrownBy(() -> new WinningLotteryDto(winningLottery))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionStatus.INVALID_WINNING_NUMBER_RANGE.getMessage());
    }

}
