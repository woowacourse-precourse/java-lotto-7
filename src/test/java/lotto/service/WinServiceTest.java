package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.dto.Lottos;
import lotto.enums.Win;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class WinServiceTest {

    private final List<Integer> DEFAULT_WIN_NUM = List.of(1, 2, 3, 4, 5, 6);
    private final Lottos lottos = new Lottos();
    private final WinService winService = new WinService(lottos);

    @Nested
    class 당첨_번호_입력은 {
        @Test
        void 중복된_번호가_있으면_예외처리() {
            List<Integer> winNum = List.of(1, 1, 2, 3, 4, 5);
            assertThatThrownBy(() -> winService.inputWinNum(winNum))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 당첨 번호에 중복된 번호가 있습니다.");
        }

        @Test
        void 범위에_벗어난_번호가_있으면_예외처리() {
            List<Integer> winNum = List.of(1, 2, 3, 4, 5, 999);
            assertThatThrownBy(() -> winService.inputWinNum(winNum))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 당첨 번호는 1부터 45까지만 가능합니다.");
        }
    }

    @Nested
    class 보너스_번호_입력은 {
        @BeforeEach
        void set_up() {
            winService.inputWinNum(DEFAULT_WIN_NUM);
        }

        @Test
        void 중복된_번호가_있으면_예외처리() {
            Integer bonusNum = 1;
            assertThatThrownBy(() -> winService.inputBonusNum(bonusNum))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호가 당첨 번호에 존재합니다.");
        }

        @Test
        void 범위에_벗어난_번호가_있으면_예외처리() {
            Integer bonusNum = 999;
            assertThatThrownBy(() -> winService.inputBonusNum(bonusNum))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 보너스 번호는 1부터 45까지만 가능합니다.");
        }
    }

    @Nested
    class 당첨_확인은 {
        @BeforeEach
        void set_up() {
            lottos.addLottos(new Lotto(DEFAULT_WIN_NUM));
            winService.inputWinNum(DEFAULT_WIN_NUM);
            winService.inputBonusNum(7);
            winService.checkLottosWin();
        }

        @Test
        void 리스트로_당첨_로또_개수를_반환한다() {
            List<Integer> result = winService.getLottosWin();

            // 리스트의 1등( get(0))에 1이 들어있음
            assertThat(result.get(Win.LOTTO_1ST.getRank())).isEqualTo(1);
        }

        @Test
        void 당첨_금액의_수익률을_반환한다() {
            Double result = winService.getWinningsRate();
            assertThat(result).isEqualTo(200000000.0);
        }
    }
}