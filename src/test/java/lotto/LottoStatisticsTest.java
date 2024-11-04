package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    private final LottoStatistics lottoStatistics = new LottoStatistics();;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @Test
    @DisplayName("총 수익률 계산 확인")
    void shouldCalculateTotalEarningRate() {
        // 테스트할 로또 티켓 리스트 생성
        List<Lotto> tickets = List.of(
                new Lotto(List.of(1, 2, 3, 4, 5, 6)), // 1등
                new Lotto(List.of(1, 2, 3, 4, 5, 7)), // 2등 (보너스 번호 일치)
                new Lotto(List.of(1, 2, 3, 4, 8, 9))  // 3등
        );

        Lotto winningNumbers = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;

        // 통계 계산
        lottoStatistics.calculateStatistics(tickets, winningNumbers, bonusNumber);

        // 투자금과 총 수익률 계산
        int totalInvestment = 3000; // 3개의 로또 구매
        lottoStatistics.getTotalPrize(totalInvestment); // 출력 내용을 캡처하기 위해 setUp에서 캡처 설정

        // 수익률 검증
        System.out.println(output());
        assertThat(output()).contains("총 수익률은 67668333.3%입니다."); // 실제 수익률 값은 계산에 따라 다를 수 있음
    }

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    public String output() {
        return outputStreamCaptor.toString().trim();
    }
}