package lotto;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class LottoTest {
    @AfterEach
    void resetLottoEnum() {
        // 모든 enum 항목의 winnerCount를 초기화
        for (LottoEnum lottoEnum : LottoEnum.values()) {
            lottoEnum.reset();
        }
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
    @Test
    void 로또_번호가_1_에서_45_사이의_값이_아니면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 46)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 정상적인_로또_번호_입력시_정상_작동() {
        List<Integer> validNumbers = List.of(1, 2, 3, 4, 5, 6);

        assertThatNoException().isThrownBy(() -> new Lotto(validNumbers));
    }

    @Test
    void search() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        lotto.search(winningNumbers, bonus);

        assertThat(LottoEnum.sum()).isEqualTo(new BigDecimal(2000000000));
    }

    @Test
    void search2() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 7;

        lotto.search(winningNumbers, bonus);

        assertThat(LottoEnum.sum()).isEqualTo(new BigDecimal(2000000000));
    }





}