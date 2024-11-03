package lotto;

import lotto.domain.LottoPrize;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class LottoPrizeTest {

    @DisplayName("로또 당첨 번호 생성 성공")
    @Test
    void 로또_당첨번호_생성_성공() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        //when
        LottoPrize lottoPrize = LottoPrize.createLottoPrize(inputPrizeNumbers);
        List<Integer> lottoPrizeNumbers = lottoPrize.getLottoPrizeNumbers();

        //then
        assertEquals(lottoPrizeNumbers, inputPrizeNumbers);
    }

    @DisplayName("로또 당첨 번호 생성 실패 로또 당첨 범위 초과")
    @Test
    void 로또_당첨번호_생성_실패_초과() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5,65));

        //when & then
        assertThatThrownBy(() -> LottoPrize.createLottoPrize(inputPrizeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 생성 실패 6개 미만")
    @Test
    void 로또_당첨번호_생성_실패_6개미만() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5));

        //when & then
        assertThatThrownBy(() -> LottoPrize.createLottoPrize(inputPrizeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 생성 실패 6개 이상")
    @Test
    void 로또_당첨번호_생성_실패_6개이상() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5,6,7));

        //when & then
        assertThatThrownBy(() -> LottoPrize.createLottoPrize(inputPrizeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 당첨 번호 생성 실패 중복 오류")
    @Test
    void 로또_당첨번호_생성_실패_중복숫자() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5,5));

        //when & then
        assertThatThrownBy(() -> LottoPrize.createLottoPrize(inputPrizeNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 보너스 당첨 번호 생성 성공")
    @Test
    void 로또_보너스_당첨번호_생성_성공() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Integer inputBonusNumber = 7;

        //when
        LottoPrize lottoPrize = LottoPrize.createLottoBonus(inputPrizeNumbers, inputBonusNumber);

        //then
        assertEquals(inputBonusNumber, lottoPrize.getBonusNumber());
    }

    @DisplayName("로또 보너스 당첨 번호 생성 실패 중복")
    @Test
    void 로또_보너스_당첨번호_생성_실패_중복() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Integer inputBonusNumber = 6;

        //when
        assertThatThrownBy(() -> LottoPrize.createLottoBonus(inputPrizeNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 보너스 당첨 번호 생성 실패_범위초과")
    @Test
    void 로또_보너스_당첨번호_생성_실패_범위초과() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Integer inputBonusNumber = 46;

        //when
        assertThatThrownBy(() -> LottoPrize.createLottoBonus(inputPrizeNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @DisplayName("로또 보너스 당첨 번호 생성 실패_범위미달")
    @Test
    void 로또_보너스_당첨번호_생성_실패_범위미달() {
        //given
        List<Integer> inputPrizeNumbers = new ArrayList<>(List.of(1,2,3,4,5,6));
        Integer inputBonusNumber = 0;

        //when
        assertThatThrownBy(() -> LottoPrize.createLottoBonus(inputPrizeNumbers, inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);

    }

}