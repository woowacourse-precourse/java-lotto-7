package valid;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TaskTest {

    @DisplayName("동작이 성공적일 때 반환 값을 검증한다.")
    @Test
    void returnTypeWhenSuccessfulRun() {
        // given
        String success = "Success";
        Task<String> successfulTask = () -> success;

        // when
        String result = Task.reTryTaskUntilSuccessful(successfulTask);

        // then
        assertEquals(result, success);
    }

    @DisplayName("예외가 발생했을 때 동작을 재실행한다.")
    @Test
    void retryRunWhenThrowException() {
        // given
        String success = "Success";
        Task<String> taskWithRetry = new Task<>() {
            private int attempt = 0;

            @Override
            public String run() {
                if (attempt < 5) {
                    attempt++;
                    throw new IllegalArgumentException("Test Exception");
                }
                return success;
            }
        };

        // when
        String result = Task.reTryTaskUntilSuccessful(taskWithRetry);

        // then
        assertEquals(success, result);
    }
}
