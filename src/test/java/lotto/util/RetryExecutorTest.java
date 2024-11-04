package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class RetryExecutorTest {

    @Nested
    class 재시도_성공_테스트 {
        @Test
        void 첫_시도에_성공하면_즉시_결과를_반환한다() throws Exception {
            // given
            String expected = "success";

            // when
            String result = RetryExecutor.execute(
                    () -> expected,
                    IllegalArgumentException.class
            );

            // then
            assertThat(result).isEqualTo(expected);
        }

        @Test
        void 지정된_예외가_발생하면_성공할_때까지_재시도한다() throws Exception {
            // given
            AtomicInteger attempts = new AtomicInteger(0);

            // when
            String result = RetryExecutor.execute(
                    () -> {
                        if (attempts.incrementAndGet() <= 2) {
                            throw new IllegalArgumentException("일부러 발생시킨 예외");
                        }
                        return "success";
                    },
                    IllegalArgumentException.class
            );

            // then
            assertSoftly(softly -> {
                softly.assertThat(result).isEqualTo("success");
                softly.assertThat(attempts.get()).isEqualTo(3);
            });
        }

        @Test
        void 여러_종류의_예외에_대해_재시도한다() throws Exception {
            // given
            AtomicInteger attempts = new AtomicInteger(0);

            // when
            String result = RetryExecutor.execute(
                    () -> {
                        int attempt = attempts.incrementAndGet();
                        if (attempt == 1) {
                            throw new IllegalArgumentException();
                        }
                        if (attempt == 2) {
                            throw new IllegalStateException();
                        }
                        return "success";
                    },
                    IllegalArgumentException.class, IllegalStateException.class
            );

            // then
            assertSoftly(softly -> {
                softly.assertThat(result).isEqualTo("success");
                softly.assertThat(attempts.get()).isEqualTo(3);
            });
        }
    }

    @Nested
    class 예외_처리_테스트 {
        @Test
        void 지정되지_않은_예외는_즉시_던진다() {
            // when & then
            assertThatThrownBy(() ->
                    RetryExecutor.execute(
                            () -> {
                                throw new RuntimeException("네트워크 오류");
                            },
                            IllegalArgumentException.class
                    ))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("네트워크 오류");
        }

        @Test
        void 에러_콜백이_호출된다() throws Exception {
            // given
            AtomicInteger callbackCount = new AtomicInteger(0);
            AtomicInteger attempts = new AtomicInteger(0);

            // when
            RetryExecutor.execute(
                    () -> {
                        if (attempts.incrementAndGet() <= 2) {
                            throw new IllegalArgumentException("재시도 필요");
                        }
                        return "success";
                    },
                    error -> callbackCount.incrementAndGet(),
                    IllegalArgumentException.class
            );

            // then
            assertThat(callbackCount.get()).isEqualTo(2);
        }
    }

    @Nested
    class 재시도_실패_테스트 {

        @Test
        void 빈_예외_배열을_전달하면_모든_예외를_즉시_던진다() {
            assertThatThrownBy(() ->
                    RetryExecutor.execute(
                            () -> {
                                throw new IllegalArgumentException();
                            }
                    ))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    class 특수_케이스_테스트 {
        @Test
        void null을_반환하는_작업도_정상_처리된다() throws Exception {
            // when
            String result = RetryExecutor.execute(
                    () -> null,
                    IllegalArgumentException.class
            );

            // then
            assertThat(result).isNull();
        }

        @Test
        void 예외_상속_관계도_처리한다() throws Exception {
            // given
            AtomicInteger attempts = new AtomicInteger(0);

            // when
            String result = RetryExecutor.execute(
                    () -> {
                        if (attempts.incrementAndGet() == 1) {
                            throw new NumberFormatException(); // RuntimeException의 하위 클래스
                        }
                        return "success";
                    },
                    RuntimeException.class // 상위 클래스로 지정
            );

            // then
            assertSoftly(softly -> {
                softly.assertThat(result).isEqualTo("success");
                softly.assertThat(attempts.get()).isEqualTo(2);
            });
        }
    }
}
