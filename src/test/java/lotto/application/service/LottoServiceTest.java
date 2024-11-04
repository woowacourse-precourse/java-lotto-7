package lotto.application.service;


import lotto.domain.generator.LottoNumberGenerator;
import lotto.domain.model.Lotto;
import lotto.domain.model.LottoTickets;
import lotto.infrastructure.repository.LottoRepositoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LottoServiceTest {

    private LottoNumberGenerator numberGenerator;
    private LottoRepositoryImpl lottoRepository;
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        numberGenerator = new LottoNumberGenerator() {
            @Override
            public List<Integer> generate() {
                return Arrays.asList(1, 2, 3, 4, 5, 6);
            }
        };
        lottoRepository = new LottoRepositoryImpl();
        lottoService = new LottoService(numberGenerator, lottoRepository);
    }

    @Test
    @DisplayName("로또 티켓 구매 후 티켓이 저장소에 저장되는지 테스트")
    void purchaseLotto_shouldGenerateAndSaveLottoTickets() {
        // Given
        int purchaseAmount = 5000; // 구매 금액
        int expectedTicketCount = purchaseAmount / 1000;

        // When
        lottoService.purchaseLotto(purchaseAmount);

        // Then
        LottoTickets savedTickets = lottoRepository.findAll();
        assertNotNull(savedTickets);
        assertEquals(expectedTicketCount, savedTickets.getTickets().size());
    }

    @Test
    @DisplayName("저장소에서 저장된 로또 티켓을 정상적으로 반환하는지 테스트")
    void getLottoTicketsFromRepository_shouldReturnSavedLottoTickets() {
        // Given
        List<Lotto> tickets = Arrays.asList(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));
        LottoTickets expectedLottoTickets = new LottoTickets(tickets);
        lottoRepository.save(expectedLottoTickets);

        // When
        LottoTickets actualLottoTickets = lottoService.getLottoTicketsFromRepository();

        // Then
        assertEquals(expectedLottoTickets, actualLottoTickets);
    }
}
