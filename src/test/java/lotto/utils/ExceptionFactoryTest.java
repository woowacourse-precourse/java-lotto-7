package lotto.utils;


import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ExceptionFactoryTest extends NsTest {

    @Test
    void testThrowingIllegalArgumentException(){
        assertThatThrownBy(()-> ExceptionFactory.throwIllegalArgumentException(ExceptionType.INVALID_NUMERIC_STRING)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void testPrintExceptionMessage(){
        assertThatThrownBy(()->ExceptionFactory.throwIllegalArgumentException(ExceptionType.INVALID_NUMERIC_STRING)).isInstanceOf(IllegalArgumentException.class);
        assertThat(output()).contains(ExceptionFactory.OUTPUT_MESSAGE_HEAD).contains(ExceptionType.INVALID_NUMERIC_STRING.getMessage());
    }

    @Override
    protected void runMain() {

    }
}
