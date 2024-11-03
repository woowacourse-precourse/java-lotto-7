package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultCheckerTest {

    @DisplayName("당첨 개수가 0개로 리턴돼야한다.")
    @MethodSource("provideZeroLottoResultChecker")
    @ParameterizedTest
    void 당첨_개수가_0개로_리턴돼야한다(LottoResultChecker lottoResultChecker) {
        List<Integer> prizeCount = lottoResultChecker.getPrizeResult();

        assertThat(prizeCount.get(0)).isSameAs(0);
    }

    @DisplayName("당첨 개수가 3개로리턴돼야한다.")
    @MethodSource("provideThreeLottoResultChecker")
    @ParameterizedTest
    void 당첨_개수가_3개로_리턴돼야한다(LottoResultChecker lottoResultChecker) {
        List<Integer> prizeCount = lottoResultChecker.getPrizeResult();

        assertThat(prizeCount.get(0)).isSameAs(3);
    }

    @DisplayName("여러 장을 구매해도 정상적인 값이 반환된다.")
    @MethodSource("provideManyLottoResultChecker")
    @ParameterizedTest
    void 여러_장을_구매해도_정상적인_값_반환(LottoResultChecker lottoResultChecker) {
        List<Integer> prizeCount = lottoResultChecker.getPrizeResult();

        assertThat(prizeCount.get(0)).isSameAs(3);
        assertThat(prizeCount.get(1)).isSameAs(2);
    }



    // 당첨개수 0개 로또 생성
    static Stream<Arguments> provideZeroLottoResultChecker() {
        List<Lotto> purchaseLottoList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        numberList.add(0, 1);
        numberList.add(1, 2);
        numberList.add(2, 3);
        numberList.add(3, 4);
        numberList.add(4, 5);
        numberList.add(5, 6);

        Lotto purchaseLotto = new Lotto(numberList);
        purchaseLottoList.add(purchaseLotto);

        List<Integer> prizeNumbers = new ArrayList<>();
        prizeNumbers.add(0, 7);
        prizeNumbers.add(1, 8);
        prizeNumbers.add(2, 9);
        prizeNumbers.add(3, 10);
        prizeNumbers.add(4, 11);
        prizeNumbers.add(5, 12);

        LottoResultChecker lottoResultChecker = new LottoResultChecker(purchaseLottoList, prizeNumbers, 34,1000);

        return Stream.of(
                Arguments.of(lottoResultChecker)
        );
    }

    // 당첨개수 3개 로또 생성
    static Stream<Arguments> provideThreeLottoResultChecker() {
        List<Lotto> purchaseLottoList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        numberList.add(0, 1);
        numberList.add(1, 2);
        numberList.add(2, 3);
        numberList.add(3, 4);
        numberList.add(4, 5);
        numberList.add(5, 6);

        Lotto purchaseLotto = new Lotto(numberList);
        purchaseLottoList.add(purchaseLotto);

        List<Integer> prizeNumbers = new ArrayList<>();
        prizeNumbers.add(0, 1);
        prizeNumbers.add(1, 2);
        prizeNumbers.add(2, 3);
        prizeNumbers.add(3, 10);
        prizeNumbers.add(4, 11);
        prizeNumbers.add(5, 12);

        LottoResultChecker lottoResultChecker = new LottoResultChecker(purchaseLottoList, prizeNumbers, 34,1000);

        return Stream.of(
                Arguments.of(lottoResultChecker)
        );
    }

    // 여러장의 발급복권 값 리턴
    static Stream<Arguments> provideManyLottoResultChecker() {
        List<Lotto> purchaseLottoList = new ArrayList<>();
        List<Integer> numberList = new ArrayList<>();
        List<Integer> numberList2 = new ArrayList<>();
        numberList.add(0, 1);
        numberList.add(1, 2);
        numberList.add(2, 3);
        numberList.add(3, 4);
        numberList.add(4, 5);
        numberList.add(5, 6);

        numberList2.add(0, 10);
        numberList2.add(1, 11);
        numberList2.add(2, 45);
        numberList2.add(3, 44);
        numberList2.add(4, 43);
        numberList2.add(5, 42);


        Lotto purchaseLotto = new Lotto(numberList);
        Lotto purchaseLotto2 = new Lotto(numberList2);
        purchaseLottoList.add(purchaseLotto);
        purchaseLottoList.add(purchaseLotto2);

        List<Integer> prizeNumbers = new ArrayList<>();
        prizeNumbers.add(0, 1);
        prizeNumbers.add(1, 2);
        prizeNumbers.add(2, 3);
        prizeNumbers.add(3, 10);
        prizeNumbers.add(4, 11);
        prizeNumbers.add(5, 12);

        LottoResultChecker lottoResultChecker = new LottoResultChecker(purchaseLottoList, prizeNumbers, 34,1000);

        return Stream.of(
                Arguments.of(lottoResultChecker)
        );
    }

}