package lotto.domain.generator;

import lotto.domain.generator.RandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[유닛 테스트] - 랜덤 번호 생성")
class RandomNumberTest {

    @Test
    @DisplayName("랜덤 번호 생성 - 랜덤 번호 생성 시도 시 중복되지 않는 숫자 목록 반환")
    void generateRandomNumber_returnUniqueNumberList() {
        //given & when
        RandomNumber randomNumber = RandomNumber.generate();
        HashSet<Integer> randomNumberSet = new HashSet<>(randomNumber.randomNumber());

        //then
        assertThat(randomNumber.randomNumber()).hasSize(6);
        assertThat(randomNumber.randomNumber()).allMatch(number -> number >= 1 && number <= 45);
        assertThat(randomNumberSet.size()).isEqualTo(randomNumber.randomNumber().size());
    }
}