package lotto.application.prize.service;

import static lotto.application.prize.message.Message.UNVALID_PRIZE_ID;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.Prize;
import lotto.application.prize.domain.PrizeNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.prize.dto.PrizeResponse;
import lotto.application.prize.repository.PrizeReadRepository;
import lotto.application.prize.repository.PrizeWriteRepository;
import lotto.application.ticket.domain.ticket.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PrizeReadService 테스트")
class PrizeReadServiceTest {

    private Prize createTestPrize(Long id) {
        WinnerNumbers winnerNumbers = WinnerNumbers.of(
                Lotto.of(List.of(1, 2, 3, 4, 5, 6))
        );
        BonusNumber bonusNumber = BonusNumber.of(7, winnerNumbers.getLotto());

        return Prize.of(id, PrizeNumber.of(winnerNumbers, bonusNumber));
    }

    @Test
    @DisplayName("존재하는 ID로 조회 성공")
    void ID로_조회_성공() {
        // given
        PrizeWriteRepository writeRepository = new PrizeWriteRepository();
        PrizeReadRepository readRepository = new PrizeReadRepository();
        PrizeReadService service = new PrizeReadService(readRepository);

        Prize prize = createTestPrize(1L);
        writeRepository.save(prize);

        // when
        PrizeResponse response = service.getPrize(1L);

        // then
        assertThat(response).isNotNull();
    }

    @DisplayName("없는 ID로 조회시 예외 발생")
    @Test
    void 없는_ID_조회시_예외발생() {

        // given
        PrizeReadRepository repository = new PrizeReadRepository();
        PrizeReadService service = new PrizeReadService(repository);

        // expect
        assertThatThrownBy(() -> service.getPrize(999L))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(UNVALID_PRIZE_ID);
    }

}
