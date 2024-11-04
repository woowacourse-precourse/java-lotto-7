package lotto.service;

import lotto.repository.LottoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LotteryServiceTest {

    private final LottoRepository lottoRepository = LottoRepository.getInstance();

    @BeforeEach
    void setUp() {
        lottoRepository.findAllLottos().clear();
    }

    @Test
    void buyLotto() {
    }

    @Test
    void confirmWinnings() {
    }
}