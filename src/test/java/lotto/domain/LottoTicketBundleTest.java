package lotto.domain;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTicketBundleTest {

    private LottoTicketBundle lottoTicketBundle;
    private WinningTicket winningTicket;

    @BeforeEach
    void setUp() {
        LottoGenerateStrategy fixedStrategy = new LottoGenerateStrategy() {
            private final List<List<Integer>> fixedNumbers = List.of(
                    List.of(8, 21, 23, 41, 42, 43),
                    List.of(3, 5, 11, 16, 32, 38),
                    List.of(7, 11, 16, 35, 36, 44),
                    List.of(1, 8, 11, 31, 41, 42),
                    List.of(13, 14, 16, 38, 42, 45),
                    List.of(7, 11, 30, 40, 42, 43),
                    List.of(2, 13, 22, 32, 38, 45),
                    List.of(1, 3, 5, 14, 22, 45)
            );

            private int index = 0;

            @Override
            public List<Integer> pickNumbers() {
                return fixedNumbers.get(index++);
            }
        };

        // from 메서드를 통해 LottoGroup을 초기화
        lottoTicketBundle = LottoTicketBundle.from(fixedStrategy, 8);

        List<Integer> choices = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;

        winningTicket = new WinningTicket(choices, bonusNumber);
    }

    @DisplayName("로또그룹 생성에 성공한다.")
    @Test
    void containsLottoList() {
        Assertions.assertThat(lottoTicketBundle).isNotNull();
    }

    @DisplayName("당첨 내역을 정확하게 반환한다.")
    @Test
    void getPrizes() {
        List<Prize> prizes = lottoTicketBundle.getPrizes(winningTicket);
        Assertions.assertThat(prizes)
                .hasSize(1)
                .containsExactly(
                        Prize.THREE
                ); // NONE 을 제외한 녀석들만 소유
    }

    @DisplayName("당첨 여부를 판별하여 당첨금 총합을 계산한다.")
    @Test
    void getTotalReward() {
        int winning = lottoTicketBundle.getTotalReward(winningTicket);
        Assertions.assertThat(winning).isEqualTo(5000);
    }

    @DisplayName("toString()은 출력 양식과 동일한 포맷의 String 을 리턴한다.")
    @Test
    void toStringTest() {
        String expected = """
                [8, 21, 23, 41, 42, 43]
                [3, 5, 11, 16, 32, 38]
                [7, 11, 16, 35, 36, 44]
                [1, 8, 11, 31, 41, 42]
                [13, 14, 16, 38, 42, 45]
                [7, 11, 30, 40, 42, 43]
                [2, 13, 22, 32, 38, 45]
                [1, 3, 5, 14, 22, 45]""";
        Assertions.assertThat(lottoTicketBundle).hasToString(expected);
    }
}
