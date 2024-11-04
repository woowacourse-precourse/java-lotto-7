package store.service;

import static global.utils.GlobalUtil.WeeklyNumberUtil.parsingWeeklyNumbers;
import static global.utils.GlobalUtil.WeeklyNumberUtil.splitWeeklyNumberWithSeparator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import global.exception.ErrorCode;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import lotto.constant.LottoRank;
import lotto.model.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import store.repository.StoreRepositoryImpl;

class StoreServiceTest {

    private final StoreRepositoryImpl storeRepository = new StoreRepositoryImpl();
    private final StoreService storeService = new StoreService(storeRepository);

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "7,8,9,10,11,12"})
    @DisplayName("올바른 입력이 주어지면, 이번 주 당첨 번호가 저장된다.")
    void t001(String inputWeeklyNumbers) {
        List<Integer> expectedNumbers = parsingWeeklyNumbers(splitWeeklyNumberWithSeparator(inputWeeklyNumbers));

        storeService.tryUpdateWeeklyNumbers(inputWeeklyNumbers);
        List<Integer> resultWeeklyNumbers = storeService.get().getWeeklyNumbers();

        assertThat(resultWeeklyNumbers).isEqualTo(expectedNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "45"})
    @DisplayName("올바른 입력이 주어지면, 이번 주 보너스 번호가 저장된다.")
    void t002(String inputBonusNumber) {
        int expectedNumber = Integer.parseInt(inputBonusNumber);
        String inputWeeklyNumbers = "2,3,4,5,6,7";

        storeService.tryUpdateWeeklyNumbers(inputWeeklyNumbers);
        storeService.tryUpdateBonusNumber(inputBonusNumber);
        int resultBonusNumber = storeService.get().getBonusNumber();

        assertThat(resultBonusNumber).isEqualTo(expectedNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3", "4", "5", "6"})
    @DisplayName("이미 당첨 번호로 저장된 숫자가 보너스 번호로 주어지면, 오류가 발생한다")
    void t003(String inputBonusNumber) {
        String inputWeeklyNumbers = "1,2,3,4,5,6";
        storeService.tryUpdateWeeklyNumbers(inputWeeklyNumbers);

        assertThatThrownBy(() -> storeService.tryUpdateBonusNumber(inputBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.BONUS_NUMBER_CANNOT_BE_DUPLICATE.getMsg());
    }

    @Test
    @DisplayName("로또의 당첨 여부를 상점에서 확인할 수 있다")
    void t004() {
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        List<Lotto> lottos = new ArrayList<>(List.of(lotto));
        storeService.tryUpdateWeeklyNumbers("1,2,3,4,5,6");
        storeService.tryUpdateBonusNumber("7");

        Map<LottoRank, Integer> matchedResult = storeService.getMatchedResult(lottos);

        assertThat(matchedResult.get(LottoRank.FIRST_RANK)).isEqualTo(1);
        assertThat(matchedResult.get(LottoRank.SECOND_RANK)).isEqualTo(0);
        assertThat(matchedResult.get(LottoRank.THIRD_RANK)).isEqualTo(0);
        assertThat(matchedResult.get(LottoRank.FOURTH_RANK)).isEqualTo(0);
        assertThat(matchedResult.get(LottoRank.FIFTH_RANK)).isEqualTo(0);
    }

}