package lotto.domain.utility.Splitter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CustomSplitterTest {

    private final CustomSplitter customSplitter = new CustomSplitter(",");

    @Test
    void 구분자로_쪼개져야_한다() {
        //given
        String input = "1,2,3,4,5,6,7";

        //when
        String[] splitInput = customSplitter.splitFrom(input);

        //then
        assertThat(splitInput.length).isEqualTo(7);
        assertThat(splitInput[splitInput.length - 1]).isEqualTo("7");
    }
}
