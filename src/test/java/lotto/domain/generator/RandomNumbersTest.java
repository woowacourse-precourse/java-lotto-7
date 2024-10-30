package lotto.domain.generator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("[유닛 테스트] - 랜덤 번호 목록 생성")
class RandomNumbersTest {

    @Test
    @DisplayName("랜덤 번호 목록 생성 - 입력 받은 갯수 만큼 랜덤 번호 목록 생성")
    void purchaseCount_generateRandomNumbers() {
        //given & when
        RandomNumbers randomNumbers = new RandomNumbers();
        randomNumbers.addRandomNumber(5);

        //then
        assertThat(randomNumbers.randomNumbers()).hasSize(5);
    }
}