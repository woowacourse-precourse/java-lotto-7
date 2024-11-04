package lotto.io;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.io.inputHandler.DefaultInputHandler;
import lotto.testUtil.testDouble.ReaderFake;
import lotto.testUtil.testDouble.WriterFake;
import org.junit.jupiter.api.Test;

class DefaultInputHandlerTest {

    @Test
    void 구입금액을_입력받는다() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        DefaultInputHandler sut = new DefaultInputHandler(readerFake, writerFake);
        readerFake.setInput("1000");

        //when
        int result = sut.handlePurchaseCost();

        //then
        assertThat(result).isEqualTo(1000);
        assertThat(writerFake.getOutputs()).contains("구입금액을 입력해 주세요.");
    }

    @Test
    void 당첨번호를_입력받는다() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        DefaultInputHandler sut = new DefaultInputHandler(readerFake, writerFake);
        readerFake.setInput("1,2,3,4,5,6");

        //when
        List<Integer> result = sut.handleWinningNumbers();

        //then
        assertThat(result).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6);
        assertThat(writerFake.getOutputs()).contains("당첨 번호를 입력해 주세요.");
    }

    @Test
    void 보너스번호를_입력받는다() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        DefaultInputHandler sut = new DefaultInputHandler(readerFake, writerFake);
        readerFake.setInput("7");

        //when
        int result = sut.handleBonusNumber();

        //then
        assertThat(result).isEqualTo(7);
        assertThat(writerFake.getOutputs()).contains("보너스 번호를 입력해 주세요.");
    }
}
