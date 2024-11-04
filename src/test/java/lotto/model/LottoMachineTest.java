package lotto.model;

import lotto.exception.ErrorMessage;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomUniqueNumbersInRangeTest;
import static org.junit.jupiter.api.Assertions.*;

class LottoMachineTest {
    @Test
    @DisplayName("생성에 성공한 경우")
    void 생성에_성공한_경우() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 10;
        LottoMachine lottoMachine = new LottoMachine();

        // when
        assertDoesNotThrow(() -> {
            lottoMachine.setWinner(nums);
            lottoMachine.setBonus(bonus);
        });

        // then
        assertEquals(0, lottoMachine.getLottoNums().size());
    }

    @Test
    @DisplayName("당첨 번호가 중복인 경우")
    void 당첨_번호가_중복인_경우() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 5);
        int bonus = 10;
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoException e = assertThrows(LottoException.class, () -> {
            lottoMachine.setWinner(nums);
            lottoMachine.setBonus(bonus);
        });

        // then
        assertEquals(ErrorMessage.EXIST_NUM.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복인 경우")
    void 보너스_번호가_로또_번호와_중복인_경우() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 1;
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoException e = assertThrows(LottoException.class, () -> {
            lottoMachine.setWinner(nums);
            lottoMachine.setBonus(bonus);
        });

        // then
        assertEquals(ErrorMessage.EXIST_NUM.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 6개로 이루어지지 않은 경우")
    void 당첨_번호가_6개로_이루어지지_않은_경우() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5);
        int bonus = 1;
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoException e = assertThrows(LottoException.class, () -> {
            lottoMachine.setWinner(nums);
            lottoMachine.setBonus(bonus);
        });

        // then
        assertEquals(ErrorMessage.NOT_SIX_NUM.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("당첨 번호가 범위 내 숫자가 아닌 경우")
    void 당첨_번호가_범위_내_숫자가_아닌_경우() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 60);
        int bonus = 1;
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoException e = assertThrows(LottoException.class, () -> {
            lottoMachine.setWinner(nums);
            lottoMachine.setBonus(bonus);
        });

        // then
        assertEquals(ErrorMessage.NOT_IN_RANGE.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("보너스 번호가 범위 내 숫자가 아닌 경우")
    void 보너스_번호가_범위_내_숫자가_아닌_경우() {
        // given
        List<Integer> nums = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 100;
        LottoMachine lottoMachine = new LottoMachine();

        // when
        LottoException e = assertThrows(LottoException.class, () -> {
            lottoMachine.setWinner(nums);
            lottoMachine.setBonus(bonus);
        });

        // then
        assertEquals(ErrorMessage.NOT_IN_RANGE.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("로또가 5개인 경우")
    void 로또가_5개인_경우() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> winnerNum = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 10;
        int money = 5000;

        // when
        lottoMachine.setWinner(winnerNum);
        lottoMachine.setBonus(bonus);
        lottoMachine.buyLotto(money);
        int lottoCount = lottoMachine.getLottoNums().size();

        // then
        assertEquals(5, lottoCount);
    }

    @Test
    @DisplayName("로또가 없는 경우")
    void 로또가_없는_경우() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> winnerNum = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 10;

        // when
        lottoMachine.setWinner(winnerNum);
        lottoMachine.setBonus(bonus);
        LottoException e = assertThrows(LottoException.class, lottoMachine::getResult);

        // then
        assertEquals(ErrorMessage.NOT_INIT_STATE.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("초기화가 안된 경우")
    void 초기화가_안된_경우() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> winnerNum = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 10;

        // when
        lottoMachine.buyLotto(5000);
        LottoException e = assertThrows(LottoException.class, lottoMachine::getResult);

        // then
        assertEquals(ErrorMessage.NOT_INIT_STATE.getMessage(), e.getMessage());
    }

    @Test
    @DisplayName("로또 결과 받기")
    void 로또_결과_받기() {
        // given
        LottoMachine lottoMachine = new LottoMachine();
        List<Integer> winnerNum = List.of(1, 2, 3, 4, 5, 6);
        int bonus = 10;
        int money = 5000;

        // when
        lottoMachine.setWinner(winnerNum);
        lottoMachine.setBonus(bonus);
        assertRandomUniqueNumbersInRangeTest(
                () -> {
                    lottoMachine.buyLotto(money);
                },
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 3, 7, 8, 9),
                List.of(1, 2, 3, 7, 8, 9)
        );

        List<List<Integer>> lottoNums = lottoMachine.getLottoNums();
        Result result = lottoMachine.getResult();
        String rate = result.getRate();

        // then
        assertEquals("500%", rate);
    }
}