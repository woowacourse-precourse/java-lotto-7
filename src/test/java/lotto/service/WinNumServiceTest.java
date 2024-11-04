package lotto.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinNum;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

class WinNumServiceTest {
	private WinNumService winNumService;
	
	@BeforeEach
	void setUp() {
		winNumService = WinNumServiceImpl.getInstance();
	}
	
	@Test
	@DisplayName("당첨 번호와 보너스 번호를 저장")
	void create_saveWinningNumbers() {
		List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
		int bonusNumber = 7;
		
		winNumService.create(winningNumbers, bonusNumber);
		
		WinNum winNum = winNumService.get();
		assertThat(winNum.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6);
		assertThat(winNum.getBonusNumber()).isEqualTo(7);
	}
	
	@Test
	@DisplayName("저장된 로또 번호 반환")
	void get_returnsWinningNumbers() {
		List<Integer> winningNumbers = List.of(11, 12, 13, 14, 15, 16);
		int bonusNumber = 17;
		
		winNumService.create(winningNumbers, bonusNumber);
		
		WinNum winNum = winNumService.get();
		assertThat(winNum.getNumbers()).containsExactly(11, 12, 13, 14, 15, 16);
		assertThat(winNum.getBonusNumber()).isEqualTo(17);
	}
}
