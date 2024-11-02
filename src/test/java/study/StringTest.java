package study;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringTest {
    /**
     * 요구사항 1
     */
    @Test
    void 쉼표를_기준으로_문자열_나누기() {
        String str = "1,2";
        String[] results = str.split(",");
        assertThat(results).containsExactly("1", "2");
    }

    @Test
    void 쉼표를_기준으로_문자열_나누기_원소_한_개() {
        String str = "1";
        String[] results = str.split(",");
        assertThat(results).containsExactly("1");
    }
}
