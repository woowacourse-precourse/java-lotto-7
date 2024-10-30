package lotto;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoGroupTest {

    private LottoGroup lottoGroup;
    private List<Lotto> lottoList;

    @BeforeEach
    void setUp() {
        lottoList = List.of(
                new Lotto(List.of(8, 21, 23, 41, 42, 43)),
                new Lotto(List.of(3, 5, 11, 16, 32, 38)),
                new Lotto(List.of(7, 11, 16, 35, 36, 44)),
                new Lotto(List.of(1, 8, 11, 31, 41, 42)),
                new Lotto(List.of(13, 14, 16, 38, 42, 45)),
                new Lotto(List.of(7, 11, 30, 40, 42, 43)),
                new Lotto(List.of(2, 13, 22, 32, 38, 45)),
                new Lotto(List.of(1, 3, 5, 14, 22, 45))
        );

        lottoGroup = new LottoGroup(lottoList);
    }

    // TODO : 로또그룹 객체에 getter 가 필요하다면 테스트한다.

    @DisplayName("로또그룹 생성에 성공한다.")
    @Test
    void containsLottoList() {
        Assertions.assertThat(lottoGroup).isNotNull();
    }

    @DisplayName("당첨 내역을 정확하게 반환한다.")
    @Test
    void getPrizes() {
        List<Integer> choices = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        List<Prize> prizes = lottoGroup.getPrizes(choices, bonusNumber);
        Assertions.assertThat(prizes)
                .hasSize(lottoList.size()) // lottoList 사이즈와 동일
                .containsExactly(
                        Prize.NONE, Prize.NONE, Prize.NONE, Prize.NONE, Prize.NONE, Prize.NONE, Prize.NONE, Prize.THREE
                ); // 마지막 녀석만 3등에 당첨
    }

    @DisplayName("당첨 여부를 판별하여 당첨금 총합을 계산한다.")
    @Test
    void getTotalReward() {
        List<Integer> choices = List.of(1, 2, 3, 4, 5, 6);
        int bonusNumber = 7;
        int winning = lottoGroup.getTotalReward(choices, bonusNumber);
        Assertions.assertThat(winning).isEqualTo(5000);
    }
}
