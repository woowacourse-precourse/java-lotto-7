package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LoopTest {
    @BeforeEach
    void setup() {
        System.setOut(new PrintStream(OutputStream.nullOutputStream()));
    }

    @Test
    void 바로_성공_시에는_한번만_실행된다() {
        AtomicInteger i = new AtomicInteger();

        Loop.executeUntilSuccess(() -> {
            i.getAndIncrement();
        });

        assertThat(i.get()).isEqualTo(1);
    }

    @Test
    void 실패_시에는_성공할_때까지_실행된다() {
        AtomicInteger i = new AtomicInteger();

        Loop.executeUntilSuccess(() -> {
            i.getAndIncrement();
            if (i.get() < 10) {
                throw new IllegalArgumentException();
            }
        });

        assertThat(i.get()).isEqualTo(10);
    }

    @Test
    void 지정된_런타임_예외가_아닐_경우에는_예외를_던진다() {
        assertThrows(NegativeArraySizeException.class, () -> {
            Loop.executeUntilSuccess(() -> {
                throw new NegativeArraySizeException();
            });
        });
    }
}