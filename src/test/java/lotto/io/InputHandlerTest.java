package lotto.io;

import static org.junit.jupiter.api.Assertions.assertAll;

import lotto.testutil.ReaderFake;
import lotto.testutil.WriterFake;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputHandlerTest {

    @DisplayName("입력을 요청하는 메시지가 정상 출력된다.")
    @Test
    void 당첨_번호와_보너스_번호_입력_요청_메시지_출력_테스트() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        InputHandler handler = new InputHandler(
                readerFake,
                writerFake,
                new InputValidator()
        );
        readerFake.setInput("2000", "1,2,3,4,5,6", "7");

        //when
        handler.readBuyAmount();
        handler.readWinningNumbers();
        handler.readBonusNumber();

        //then
        Assertions.assertThat(writerFake.getOutputs()).containsExactly(
                "구입금액을 입력해 주세요.\n",
                "당첨 번호를 입력해 주세요.\n",
                "\n보너스 번호를 입력해 주세요.\n"
        );
    }
    
    @Test
    @DisplayName("값을 입력하지 않으면 예외가 발생한다.")
    void 구입_금액_예외_테스트() {
        //given
        ReaderFake readerFake = new ReaderFake();
        WriterFake writerFake = new WriterFake();
        InputHandler handler = new InputHandler(
                readerFake,
                writerFake,
                new InputValidator()
        );
        readerFake.setInput("", "", "");

        //when & then
        assertAll(
                () -> Assertions.assertThatThrownBy(handler::readBuyAmount)
                        .isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertThatThrownBy(handler::readWinningNumbers)
                        .isInstanceOf(IllegalArgumentException.class),
                () -> Assertions.assertThatThrownBy(handler::readBonusNumber)
                        .isInstanceOf(IllegalArgumentException.class)
        );

    }
}