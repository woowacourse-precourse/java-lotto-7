package lotto.service;

import lotto.model.Lotto;
import lotto.model.WinningLotto;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WinningLottoServiceTest {

    private final WinningLottoService winningLottoService = new WinningLottoService();

    @Test
    void 당첨_로또_생성_테스트() {
        String winningNumbersInput = "1, 2, 3, 4, 5, 6";
        int bonusNumber = 7;

        WinningLotto winningLotto = winningLottoService.create(winningNumbersInput, bonusNumber);

        assertEquals(List.of(1, 2, 3, 4, 5, 6), winningLotto.getWinningNumbers().getNumbers());
        assertEquals(bonusNumber, winningLotto.getBonusNumber());
    }

    @Test
    void 유효한_문자열_입력으로_로또_객체_생성() {
        String input = "1, 2, 3, 4, 5, 6";
        Lotto lotto = winningLottoService.parseLotto(input);

        assertEquals(List.of(1, 2, 3, 4, 5, 6), lotto.getNumbers());
    }

    @Test
    void 숫자가_아닌_값이_포함된_입력_예외_확인() {
        String invalidInput = "1, 2, a, 4, 5, 6";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningLottoService.parseLotto(invalidInput)
        );
        assertEquals("[ERROR] 숫자가 아닌 값이 포함되어있습니다.", exception.getMessage());
    }

    @Test
    void 보너스_번호_중복_예외_확인() {
        String winningNumbersInput = "1, 2, 3, 4, 5, 6";
        int duplicateBonusNumber = 6; // 당첨 번호와 중복되는 보너스 번호

        // 보너스 번호가 중복될 때 예외가 발생하는지 확인
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningLottoService.create(winningNumbersInput, duplicateBonusNumber)
        );
        assertEquals("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.", exception.getMessage());
    }

    @Test
    void 유효하지_않은_숫자_범위_예외_확인() {
        String invalidInput = "1, 2, 3, 4, 5, 46"; // 범위를 벗어난 숫자

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () ->
                winningLottoService.parseLotto(invalidInput)
        );
        assertEquals("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.", exception.getMessage());
    }
}
