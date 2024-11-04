package lotto.repository;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.domain.WinNum;

import static org.assertj.core.api.Assertions.assertThat;

class WinNumReposioryTest {
	private WinNumRepository winNumRepository;

    @BeforeEach
    void setUp() {
        winNumRepository = WinNumRepositoryImpl.getInstance();
    }

    @DisplayName("당첨 번호를 저장하고 조회")
    @Test
    void save_and_find() {
        WinNum winNum = WinNum.of(List.of(1, 2, 3, 4, 5, 6), 7);

        winNumRepository.save(winNum);

        WinNum foundWinNum = winNumRepository.find();
        assertThat(foundWinNum).isEqualTo(winNum);
    }
}
