package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;

public class LottoGameDisplayTest extends NsTest {

//    LottoGameDisplay lottoGameDisplay;
//
//    @BeforeEach
//    void initField() {
//        lottoGameDisplay = new LottoGameDisplay();
//    }
//
//    @AfterEach
//    void closeConsole() {
//        Console.close();
//    }
//
//    @Test
//    void 구입_금액_입력() {
//        // given
//        String input = "1000";
//
//        // when
//        run(input);
//        int money = lottoGameDisplay.inputMoney();
//
//        // then
//        assertThat(money)
//                .isEqualTo(1000);
//    }
//
//    @ParameterizedTest
//    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2,3 , 4 ,  5,6  "})
//    void 당첨번호_입력(String input) {
//        // when
//        run(input);
//        List<Integer> winNumbers = lottoGameDisplay.inputWinnerNumbers();
//
//        // then
//        assertThat(winNumbers)
//                .containsExactly(1, 2, 3, 4, 5, 6);
//    }
//
//    @Test
//    void 보너스번호_입력() {
//        // given
//        String input = "7";
//        List<Integer> winNumbers = List.of(1, 2, 3, 4, 5, 6);
//
//        // when
//        run(input);
//        int bonus = lottoGameDisplay.inputBonusNumber(winNumbers);
//
//        // then
//        assertThat(bonus)
//                .isEqualTo(7);
//    }
//
//    @Test
//    void 로또_출력() {
//        // given
//        Lotto lotto = new Lotto(List.of(34, 23, 22, 45, 1, 2));
//
//        // when
//        lottoGameDisplay.printLotto(lotto);
//
//        // then
//        assertThat(output())
//                .isEqualTo("[1, 2, 22, 23, 34, 45]");
//    }
//
//    @ParameterizedTest
//    @CsvSource(value = {"0:0.0", "12.34:12.3", "98.76:98.8", "100:100.0"}, delimiter = ':')
//    void 수익률_출력(double rateOfResult, String expect) {
//        // when
//        lottoGameDisplay.printWinStatistics(new HashMap<>(), rateOfResult);
//
//        // then
//        assertThat(output())
//                .contains(expect);
//    }

    @Override
    protected void runMain() {
        // not use
    }
}
