package lotto.application.prize.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.ticket.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("CreateBonusNumberService 테스트")
class CreateBonusNumberServiceTest {

    @Test
    @DisplayName("보너스 번호 생성 성공")
    void 보너스번호_생성_성공() {
        // given
        CreateBonusNumberService service = new CreateBonusNumberService();
        WinnerNumbers winnerNumbers = WinnerNumbers.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));

        // when
        BonusNumber bonusNumber = service.execute(winnerNumbers, 7);

        // then
        assertThat(bonusNumber.getValue()).isEqualTo(7);
    }

    @DisplayName("범위를 벗어난 보너스 번호로 생성시 실패")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46, 100})
    void 범위초과_보너스번호_생성실패(int invalidBonus) {

        // given
        CreateBonusNumberService service = new CreateBonusNumberService();
        WinnerNumbers winnerNumbers = WinnerNumbers.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));

        // then
        assertThatThrownBy(() -> service.execute(winnerNumbers, invalidBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("당첨 번호와 중복된 보너스 번호로 생성시 실패")
    @Test
    void 중복_보너스번호_생성실패() {

        // given
        CreateBonusNumberService service = new CreateBonusNumberService();
        WinnerNumbers winnerNumbers = WinnerNumbers.of(Lotto.of(List.of(1, 2, 3, 4, 5, 6)));
        int duplicateBonus = 1;

        // expect
        assertThatThrownBy(() -> service.execute(winnerNumbers, duplicateBonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}
