package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    private static final int MIN_NUM = 1;
    private static final int MAX_NUM = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    @DisplayName("랜덤 로또 번호 생성 테스트")
    @Test
    void buyLotto() {
        int lottoCount = 5;
        List<List<Integer>> lottos = new ArrayList<>();
        for (int index = 0; index < lottoCount; index++) {
            lottos.add(Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUMBER_COUNT).stream().sorted().toList());
        }

        assertThat(lottos).hasSize(lottoCount);

        for (List<Integer> lotto : lottos) {
            assertThat(lotto).hasSize(LOTTO_NUMBER_COUNT);
            //로또 번호가 6개 검증
            assertThat(lotto).allMatch(number -> number <= MAX_NUM && number >= MIN_NUM);
            //로또 번호의 최대 최소 검증
            assertThat(new HashSet<>(lotto)).hasSize(LOTTO_NUMBER_COUNT);
            //로또 번호 중복 검증
        }
    }
}