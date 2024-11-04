package lotto.application.prize.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.application.common.IdGenerator;
import lotto.application.prize.repository.PrizeWriteRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PrizeWriteService 테스트")
class PrizeWriteServiceTest {

    @DisplayName("당첨 정보 생성 및 저장 성공")
    @Test
    void 당첨_정보_생성_및_저장_성공() {
        // given
        CreatePrizeNumberService createPrizeNumberService = new CreatePrizeNumberService();
        PrizeWriteRepository repository = new PrizeWriteRepository();
        IdGenerator idGenerator = new PrizeIdGenerator();

        PrizeWriteService service = new PrizeWriteService(
                createPrizeNumberService,
                repository,
                idGenerator
        );

        List<Integer> winNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 7;

        // when
        Long savedId = service.create(winNums, bonusNum);

        // then
        Assertions.assertThat(savedId).isEqualTo(1L);

    }

    @DisplayName("잘못된 당첨 번호(중복 로또 숫자포함)로 생성 시도시 예외 발생")
    @Test
    void 잘못된_당첨번호_중복로또숫자포함_으로_생성시도시_예외발생() {

        CreatePrizeNumberService createPrizeNumberService = new CreatePrizeNumberService();
        PrizeWriteRepository prizeWriteRepository = new PrizeWriteRepository();
        IdGenerator idGenerator = new PrizeIdGenerator();

        PrizeWriteService service = new PrizeWriteService(
                createPrizeNumberService,
                prizeWriteRepository,
                idGenerator
        );

        List<Integer> invalidWinNums = List.of(1, 2, 3, 4, 5, 5);
        int bonusNum = 10;

        // expect
        assertThatThrownBy(() -> service.create(invalidWinNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 중복될 수 없습니다.");
    }

    @DisplayName("잘못된 당첨 번호(로또범위 밖 숫자)로 생성 시도시 예외 발생")
    @Test
    void 잘못된_당첨번호_로또범위밖숫자로_생성시도시_예외발생() {

        CreatePrizeNumberService createPrizeNumberService = new CreatePrizeNumberService();
        PrizeWriteRepository prizeWriteRepository = new PrizeWriteRepository();
        IdGenerator idGenerator = new PrizeIdGenerator();

        PrizeWriteService service = new PrizeWriteService(
                createPrizeNumberService,
                prizeWriteRepository,
                idGenerator
        );

        List<Integer> invalidWinNums = List.of(1, 2, 3, 4, 5, 100);
        int bonusNum = 10;

        // expect
        assertThatThrownBy(() -> service.create(invalidWinNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

    @DisplayName("잘못된 당첨 번호(중복 로또 숫자)로 생성 시도시 예외 발생")
    @Test
    void 잘못된_보너스번호_중복로또숫자_으로_생성시도시_예외발생() {

        CreatePrizeNumberService createPrizeNumberService = new CreatePrizeNumberService();
        PrizeWriteRepository prizeWriteRepository = new PrizeWriteRepository();
        IdGenerator idGenerator = new PrizeIdGenerator();

        PrizeWriteService service = new PrizeWriteService(
                createPrizeNumberService,
                prizeWriteRepository,
                idGenerator
        );

        List<Integer> invalidWinNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 6;

        // expect
        assertThatThrownBy(() -> service.create(invalidWinNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
    }

    @DisplayName("잘못된 당첨 번호(로또 숫자 범위 밖)로 생성 시도시 예외 발생")
    @Test
    void 잘못된_보너스번호_로또숫자범위밖_으로_생성시도시_예외발생() {

        CreatePrizeNumberService createPrizeNumberService = new CreatePrizeNumberService();
        PrizeWriteRepository prizeWriteRepository = new PrizeWriteRepository();
        IdGenerator idGenerator = new PrizeIdGenerator();

        PrizeWriteService service = new PrizeWriteService(
                createPrizeNumberService,
                prizeWriteRepository,
                idGenerator
        );

        List<Integer> invalidWinNums = List.of(1, 2, 3, 4, 5, 6);
        int bonusNum = 100;

        // expect
        assertThatThrownBy(() -> service.create(invalidWinNums, bonusNum))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.");
    }

}
