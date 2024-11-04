package lotto.service;

import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.Console;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.generator.LottoGenerator;
import lotto.model.Lotto;
import lotto.model.LottoGroup;
import lotto.model.Pay;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoServiceTest {
    @AfterEach
    void tearDown() {
        Console.close();
    }

    @BeforeEach
    public void setUp() {
        PrintService printService = new PrintService();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(printService, lottoGenerator);
    }

    @Test
    @DisplayName("로또 목록에서 당첨 로또 리스트 반환 테스트")
    void calculateMatched() {
        // 당첨 번호와 보너스 번호 설정
        List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        Lotto winnerLotto = new Lotto(winningNumbers);
        int bonusNumber = 7;

        List<Lotto> lottoList = new ArrayList<>();
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 8, 9, 10))); // 3개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 10))); // 5개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6)));  // 6개 일치
        lottoList.add(new Lotto(Arrays.asList(1, 2, 3, 4, 5, 7)));  // 5개 + 보너스 일치

        LottoGroup lottoGroup = LottoGroup.createLottoGroup(lottoList);
        PrintService printService = new PrintService();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(printService, lottoGenerator);
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
    @DisplayName("payInput 비정상 입력 후 정상 입력 테스트")
    void payInputTest() {
        String input = "asdf\n25\n8000\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        PrintService printService = new PrintService();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(printService, lottoGenerator);
        Pay pay = lottoService.payInput();

        assertNotNull(pay, "Pay 객체가 null이 아닙니다.");
        assertEquals(8000, pay.getMoney(), "금액이 예상과 다릅니다.");
    }

    @Test
    @DisplayName("당첨 번호 생성 테스트")
    void generateWinnerLotto() {
        String input = "asdf\n1,2,3,4,5,6\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        PrintService printService = new PrintService();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(printService, lottoGenerator);
        Lotto lotto = lottoService.generateWinnerLotto();
        assertNotNull(lotto, "lotto 객체가 null이 아닙니다.");
        assertEquals("[1, 2, 3, 4, 5, 6]", lotto.getNumbers().toString(), "입력값이 예상과 다릅니다.");
    }

    @Test
    @DisplayName("당첨 번호 랜덤 생성 테스트")
    void generateRandomWinnerLotto() {
        String input = "\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        PrintService printService = new PrintService();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(printService, lottoGenerator);
        Lotto lotto = lottoService.generateWinnerLotto();
        assertNotNull(lotto, "lotto 객체가 null이 아닙니다.");
        assertEquals(lotto.getNumbers().size(), 6, "입력값이 예상과 다릅니다.");
    }

    @Test
    @DisplayName("보너스 번호 입력 테스트")
    void validateBonusNumber() {
        String input = "1,2,3,4,5,6\nasdf\n1\n7\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        PrintService printService = new PrintService();
        LottoGenerator lottoGenerator = new LottoGenerator();
        LottoService lottoService = new LottoService(printService, lottoGenerator);
        Lotto winnerLotto = lottoService.generateWinnerLotto();
        int bonusNumber = lottoService.validateBonusNumber(winnerLotto);
        assertNotNull(bonusNumber, "bonusNumber가 null이 아닙니다.");
        assertEquals(7, bonusNumber, "입력값이 예상과 다릅니다.");
    }
}