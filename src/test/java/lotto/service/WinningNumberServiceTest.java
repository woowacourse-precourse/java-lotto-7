package lotto.service;

import lotto.enums.ExceptionMessage;
import lotto.model.Lotto;
import lotto.model.WinningNumbers;
import lotto.validator.BonusValidator;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class WinningNumberServiceTest {
    private WinningNumberService winningNumberService;
    private LottoValidator lottoValidator;
    private BonusValidator bonusValidator;
    @BeforeEach
    void setup(){
        lottoValidator = new LottoValidator();
        bonusValidator = new BonusValidator();
        winningNumberService = new WinningNumberService(lottoValidator,bonusValidator);

    }
    @DisplayName("유효한 당첨번호와 보너스 번호로 WinningNumber를 생성한다.")
    @Test
    void createWinningNumbers_success(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 7;

        WinningNumbers winningNumbers = winningNumberService.createWinningNumbers(lotto, bonusNumber);
        assertThat(winningNumbers).isNotNull();
        assertThat(winningNumbers.getWinningNumbers()).containsExactly(1,2,3,4,5,6);
        assertThat(winningNumbers.getBonusNumber()).isEqualTo(7);
    }

    @DisplayName("당첨번호와 보너스 번호는 중복될 수 없다.")
    @Test
    void createWinningNumbers_throwsException(){
        Lotto lotto = new Lotto(List.of(1,2,3,4,5,6));
        int bonusNumber = 6;

        assertThatThrownBy(() ->  winningNumberService.createWinningNumbers(lotto, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ExceptionMessage.INVALID_BONUS_NUMBER.getMessage());
    }

}