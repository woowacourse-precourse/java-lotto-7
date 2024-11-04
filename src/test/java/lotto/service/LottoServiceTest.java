package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.LottoGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {

    @Test
    @DisplayName("로또 목록에서 당첨 로또 리스트 반환 테스트")
    void calculateMatched() {
        // 당첨 번호와 보너스 번호 설정
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winnerLotto = new Lotto(winningNumbers);
        int bonusNumber = 7;

        // 테스트할 로또 그룹 설정
        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10))); // 3개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))); // 5개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));  // 6개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));  // 5개 + 보너스 일치

        LottoGroup lottoGroup = LottoGroup.createLottoGroup(lottoList);

        // 메서드 실행
        LottoService lottoService = LottoService.createLottoService();
        List<int[]> matchedList = lottoService.calculateMatched(lottoGroup, winnerLotto, bonusNumber);

        // 예상 결과
        List<int[]> expected = new ArrayList<>();
        expected.add(new int[]{1, 0, 0, 0, 0});  // 3개 일치, 보너스 불일치
        expected.add(new int[]{0, 0, 1, 0, 0});  // 5개 일치, 보너스 불일치
        expected.add(new int[]{0, 0, 0, 0, 1});  // 6개 일치, 보너스 불일치
        expected.add(new int[]{0, 0, 0, 1, 0});  // 5개 일치, 보너스 일치

        for (int i = 0; i < expected.size(); i++) {
            assertEquals(Arrays.toString(expected.get(i)), Arrays.toString(matchedList.get(i)),
                    "매칭된 리스트의 크기가 예상과 다릅니다.");
            assertArrayEquals(expected.get(i), matchedList.get(i), "매칭된 리스트가 예상과 다릅니다.");
        }
    }

    @Test
    void payInput() {
    }

    @Test
    void generateLottoGroup() {
    }

    @Test
    void generateWinnerLotto() {
    }

    @Test
    void validateBonusNumber() {
    }
}