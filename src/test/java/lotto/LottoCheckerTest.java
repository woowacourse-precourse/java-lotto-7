package lotto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class LottoCheckerTest {
    private LottoChecker lottoChecker;
    private Logger log = Logger.getLogger(LottoCheckerTest.class.getName());

    @BeforeEach
    void setUp() {
        List<Integer> nums = new ArrayList<>();
        nums.add(1);
        nums.add(2);
        nums.add(3);
        nums.add(4);
        nums.add(5);
        nums.add(6);
        int bonusNum = 7;

        lottoChecker = new LottoChecker(nums, bonusNum);
    }

    @DisplayName("수익률 계산하는 메서드")
    @ParameterizedTest
    @MethodSource("calculateRateOfReturn")
    void calculateRateOfReturnTest(int[] ranks) {
        double result = lottoChecker.calculateRateOfReturn(ranks);
        log.info("결과: " + result);
        assertTrue(result >= 0);
    }

    public static Stream<Arguments> calculateRateOfReturn() {
        return Stream.of(
                Arguments.of((Object) new int[]{1, 1, 1, 1, 1, 1}),
                Arguments.of((Object) new int[]{1, 0, 0, 0, 0, 0}),
                Arguments.of((Object) new int[]{0, 0, 0, 0, 0, 1})
        );
    }


    @DisplayName("고객이 가진 로또들 중 당첨 내역 확인하는 메서드")
    @ParameterizedTest
    @MethodSource("lottoRankCheck")
    void lottoRankCheckTest(Customer customer) {
        customer.buyLottos("8000");

        int[] result = lottoChecker.lottoRankCheck(customer);

        for (int i = 0; i < result.length; i++) {
            log.info(i + "등 : " + result[i]);
        }

        assertTrue(result.length >= 6);
    }

    public static Stream<Arguments> lottoRankCheck() {
        return Stream.of(
                Arguments.of(new Customer())
        );
    }

    @DisplayName("고객이 가진 로또가 1등인 지 확인하는 메서드")
    @ParameterizedTest
    @ValueSource(ints = {6})
    void calculateRank1FromCountTest(int rank) {
        assertEquals(1, lottoChecker.calculateRankFromCount(rank));
    }

    @DisplayName("고객이 가진 로또가 2등인 지 확인하는 메서드")
    @ParameterizedTest
    @ValueSource(ints = {15})
    void calculateRank2FromCountTest(int rank) {
        assertEquals(2, lottoChecker.calculateRankFromCount(rank));
    }


    @DisplayName("고객이 가진 로또가 3등인 지 확인하는 메서드")
    @ParameterizedTest
    @ValueSource(ints = {5})
    void calculateRank3FromCountTest(int rank) {
        assertEquals(3, lottoChecker.calculateRankFromCount(rank));
    }


    @DisplayName("고객이 가진 로또가 4등인 지 확인하는 메서드")
    @ParameterizedTest
    @ValueSource(ints = {4, 14})
    void calculateRank4FromCountTest(int rank) {
        assertEquals(4, lottoChecker.calculateRankFromCount(rank));
    }


    @DisplayName("고객이 가진 로또가 1등인 지 확인하는 메서드")
    @ParameterizedTest
    @ValueSource(ints = {3, 13})
    void calculateRank5FromCountTest(int rank) {
        assertEquals(5, lottoChecker.calculateRankFromCount(rank));
    }


    @DisplayName("고객이 가진 로또가 5등인 지 확인하는 메서드")
    @ParameterizedTest
    @ValueSource(ints = {2, 1, 0})
    void calculateNoRankFromCountTest(int rank) {
        assertEquals(0, lottoChecker.calculateRankFromCount(rank));
    }
}
