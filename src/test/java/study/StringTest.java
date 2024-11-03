package study;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class StringTest {
    @Test
    public void splitTest() {
        assertThat("1,2".split(",")).contains("1","2");
        assertThat("1".split(",")).containsExactly("1");
    }

    @Test
    public void subStringTest() {
        assertThat("(1,2)".substring(1,4)).isEqualTo("1,2");
    }

    @Test
    public void charAtTest() {
        String string1 = "뽀뚜";

        assertThatThrownBy(() ->{
          string1.charAt(3);
        })
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessageContaining("Index");
    }

}
