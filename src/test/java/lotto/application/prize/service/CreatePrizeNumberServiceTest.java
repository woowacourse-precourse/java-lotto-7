package lotto.application.prize.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.application.prize.domain.PrizeNumber;
import lotto.application.ticket.domain.ticket.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("CreatePrizeNumberService 테스트")
class CreatePrizeNumberServiceTest {

    @DisplayName("당첨 번호와 보너스 번호로 PrizeNumber 생성 성공")
    @Test
    void 당첨번호와_보너스번호로_PrizeNumber_생성성공() {
        // given
        CreatePrizeNumberService service = new CreatePrizeNumberService();
        Lotto winLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int bonusNum = 7;

        // when
        PrizeNumber result = service.execute(winLotto, bonusNum);

        // then
        Assertions.assertThat(result).isNotNull();
    }

    @DisplayName("잘못된 보너스 번호(로또숫자범위 밖)로 생성 시도시 예외 발생")
    @Test
    void 잘못된_보너스번호_로또숫자범위밖으로_생성시도시_예외발생() {
        // given
        CreatePrizeNumberService service = new CreatePrizeNumberService();
        Lotto winLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int invalidBonusNum = 999;

        // when
        assertThatThrownBy(() -> service.execute(winLotto, invalidBonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("중복된 보너스 번호로 생성 시도시 예외 발생")
    @Test
    void 중복된_보너스_번호로_생성시도시_예외발생() {
        // given
        CreatePrizeNumberService service = new CreatePrizeNumberService();
        Lotto winLotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        int alreadyExistNumber = 1;

        // when
        assertThatThrownBy(() -> service.execute(winLotto, alreadyExistNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

}
