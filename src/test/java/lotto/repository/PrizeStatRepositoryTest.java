package lotto.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.PrizeStat;

class PrizeStatRepositoryTest {
	private PrizeStatRepository prizeStatRepository;

    @BeforeEach
    void setUp() {
        prizeStatRepository = PrizeStatRepositoryImpl.getInstance();
    }

    @DisplayName("당첨 통계를 저장하고 조회")
    @Test
    void save_and_find() {
        PrizeStat prizeStat = PrizeStat.getInstance();

        prizeStatRepository.save(prizeStat);

        PrizeStat foundPrizeStat = prizeStatRepository.find();
        assertThat(foundPrizeStat).isEqualTo(prizeStat);
    }
}
