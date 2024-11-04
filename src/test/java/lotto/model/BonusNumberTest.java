package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.enums.BonusNumberErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {

    @Test
    void BonusNumber_생성_테스트() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String rawInput = "39";
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, rawInput);

        // when
        int result = bonusNumber.getBonusNumber();

        // then
        assertThat(result).isEqualTo(39);
    }

    @Test
    void getBonusNumber_보너스_번호_반환() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String rawInput = "39";
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, rawInput);

        // when
        int result = bonusNumber.getBonusNumber();

        // then
        assertThat(result).isEqualTo(39);
    }

    @Test
    void validateIsNumber_숫자가_아닌_경우() {
        assertThatThrownBy(()-> {
            // given
            WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
            String rawInput = "a";

            // when
            BonusNumber bonusNumber = new BonusNumber(winningNumbers, rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusNumberErrorMessage.NOT_NUMBER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void validateIsElementInRange_범위를_벗어난_경우(String rawInput) {
        assertThatThrownBy(()-> {
            // given
            WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");

            // when
            BonusNumber bonusNumber = new BonusNumber(winningNumbers, rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusNumberErrorMessage.INVALID_NUMBER_RANGE.getMessage());
    }

    @Test
    void validateIsNotDuplicate_보너스_번호가_당첨번호와_중복_경우() {
        assertThatThrownBy(()-> {
            // given
            WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
            String rawInput = "1";

            // when
            BonusNumber bonusNumber = new BonusNumber(winningNumbers, rawInput);

            // then
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BonusNumberErrorMessage.DUPLICATE_NUMBER.getMessage());
    }

}