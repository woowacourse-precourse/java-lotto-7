package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    private final LottoController lottoController = new LottoController();

    @Nested
    class 로또_구매는 {
        @Test
        void 구입_금액으로_숫자를_입력하지_않으면_예외처리() {

            try {
                String input = "string";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                lottoController.buyLotto();

                assertThat(out.toString()).contains("[ERROR] 로또 번호는 숫자만 가능 합니다.");
                Console.close();
            } catch (final NoSuchElementException ignore) {
            }
        }

        @Test
        void 구입_금액으로_1000으로_나누어_떨어지는_숫자를_입력하면_성공() {
            try {
                String input = "1000";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                assertThatCode(() -> lottoController.buyLotto())
                        .doesNotThrowAnyExceptionExcept(NoSuchElementException.class);
                Console.close();
            } catch (final NoSuchElementException ignore) {
            }
        }
    }


    @Nested
    class 로또_당첨_번호는 {
        @Test
        void 로또_번호_개수보다_많으면_예외처리() {
            try {
                String input = "1,2,3,4,5,6,7";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                lottoController.inputWinNum();

                assertThat(out.toString()).contains("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
                Console.close();
            } catch (final NoSuchElementException ignore) {
            }
        }

        @Test
        void 로또_번호_개수보다_적으면_예외처리() {
            try {
                String input = "1,2,3,4,5";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                lottoController.inputWinNum();

                assertThat(out.toString()).contains("[ERROR] 당첨 번호 6개를 입력해야 합니다.");
                Console.close();
            } catch (final NoSuchElementException ignore) {
            }
        }

        @Test
        void 숫자가_아닌_당첨_번호를_입력하면_예외처리() {
            try {
                String input = "string";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                lottoController.inputWinNum();

                assertThat(out.toString()).contains("[ERROR] 당첨 번호는 숫자만 가능 합니다.");

                Console.close();
            } catch (final NoSuchElementException ignore) {
            }
        }
    }

    @Nested
    class 로또_보너스_번호는 {
        @Test
        void 숫자가_아닌_보너스_번호를_입력하면_예외처리() {
            try {
                String input = "!";
                InputStream in = new ByteArrayInputStream(input.getBytes());
                System.setIn(in);

                OutputStream out = new ByteArrayOutputStream();
                System.setOut(new PrintStream(out));

                lottoController.inputBonusNum();

                assertThat(out.toString()).contains("[ERROR] 보너스 번호는 숫자만 가능 합니다.");
                Console.close();
            } catch (final NoSuchElementException ignore) {
            }
        }
    }
}