package lotto.model.service;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import lotto.constant.ErrorMessage;
import lotto.constant.LottoConstantValue;
import lotto.model.domain.BonusNumber;
import lotto.model.domain.Lotto;
import lotto.model.domain.LottoPrize;
import lotto.model.domain.LottoRank;
import lotto.model.domain.LottoWinningNumbers;
import lotto.model.domain.Pocket;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    LottoService lottoService = new LottoService();

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void 돈이_입력되지_않으면_예외_발생(String text) throws Exception {
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.moneyValidator(text);
        }, ErrorMessage.MONEY_NOT_NULL_VALIDATOR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"-", " k", "1000L", ";"})
    public void 돈이_숫자로_입력되지_않으면_예외_발생(String text) throws Exception {
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.moneyValidator(text);
        }, ErrorMessage.MONEY_NUMERIC_VALIDATOR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", " 2000", "13000"})
    public void 돈이_숫자로_입력되었을때_테스트(String text) throws Exception {
        //given

        //when
        int result = lottoService.moneyValidator(text);

        text = text.trim();
        int expectedResult = Integer.parseInt(text);

        //then
        assertEquals(result, expectedResult);
    }

    @Test
    public void 로또_번호_생성기_테스트() throws Exception {
        //given
        int money = 3000;
        //when
        List<Lotto> lottoBundle = lottoService.activateLottoMachine(money);

        //then
        assertEquals(lottoBundle.size(), money / LottoConstantValue.LOTTO_PRICE.getValue());
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void 당첨번호가_아무것도_입력되지_않으면_예외_발생(String text) throws Exception {
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.winningNumbersGenerator(text);
        }, ErrorMessage.WINNING_NUMBERS_NOT_NULL_VALIDATOR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,%", "2,3,k,1,)"})
    public void 당첨번호가_숫자로_입력되지_않으면_예외_발생(String text) throws Exception {
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.winningNumbersGenerator(text);
        }, ErrorMessage.WINNING_NUMBERS_NUMERIC_VALIDATOR.getMessage());
    }

    @Test
    public void 당첨번호_생성기_테스트() throws Exception {
        //given
        String inputText = "1,2,3,4,5,6";

        //when
        Lotto winningLotto = lottoService.winningNumbersGenerator(inputText);

        //then
        List<Integer> expectedListLotto = List.of(1, 2, 3, 4, 5, 6);

        assertEquals(winningLotto.getNumbers(), expectedListLotto);
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " "})
    public void 보너스번호가_아무것도_입력되지_않으면_예외_발생(String text) throws Exception {
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.bonusNumberGenerator(text);
        }, ErrorMessage.BONUS_NUMBER_NOT_NULL_VALIDATOR.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1(", "+", "P"})
    public void 보너스번호가_숫자로_입력되지_않으면_예외_발생(String text) throws Exception {
        //given

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            lottoService.bonusNumberGenerator(text);
        }, ErrorMessage.BONUS_NUMBER_NUMERIC_VALIDATOR.getMessage());
    }

    @Test
    public void 보너스번호_생성기_테스트() throws Exception {
        //given
        String inputText = "16";

        //when
        BonusNumber bonusNumber = lottoService.bonusNumberGenerator(inputText);

        //then
        int expectedBonusNumber = 16;

        assertEquals(bonusNumber.getBonusNumber(), expectedBonusNumber);
    }

    @ParameterizedTest
    @MethodSource("provideLottoPrizeTestCases")
    public void 보상_계산_기능_테스트(List<Integer> myLottoNumbers, int expectedRank, LottoRank expectedPrize) throws Exception {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        BonusNumber bonusNumber = new BonusNumber(7);
        LottoWinningNumbers lottoWinningNumbers = new LottoWinningNumbers(winningLotto, bonusNumber);

        LottoPrize lottoPrize = new LottoPrize();
        Pocket pocket = new Pocket(List.of(new Lotto(myLottoNumbers)), 1000);

        // when
        lottoService.calculateReward(lottoWinningNumbers, pocket, lottoPrize);

        // then
        Map<Integer, Integer> rewardRankResult = new HashMap<>();
        for (LottoRank lottoRank : LottoRank.values()) {
            rewardRankResult.put(lottoRank.getRank(), 0);
        }
        rewardRankResult.put(expectedRank, 1);

        assertEquals(lottoPrize.getRewardPrizeResult(), expectedPrize.getPrize());
        assertEquals(lottoPrize.getRewardRankResult(), rewardRankResult);
    }

    private static Stream<Arguments> provideLottoPrizeTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6), 1, LottoRank.FIRST), // 1등
                Arguments.of(List.of(1, 2, 3, 4, 5, 7), 2, LottoRank.SECOND), // 2등
                Arguments.of(List.of(1, 2, 3, 4, 5, 8), 3, LottoRank.THIRD), // 3등
                Arguments.of(List.of(1, 2, 3, 4, 9, 10), 4, LottoRank.FOURTH), // 4등
                Arguments.of(List.of(1, 2, 3, 11, 12, 13), 5, LottoRank.FIFTH), // 5등
                Arguments.of(List.of(1, 2, 23, 24, 25, 26), 0, LottoRank.DEFAULT), // 낙첨
                Arguments.of(List.of(1, 22, 23, 24, 25, 26), 0, LottoRank.DEFAULT), // 낙첨
                Arguments.of(List.of(21, 22, 23, 24, 25, 26), 0, LottoRank.DEFAULT) // 낙첨
        );
    }
}