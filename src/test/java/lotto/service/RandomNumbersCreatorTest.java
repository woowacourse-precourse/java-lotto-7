package lotto.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumbersCreatorTest {

    @DisplayName("Randoms API는 설정한 개수만큼 숫자들을 생성해준다.")
    @Test
    void 랜덤_숫자_생성기가_설정한_크기의_숫자를_생성() {
        RandomNumbersCreator randomNumbersCreator = new RandomNumbersCreator();

        List<Integer> randomNumbers = randomNumbersCreator.create();

        assertThat(randomNumbers).hasSize(6);
    }

}
