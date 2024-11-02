package lotto.handler;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RetryHandlerTest {
    private final RetryHandler retryHandler;

    public RetryHandlerTest() {
        retryHandler = new RetryHandler();
    }


    @Test
    @DisplayName("Supplier 로직을 입력으로 받는 retry(logic) 메서드를 10회 반복")
    void 매개변수가_없는_재시도_10회_테스트() {
        // given
        int expectedRetryCount = 10;
        MockCounter mockLogic = new MockCounter(expectedRetryCount);

        // when
        retryHandler.retry(mockLogic::getCount);

        // then
        assertThat(mockLogic.getCount()).isEqualTo(expectedRetryCount);
    }

    @Test
    @DisplayName("Function 로직을 입력으로 받는 retry(logic, data) 메서드를 20회 반복")
    void 매개변수가_있는_재시도_20회_테스트() {
        // given
        int expectedRetryCount = 20;
        int garbage = 1;
        MockCounter mockLogic = new MockCounter(expectedRetryCount);

        // when
        retryHandler.retry(mockLogic::getCount, garbage);

        // then
        assertThat(mockLogic.getCount()).isEqualTo(expectedRetryCount);
    }


    // end-1까지 예외를 뱉어내고, end시점에 정상 종료한다.
    private class MockCounter {
        int count;
        int end;

        public MockCounter(int end) {
            this.count = 0;
            this.end = end;
        }

        public int getCount() {
            if (count < end) {
                count++;
                throw new IllegalArgumentException("재시도");
            }

            return count;
        }

        public int getCount(int garbage) {
            return getCount();
        }

    }


}
