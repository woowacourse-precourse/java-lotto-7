package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoMachineTest {
    List<Integer> numbers;
    Integer bonusNumber;
    LottoMachine lottoMachine;

    @BeforeEach
    void setUp() {
        numbers = List.of(1, 2, 3, 4, 5, 6);
        bonusNumber = 7;
        lottoMachine = new LottoMachine(numbers, bonusNumber);
    }

    @Test
    @DisplayName("로또 번호 등록 시 중복된 숫자가 있어 예외 발생")
    void lottoMachineWithDuplicatedNumbers() {
        numbers = List.of(1, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new LottoMachine(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 등록 시 보너스 번호가 중복되어 예외 발생")
    void lottoMachineWithDuplicatedBonusNumber() {
        bonusNumber = 1;

        assertThatThrownBy(() -> new LottoMachine(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("로또 번호 등록 시 잘못된 범위의 숫자가 있어 예외 발생")
    void lottoMachineWithWrongNumberRange() {
        numbers = List.of(100, 1, 2, 3, 4, 5);

        assertThatThrownBy(() -> new LottoMachine(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("잘못된 범위의 보너스 번호로 예외 발생")
    void lottoMachineWithWrongRangeOfBonusNumber() {
        bonusNumber = 100;

        assertThatThrownBy(() -> new LottoMachine(numbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    @DisplayName("로또 번호 조회 성공")
    void getWinningNumber() {
        List<Integer> expected = numbers;

        List<Integer> actual = lottoMachine.getWinningNumber();

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @DisplayName("보너스 번호 조회 성공")
    void getBonusNumber() {
        Integer expected = bonusNumber;

        Integer actual = lottoMachine.getBonusNumber();

        assertThat(actual).isEqualTo(expected);
    }
}