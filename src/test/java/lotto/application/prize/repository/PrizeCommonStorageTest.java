package lotto.application.prize.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.Prize;
import lotto.application.prize.domain.PrizeNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.ticket.domain.ticket.Lotto;
import lotto.application.ticket.repository.TicketCommonStorage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PrizeCommonStorage 테스트")
class PrizeCommonStorageTest {


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
        TicketCommonStorage.clear();
    }


    @DisplayName("저장소 인스턴스는 항상 동일현")
    @Test
    void 저장소_인스턴스_항상_동일() {
        // when
        ConcurrentHashMap<Long, Prize> repository1 = PrizeCommonStorage.getPrizeCommonStorage();
        ConcurrentHashMap<Long, Prize> repository2 = PrizeCommonStorage.getPrizeCommonStorage();

        // then
        assertThat(repository1).isSameAs(repository2);
    }

    @DisplayName("저장소 초기화 성공")
    @Test
    void 저장소_초기화_성공() {
        // given
        ConcurrentHashMap<Long, Prize> repository = PrizeCommonStorage.getPrizeCommonStorage();
        repository.put(1L, createPrize(1L));

        // when
        PrizeCommonStorage.clear();

        // then
        assertThat(repository).isEmpty();
    }

}
