package lotto.service;

import lotto.message.LottoMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.domain.*;
import lotto.view.LottoPrinter;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoServiceTest {

    @Test
    @DisplayName("결과 발표 성공 - 당첨 통계 및 수익률 계산")
    void success_announceResult() {
        // given
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(8, 21, 23, 41, 42, 43)),
            new Lotto(Arrays.asList(3, 5, 11, 16, 32, 38)),
            new Lotto(Arrays.asList(7, 11, 16, 35, 36, 44)),
            new Lotto(Arrays.asList(1, 8, 11, 31, 41, 42)),
            new Lotto(Arrays.asList(13, 14, 16, 38, 42, 45)),
            new Lotto(Arrays.asList(7, 11, 30, 40, 42, 43)),
            new Lotto(Arrays.asList(2, 13, 22, 32, 38, 45)),
            new Lotto(Arrays.asList(1, 3, 5, 14, 22, 45))
        );

        Lotto winningLotto = new Lotto(Arrays.asList(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        LottoPrinter mockPrinter = new MockLottoPrinter();

        LottoService lottoService = new LottoService(lottos, new WinningLotto(winningLotto), new BonusNumber(bonusNumber), mockPrinter);

        // when
        lottoService.announceResult();

        // then
        MockLottoPrinter printer = (MockLottoPrinter) mockPrinter;
        List<String> printedMessages = printer.getPrintedMessages();

        assertThat(printedMessages).contains(
            "3개 일치 (5,000원) - 1개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
            "6개 일치 (2,000,000,000원) - 0개",
            "총 수익률은 62.5%입니다."
        );
    }

    @Test
    @DisplayName("결과 발표 성공 - 수익률 0%")
    void success_announceResult_zeroYield() {
        // given
        List<Lotto> lottos = Arrays.asList(
            new Lotto(Arrays.asList(11, 12, 15, 32, 36, 41)),
            new Lotto(Arrays.asList(6, 17, 22, 34, 36, 39)),
            new Lotto(Arrays.asList(6, 9, 17, 22, 24, 34)),
            new Lotto(Arrays.asList(4, 23, 30, 31, 43, 45)),
            new Lotto(Arrays.asList(3, 7, 22, 26, 37, 40))
        );

        Lotto winningLotto = new Lotto(Arrays.asList(1, 23, 4, 5, 6, 7));
        int bonusNumber = 8;
        LottoPrinter mockPrinter = new MockLottoPrinter();

        LottoService lottoService = new LottoService(lottos, new WinningLotto(winningLotto), new BonusNumber(bonusNumber), mockPrinter);

        // when
        lottoService.announceResult();

        // then
        MockLottoPrinter printer = (MockLottoPrinter) mockPrinter;
        List<String> printedMessages = printer.getPrintedMessages();

        assertThat(printedMessages).contains(
            "3개 일치 (5,000원) - 0개",
            "4개 일치 (50,000원) - 0개",
            "5개 일치 (1,500,000원) - 0개",
            "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
            "6개 일치 (2,000,000,000원) - 0개",
            "총 수익률은 0.0%입니다."
        );
    }

    static class MockLottoPrinter extends LottoPrinter {
        private final List<String> printedMessages = new java.util.ArrayList<>();

        public MockLottoPrinter() {
            super(new MockOutputPort());
        }

        @Override
        public void printResult(Rank rank, int count) {
            printedMessages.add(String.format("%s - %d개", rank.getDisplayMessage(), count));
        }

        @Override
        public void printYield(double yield) {
            printedMessages.add(String.format("총 수익률은 %.1f%%입니다.", yield));
        }

        @Override
        public void printMessage(LottoMessage message) {
            printedMessages.add(message.getMessage());
        }

        public List<String> getPrintedMessages() {
            return printedMessages;
        }
    }

    static class MockOutputPort implements lotto.view.OutputPort {
        @Override
        public void print(String message) {
        }
    }
}
