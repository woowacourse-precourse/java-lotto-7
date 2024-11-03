package lotto.utility;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CommonInputProcessorTest {

    @DisplayName("공백제거")
    @ParameterizedTest(name = "\"{0}\"일 경우 : \"{1}\"")
    @CsvSource({"  문자열,문자열", "문자열  ,문자열", "문 자 열,문자열"})
    void 공백제거(String input, String expectedNonSpaceInput) {
        String actualNonSpaceInput = CommonInputProcessor.removeSpace(input);

        assertThat(actualNonSpaceInput).isEqualTo(expectedNonSpaceInput);
    }
}