package lotto.io;

import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.WinningResult;

import java.util.List;
import java.util.stream.Collectors;

public class OutputHandler {

    public void showPurchaseAmountInstruction() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void showWinningNumbersInstruction() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void showBonusNumberInstruction() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void showWinningStatisticsComment() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void showLottos(List<Lotto> lottos) {
        showPurchaseInformation(lottos);
        showLottosNotation(lottos);
    }

    public void showWinningResult(WinningResult result) {
        System.out.println(Rank.notationFrom(result));
    }

    private void showPurchaseInformation(List<Lotto> lottos) {
        System.out.printf("%d개를 구매했습니다.%n", lottos.size());
    }

    private void showLottosNotation(List<Lotto> lottos) {
        lottos.stream()
            .map(Lotto::getSortedNumbersByAscending)
            .map(this::convertLottoNotation)
            .forEach(System.out::println);
    }

    private String convertLottoNotation(List<Integer> numbers) {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }

}
