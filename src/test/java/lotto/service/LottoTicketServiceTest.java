package lotto.service;

import lotto.constant.LottoValueConstant;
import lotto.repository.InMemoryLottoRepository;
import lotto.repository.LottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LottoTicketServiceTest {

    private LottoTicketService lottoTicketService;
    private LottoRepository lottoRepository;

    @BeforeEach
    void setUp() {
        lottoTicketService = new LottoTicketService();
        lottoRepository = new InMemoryLottoRepository();
    }

    @Test
    void purchaseLottoTickets_validPrice_returnsTicketCount() {
        int price = 10000;
        int expectedTickets = price / LottoValueConstant.LOTTO_PRICE;

        int actualTickets = lottoTicketService.purchaseLottoTickets(price);

        assertEquals(expectedTickets, actualTickets);
    }

    @Test
    void generateLottoNumbers_generatesAndSavesTickets() {
        int numberOfLottos = 5;

        lottoTicketService.generateLottoNumbers(numberOfLottos, lottoRepository);

        List<List<Integer>> savedLottoNumbers = lottoRepository.getLottoNumbers();

        assertEquals(numberOfLottos, savedLottoNumbers.size());

        for (List<Integer> lottoNumbers : savedLottoNumbers) {
            for (int i = 1; i < lottoNumbers.size(); i++) {
                assert(lottoNumbers.get(i - 1) <= lottoNumbers.get(i));
            }
        }
    }

    @Test
    void getLottoNumbers_retrievesLottoNumbersFromRepository() {
        int numberOfLottos = 3;

        lottoTicketService.generateLottoNumbers(numberOfLottos, lottoRepository);

        List<List<Integer>> retrievedLottoNumbers = lottoTicketService.getLottoNumbers(lottoRepository);

        assertEquals(lottoRepository.getLottoNumbers(), retrievedLottoNumbers);
    }
}
