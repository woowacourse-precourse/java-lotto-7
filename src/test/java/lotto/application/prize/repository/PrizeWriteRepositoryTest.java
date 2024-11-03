package lotto.application.prize.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.Prize;
import lotto.application.prize.domain.PrizeNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.ticket.domain.ticket.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PrizeWriteRepository 테스트")
class PrizeWriteRepositoryTest {

    private Prize createPrize(Long id) {
        return Prize.of(id, createPrizeNumber());
    }

    private PrizeNumber createPrizeNumber() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        return new PrizeNumber(
                WinnerNumbers.of(lotto),
                BonusNumber.of(7, lotto)
        );
    }

    @BeforeEach
    void setUp() {
        PrizeCommonStorage.clear();
    }

    @DisplayName("Prize 저장 성공")
    @Test
    void Prize_저장_성공() {
        // given
        PrizeWriteRepository repository = new PrizeWriteRepository();
        Prize prize = createPrize(1L);

        // when
        Long savedId = repository.save(prize);

        // then
        assertThat(savedId).isEqualTo(1L);
    }

}
