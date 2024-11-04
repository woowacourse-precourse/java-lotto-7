package lotto.utils;


import java.util.stream.Stream;
import lotto.constant.PrizeTier;
import lotto.utils.NumberList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TransformerTest {

    @Test
    void testStringWithRound(){
        assertThat(
        Transformer.toStringWithRound(5.5555,2)).isEqualTo("5.6");

        assertThat(
                Transformer.toStringWithRound(1.04,2)).isEqualTo("1.0");
    }

    @Test
    void testJoinToString(){
        assertThat(Transformer.joinToString(List.of(1,2,3,4,5),", ")).isEqualTo("1, 2, 3, 4, 5");
        assertThat(Transformer.joinToString(List.of(1,2,3,4,5),"-")).isEqualTo("1-2-3-4-5");
    }

    @Test
    void testTransformToIntegerList(){
        String[] input = {"1","2","3"};
        assertThat(Transformer.transformToIntegerList(input)).isEqualTo(List.of(1,2,3));
    }

    @Test
    void testParsePositiveInt(){
        assertThat(Transformer.parsePositiveInt("1000")).isEqualTo(1000);
        assertThatThrownBy(()->Transformer.parsePositiveInt("?")).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(()->Transformer.parsePositiveInt("")).isInstanceOf(IllegalArgumentException.class);
    }

}
