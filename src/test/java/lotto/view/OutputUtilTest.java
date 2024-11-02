package lotto.view;

import org.junit.jupiter.api.*;
import java.io.*;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class OutputUtilTest {

    private final PrintStream originalOut = System.out;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUpStreams(){
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    void restoreStreams(){
        System.setOut(originalOut);
    }

    @Test
    @DisplayName("printPurchaseAmountMessage가 올바른 메시지를 출력하는지 테스트")
    void testPrintPurchaseAmountMessage(){
        OutputUtil.printPurchaseAmountMessage(5);
        String expected = "\n5개를 구매했습니다.\r\n";
        String actual = outContent.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("printUserLotto가 로또 번호를 올바르게 출력하는지 테스트")
    void testPrintUserLotto(){
        List<List<Integer>> lottos = new ArrayList<>();
        lottos.add(Arrays.asList(1,2,3,4,5,6));
        lottos.add(Arrays.asList(7,8,9,10,11,12));

        OutputUtil.printUserLotto(lottos);

        String expected = "[1, 2, 3, 4, 5, 6]\r\n[7, 8, 9, 10, 11, 12]\r\n";
        String actual = outContent.toString();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("generateLottoNumbers가 올바른 수의 로또 번호를 생성하는지 테스트")
    void testGenerateLottoNumbers(){
        int count = 3;
        List<List<Integer>> generatedLottos = OutputUtil.generateLottoNumbers(count);
        assertEquals(count, generatedLottos.size(), "생성된 로또 수가 요청한 수와 일치해야 합니다.");

        for(List<Integer> lotto : generatedLottos){
            assertEquals(6, lotto.size(), "각 로또는 6개의 번호를 가져야 합니다.");

            // 중복 번호 검증
            Set<Integer> uniqueNumbers = new HashSet<>(lotto);
            assertEquals(6, uniqueNumbers.size(), "로또 번호는 중복되지 않아야 합니다.");

            // 번호 범위 검증
            for(int number : lotto){
                assertTrue(number >=1 && number <=45, "로또 번호는 1부터 45 사이여야 합니다.");
            }

            // 오름차순 정렬 검증
            List<Integer> sortedLotto = new ArrayList<>(lotto);
            Collections.sort(sortedLotto);
            assertEquals(sortedLotto, lotto, "로또 번호는 오름차순으로 정렬되어야 합니다.");
        }
    }
}
