package lotto.application.prize.repository;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;
import lotto.application.prize.domain.BonusNumber;
import lotto.application.prize.domain.Prize;
import lotto.application.prize.domain.PrizeNumber;
import lotto.application.prize.domain.WinnerNumbers;
import lotto.application.ticket.domain.ticket.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PrizeReadRepository 테스트")
class PrizeReadRepositoryTest {

    private PrizeWriteRepository writeRepository;
    private PrizeReadRepository readRepository;

    private Prize createPrize(Long id) {
        return Prize.of(id, createPrizeNumber());
    }

    private PrizeNumber createPrizeNumber() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        WinnerNumbers winnerNumbers = WinnerNumbers.of(lotto);
        BonusNumber bonusNumber = BonusNumber.of(7, lotto);

        return PrizeNumber.of(winnerNumbers, bonusNumber);
    }


    @BeforeEach
    void setUp() {
        PrizeCommonStorage.clear();
        writeRepository = new PrizeWriteRepository();
        readRepository = new PrizeReadRepository();
    }

    @DisplayName("Id로 Prize 단건조회 성공")
    @Test
    void Id로_Prize_단건조회_성공() {
        // given
        Prize prize = createPrize(1L);
        writeRepository.save(prize);

        // when
        Optional<Prize> result = readRepository.findById(1L);

        // then
        assertThat(result)
                .isPresent()
                .contains(prize);
    }

    @DisplayName("존재하지 않는 Id로 조회시 빈 Optional 반환")
    @Test
    void 존재하지않는_Id_조회시_빈_Optional반환() {
        // when
        Optional<Prize> result = readRepository.findById(999L);

        // then
        assertThat(result).isEmpty();
    }

    @DisplayName("다른 저장소 인스턴스에서 저장한 데이터 조회 가능")
    @Test
    void 다른_저장소_인스턴스에서_저장한_데이터_조회_가능() {
        // given
        PrizeWriteRepository writeRepository = new PrizeWriteRepository();
        PrizeReadRepository readRepository = new PrizeReadRepository();
        Prize prize = createPrize(1L);

        // when
        writeRepository.save(prize);
        Optional<Prize> result = readRepository.findById(1L);

        // then
        assertThat(result)
                .isPresent()
                .contains(prize);
    }

}
