package lotto.controller.lottoController;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.io.OutputHandler;
import lotto.io.OutputParser;
import lotto.testUtil.testDouble.NumberPickerFake;
import lotto.testUtil.testDouble.WriterFake;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Test
    void 로또를_구매한다() {
        //given
        WriterFake writerFake = new WriterFake();
        OutputHandler outputHandler = new OutputHandler(writerFake, new OutputParser());
        NumberPickerFake numberPickerFake = new NumberPickerFake();
        LottoController sut = new LottoController(outputHandler, numberPickerFake);
        numberPickerFake.setNumbers(
                1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12
        );
        Money money = Money.from(2000);

        //when
        List<Lotto> lottos = sut.purchaseLottos(money);

        //then
        assertThat(lottos).extracting("numbers")
                .containsExactlyInAnyOrder(
                        Number.from(List.of(1, 2, 3, 4, 5, 6)),
                        Number.from(List.of(7, 8, 9, 10, 11, 12))
                );
    }
}
