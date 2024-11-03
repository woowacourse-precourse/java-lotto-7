package lotto.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.Map;
import lotto.model.lotto.Rank;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class RankParserTest {

    @Test
    @DisplayName("Rank 의 정보를 통해 적절한 설명 형태를 반환한다.")
    void returnValidDescriptionAccordingToInformationOfRank() {
        // given
        Map<Rank, String> descriptions = RankParser.makeDescriptions();

        // when & then
        assertAll(
                () -> assertThat(descriptions.get(Rank.FIRST_PLACE)).isEqualTo("6개 일치 (2,000,000,000원)"),
                () -> assertThat(descriptions.get(Rank.SECOND_PLACE)).isEqualTo(
                        "5개 일치, 보너스 볼 일치 (30,000,000원)"),
                () -> assertThat(descriptions.get(Rank.THIRD_PLACE)).isEqualTo("5개 일치 (1,500,000원)"),
                () -> assertThat(descriptions.get(Rank.FOURTH_PLACE)).isEqualTo("4개 일치 (50,000원)"),
                () -> assertThat(descriptions.get(Rank.FIFTH_PLACE)).isEqualTo("3개 일치 (5,000원)")
        );

    }
}
