package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.List;
import lotto.service.LottoResultService;
import lotto.util.InputHandler;
import lotto.validator.BonusNumberValidator;
import lotto.validator.CommaValidator;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.view.InputView;
import lotto.view.OutputView;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;


@DisplayName("Controller 클래스 테스트")
public class LottoControllerTest {

    private LottoController lottoController;

    @BeforeEach
    void setUp() {
        lottoController = new LottoController(
            new LottoResultService(),
            new LottoValidator(new DefaultRangeValidator(), new DefaultDuplicateValidator()),
            new BonusNumberValidator(new DefaultRangeValidator()),
            new InputView(), new OutputView()
        );
    }

    @AfterEach
    void tearDown() {
        Console.close();
    }

    @Test
    void 구입금액이_1000원_단위가_아닐_때_예외가_발생한다() {
        int purchasePrice = 10500;
        assertThatThrownBy(() -> PurchaseAmountValidator.validate(purchasePrice))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 구입 금액은 1,000원 단위로만 가능합니다.");
    }

    @Test
    void 연속된_쉼표가_입력된_경우_예외가_발생한다() {
        String inputWinningNumber = "1,,2,3,4,5,6";
        assertThatThrownBy(() -> CommaValidator.validate(inputWinningNumber))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 입력에 쉼표가 연속적으로 입력되었습니다.");
    }

    @Test
    void 입력_당첨_번호를_콤마로_분리한다() {
        List<String> expectedList = Arrays.asList("1", "2", "3", "4", "5", "6");
        String input = "1,2,3,4,5,6";
        List<String> winningNumbers = InputHandler.splitByComma(input);
        assertEquals(expectedList, winningNumbers);
    }

    @Test
    void 문자열_리스트를_Integer_리스트로_변환한다() {
        List<Integer> expectedList = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<String> stringList = Arrays.asList("1", "2", "3", "4", "5", "6");
        List<Integer> integerList = InputHandler.stringListToIntList(stringList);
        assertEquals(expectedList, integerList);
    }

    @Test
    void 구매_금액을_잘못된_입력_형식으로_입력시_예외가_발생한다() {
        // Given
        String input = "wrong\n1,2,3,4,5,6\n7\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when & then
        assertThatThrownBy(() -> lottoController.setUp())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 입력 형식이 올바르지 않습니다.");

    }

    @Test
    void 당첨_로또를_잘못된_입력_형식으로_입력시_예외가_발생한다() {
        // Given
        String input = "3000\n1,wrong,3,4,5,6\n7\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when & then
        assertThatThrownBy(() -> lottoController.setUp())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 입력 형식이 올바르지 않습니다.");
    }

    @Test
    void 보너스_번호를_잘못된_입력_형식으로_입력시_예외가_발생한다() {
        // Given
        String input = "3000\n1,2,3,4,5,6\nwrong\n";
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when & then
        assertThatThrownBy(() -> lottoController.setUp())
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage("[ERROR] 입력 형식이 올바르지 않습니다.");
    }

}
