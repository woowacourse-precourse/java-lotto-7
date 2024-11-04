package lotto.service;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.Lotto;
import lotto.domain.PrizeStat;
import lotto.domain.WinNum;

import lotto.repository.LottoRepository;
import lotto.repository.LottoRepositoryImpl;
import lotto.repository.WinNumRepository;
import lotto.repository.WinNumRepositoryImpl;

import static org.assertj.core.api.Assertions.assertThat;
import static lotto.prize.Prize.*;

class PrizeStatServiceTest {
	private PrizeStatService prizeStatService;
	private LottoRepository lottoRepository;
	private WinNumRepository winNumRepository;
	private int lottoCount;
	
	@BeforeEach
	void setUp() {
		prizeStatService = PrizeStatServiceImpl.getInstance();
		lottoRepository = LottoRepositoryImpl.getInstance();
		winNumRepository = WinNumRepositoryImpl.getInstance();
		
		List<Lotto> lottos = List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)),
								     new Lotto(List.of(7, 8, 9, 10, 11, 12)),
								     new Lotto(List.of(13, 14, 15, 16, 17, 18)),
								     new Lotto(List.of(19, 20, 21, 22, 23, 24)),
								     new Lotto(List.of(25, 26, 27, 28, 29, 30)),
								     new Lotto(List.of(31, 32, 33, 34, 35, 36)),
								     new Lotto(List.of(37, 38, 39, 40, 41, 42)),
								     new Lotto(List.of(43, 44, 45, 6, 7, 8)));

		lottoCount = lottos.size();
		
		// 3개 번호 일치 1개
		WinNum winNum = WinNum.of(List.of(1, 2, 3, 10, 20, 30), 13);
		
		lottoRepository.saveAll(lottos);
		winNumRepository.save(winNum);
	}
	
	@Test
	@DisplayName("당첨 통계 생성")
	void create_PrizeStatistics() {
		prizeStatService.create();
		PrizeStat prizeStat = prizeStatService.get();
		assertThat(prizeStat.getPrizeCounts().get(FIFTH)).isEqualTo(1);
		assertThat(prizeStat.getPrizeCounts().get(FOURTH)).isEqualTo(0);
	}
	
	@Test
	@DisplayName("저장된 당첨 통계 반환")
	void get_PrizeStatistics() {
		PrizeStat prizeStat = prizeStatService.get();
		assertThat(prizeStat.getPrizeCounts().get(FIFTH)).isEqualTo(1);
		assertThat(prizeStat.getPrizeCounts().get(FOURTH)).isEqualTo(0);
	}
	
	@Test
	@DisplayName("수익률 계산")
	void calculateEarningsRate() {
		BigDecimal earningsRate = prizeStatService.calculateEarningsRate(lottoCount);
		assertThat(earningsRate).isEqualTo(BigDecimal.valueOf(62.5));
	}
}
