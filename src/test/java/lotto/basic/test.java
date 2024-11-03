package lotto.basic;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.*;
import lotto.service.LottoService;
import lotto.view.InputViewImpl;
import lotto.view.OutputViewImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class test {

    @AfterEach
    void closeConsole() {
        Console.close();
    }

    @Test
    void 금액_입력_테스트() {
        // given
        InputViewImpl inputView = new InputViewImpl();
        Money expectInput = new Money("14000");

        // when
        System.setIn(new ByteArrayInputStream(String.valueOf(expectInput.value())
                .getBytes()));
        Money actualInput = inputView.getMoney();

        // then
        assertThat(actualInput.value()).isEqualTo(expectInput.value());
    }

    @Test
    void 로또_발행_개수_테스트() {
        // given
        Money money = new Money("6000");
        FortuneMachine fortuneMachine = new FortuneMachine();

        // when
        Lottos actualValues = fortuneMachine.buyLotto(money);

        // then
        assertThat(actualValues.size()).isEqualTo(6);
    }

    @Test
    void 당첨_번호_입력_테스트() {
        // given
        List<Integer> expectedValues = List.of(1, 2, 3, 4, 5, 6); // 정수형으로 변경

        // when
        WinningNumbers actualInput = new WinningNumbers("1,2,3,4,5,6");

        // then
        assertThat(actualInput.stream().toList())
                .isEqualTo(expectedValues); // getNumbers() 메서드 사용
    }


    @Test
    void 당첨_번호_오류_공백_입력_테스트() {
        // given
        String errorInput = "1,2,3,4, ,6";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 당첨_번호_오류_음수_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,-1,6";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 당첨_번호_오류_문자_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,일,6";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 당첨_번호_오류_짧은_길이_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,5";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 당첨_번호_오류_긴_길이_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,5,6,7";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 당첨_번호_오류_범위_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,5,46";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }

    @Test
    void 당첨_번호_오류_중복_입력_테스트() {
        // given
        String errorInput = "1,2,3,4,5,1";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new WinningNumbers(errorInput));
    }


    @Test
    void 보너스_번호_입력_테스트() {
        // given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String correctInput = "12";
        Integer expectedValues = 12;

        // when
        BonusNumber bonusNumber = new BonusNumber(correctInput, winningNumbers);

        // then
        assertThat(bonusNumber.value())
                .isEqualTo(expectedValues);
    }

    @Test
    void 보너스_번호_공백_입력_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String errorInput = "";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(errorInput, winningNumbers));
    }

    @Test
    void 보너스_번호_음수_입력_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String errorInput = "-1";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(errorInput, winningNumbers));
    }

    @Test
    void 보너스_번호_문자_입력_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String errorInput = "일";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(errorInput, winningNumbers));
    }

    @Test
    void 보너스_번호_중복_입력_테스트() {
        //given
        WinningNumbers winningNumbers = new WinningNumbers("1,2,3,4,5,6");
        String errorInput = "1";

        // when

        // then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new BonusNumber(errorInput, winningNumbers));
    }


    @Test
    void 번호_맞추기_당첨번호_테스트() {
        // given
        InputViewImpl inputView = new InputViewImpl();
        OutputViewImpl outputView = new OutputViewImpl();
        LottoService lottoService = new LottoService(inputView, outputView);
        WinningNumbers winningNumbers = new WinningNumbers("1, 2, 3, 4, 5, 6");
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 45));
        Integer expectedValues = 3;

        // when
        Integer actualValue = lottoService.countWinningNumber(winningNumbers, lotto);

        // then
        assertThat(actualValue)
                .isEqualTo(expectedValues);
    }

    @Test
    void 번호_맞추기_보너스번호_테스트() {
        // given
        InputViewImpl inputView = new InputViewImpl();
        OutputViewImpl outputView = new OutputViewImpl();
        LottoService lottoService = new LottoService(inputView, outputView);
        WinningNumbers winningNumbers = new WinningNumbers("31, 32, 33, 34, 35, 36");
        BonusNumber bonusNumber = new BonusNumber("7", winningNumbers);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 43, 44, 7));
        Integer expectedValues = 1;

        // when
        Integer actualValue = lottoService.countBonusNumber(bonusNumber.value(), lotto);

        // then
        assertThat(actualValue)
                .isEqualTo(expectedValues);
    }

    @Test
    void 수익률_계산_테스트() {
        // given
        Money money = new Money("1000");
        Result result = Result.FIFTH;
        double expectedValues = 500.0;

        // when
        double actualValue = result.getROI(money);

        // then
        assertThat(actualValue).isEqualTo(expectedValues);
    }


}
