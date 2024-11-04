package lotto.dto;

import lotto.exception.LottoExceptionStatus;
import lotto.properties.LottoProperties;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class BonusNumberDtoValidationTest {
    @Test
    @DisplayName("올바른 보너스 번호로 Dto 생성")
    void validPurchaseAmount() {
        // given
        int validBonusNumber = 10;

        // when
        BonusNumberDto bonusNumberDto = new BonusNumberDto(validBonusNumber);

        // then
        assertThat(bonusNumberDto.bonusNumber()).isEqualTo(validBonusNumber);
    }

    @Test
    @DisplayName("천원 단위가 아닌 구매 금액으로 Dto 생성 시 예외 발생")
    void invalidPurchaseAmount_shouldThrowException() {
        // given
        int invalidBonusNumber = LottoProperties.LOTTO_NUMBER_END + 1;

        // when & then
        assertThatThrownBy(() -> new BonusNumberDto(invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoExceptionStatus.INVALID_BONUS_NUMBER_RANGE.getMessage());
    }
}
