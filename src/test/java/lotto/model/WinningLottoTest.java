package lotto.model;

import lotto.dto.BonusNumberDto;
import lotto.dto.WinningLotteryDto;
import lotto.exception.LottoExceptionStatus;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

public class WinningLottoTest {

    @Test
    @DisplayName("당첨 번호와 보너스 번호가 올바름")
    void validWinningLottoAndBonusNumber(){
        Lotto winningLottoNumbers = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        WinningLotto winningLotto = WinningLotto.from(
                new WinningLotteryDto(winningLottoNumbers.getNumbers()),
                new BonusNumberDto(bonusNumber)
        );

        Assertions.assertThat(winningLotto.getWinningLotto().getNumbers()).isEqualTo(winningLottoNumbers.getNumbers());
        Assertions.assertThat(winningLotto.getBonusNumber()).isEqualTo(bonusNumber);

    }

    @Test
    @DisplayName("당첨번호와 보너스 번호가 중복됨")
    void inValidWinningLottoAndBonusNumber_duplicate(){
        Lotto winningLottoNumbers = new Lotto(List.of(1,2,3,4,5,7));
        int bonusNumber = 7;

        Assertions.assertThatThrownBy(() -> {
                    WinningLotto.from(
                            new WinningLotteryDto(winningLottoNumbers.getNumbers()),
                            new BonusNumberDto(bonusNumber)
                    );
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionStatus.INVALID_BONUS_NUMBER_DUPLICATE_WITH_WINNING.getMessage());

    }
}
