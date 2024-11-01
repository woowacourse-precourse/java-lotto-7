package lotto.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class StringUtilTest {

    @Test
    public void 문자열을_특정_패턴에_따라_분리한다() {
        String pattern = "a:2:3";
        String delimiter = ":";

        assertThat(StringUtil.converList(pattern, delimiter)).containsExactlyInAnyOrder(pattern.split(delimiter));
    }
}
