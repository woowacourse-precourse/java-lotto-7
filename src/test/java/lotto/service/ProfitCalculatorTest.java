package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.TargetLotto;
import org.assertj.core.api.Assertions;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ProfitCalculatorTest {
    ProfitCalculator profitCalculator;

    @BeforeEach
    void 초기화() {
        Lottos lottos = new Lottos(
                List.of(
                        new Lotto(List.of(1, 2, 3, 4, 5, 6)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 7)),
                        new Lotto(List.of(1, 2, 3, 4, 5, 17)),
                        new Lotto(List.of(1, 2, 3, 4, 15, 17)),
                        new Lotto(List.of(1, 2, 3, 24, 25, 17)),
                        new Lotto(List.of(1, 2, 13, 34, 35, 17)))
        );
        TargetLotto targetLotto = new TargetLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7);

        profitCalculator = new ProfitCalculator(lottos, targetLotto);
    }

    @Test
    void 계산기_테스트() {
        double profitRate = profitCalculator.calculateProfit();
        double expectedProfit = (2_000_000_000 + 30_000_000 + 1_500_000 + 50_000 + 5_000) / 6000.0 * 100;

        Assertions.assertThat(profitRate).isCloseTo(expectedProfit, Offset.offset(0.01));
    }

    @Test
    @DisplayName("5000원 1장, 0원 9999장 -> 수익률 0.05")
    void 계산기_반올림_올림_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto fifth = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        lottoList.add(fifth);

        for (int i = 0; i < 9999; i++) {
            Lotto fail = new Lotto(List.of(11, 12, 13, 14, 15, 16));
            lottoList.add(fail);
        }

        Lottos lottos = new Lottos(lottoList);
        profitCalculator = new ProfitCalculator(lottos, new TargetLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7));
        double profitRate = profitCalculator.calculateProfit();

        Assertions.assertThat(profitRate).isEqualTo(0.1);
    }

    @Test
    @DisplayName("5000원 1장, 0원 10000장 -> 수익률 0.04xx")
    void 계산기_반올림_버림_테스트() {
        List<Lotto> lottoList = new ArrayList<>();
        Lotto fifth = new Lotto(List.of(1, 2, 3, 11, 12, 13));
        lottoList.add(fifth);

        for (int i = 0; i < 10000; i++) {
            Lotto fail = new Lotto(List.of(11, 12, 13, 14, 15, 16));
            lottoList.add(fail);
        }

        Lottos lottos = new Lottos(lottoList);
        profitCalculator = new ProfitCalculator(lottos, new TargetLotto(new Lotto(List.of(1, 2, 3, 4, 5, 6)), 7));
        double profitRate = profitCalculator.calculateProfit();

        Assertions.assertThat(profitRate).isEqualTo(0.0);
    }
}
