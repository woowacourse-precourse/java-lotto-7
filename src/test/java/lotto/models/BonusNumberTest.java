package lotto.models;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.dto.BonusNumberRequestDTO;
import lotto.model.BonusNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {

    @Test
    @DisplayName("정확한 보너스 번호 객체를 생성한다.")
    public void bonusNumber() {
        // GIVEN
        BonusNumberRequestDTO request = new BonusNumberRequestDTO("5");

        // WHEN
        BonusNumber bonusNumber = new BonusNumber(request);

        // THEN
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(5);
    }

    @Test
    @DisplayName("보너스 번호의 범위를 초과한 경우, 예외를 발생시킨다.")
    public void bonusNumberRange() {
        // GIVEN
        BonusNumberRequestDTO request = new BonusNumberRequestDTO("0");

        // WHEN - THEN
        assertThatThrownBy(() -> new BonusNumber(request)).isInstanceOf(IllegalArgumentException.class);
    }
}
