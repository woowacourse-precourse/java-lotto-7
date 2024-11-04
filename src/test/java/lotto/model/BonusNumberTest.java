package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusNumberTest {
    @Test
    @DisplayName("정상 기능 테스트")
    void 정상_기능_테스트() {
        // Given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        String givenBonusNumber = "7";
        Integer bonusNumbeInteger = Integer.parseInt(givenBonusNumber);
        // When
        BonusNumber bonusNumber = new BonusNumber(winningNumbers, bonusNumbeInteger);
        // Then
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }
}
