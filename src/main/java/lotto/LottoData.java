package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class LottoData {
    private static final Integer MINIMUM_MONEY = 1000;

    private final List<Lotto> generatedLottos;
    private final List<Integer> userPickedNumbers;

    private final Integer bonusNumber;
    private final List<EnumLottoPrice> matches;

    private Long winningAmount = 0L;
    public LottoData(List<Lotto> generatedLottos, List<Integer> userPickedNumbers, Integer bonusNumber) {
        this.generatedLottos = generatedLottos;
        this.userPickedNumbers = userPickedNumbers;
        this.bonusNumber = bonusNumber;
        this.matches = new ArrayList<>();
    }

    public List<EnumLottoPrice> getMatches() {
        return Collections.unmodifiableList(matches);
    }

    public void produceStatistics() {
        for (Lotto lotto : this.generatedLottos) {
            Optional<EnumLottoPrice> match = lotto.findMatch(this.userPickedNumbers, this.bonusNumber);
            match.ifPresent(matches::add);
        }
        printMatchStatus();

        matches.forEach(enumLottoPrice -> this.winningAmount += (long) enumLottoPrice.getPrice());
        printRate();
    }

    private void printMatchStatus() {
        StringBuilder result = new StringBuilder();
        result.append("\n당첨 통계\n---\n");
        result.append("3개 일치 (5,000원) - ")
                .append(matches.stream().filter(enumLottoPrice -> enumLottoPrice.equals(EnumLottoPrice.MATCH_3))
                        .count()).append("개\n");
        result.append("4개 일치 (50,000원) - ")
                .append(matches.stream().filter(enumLottoPrice -> enumLottoPrice.equals(EnumLottoPrice.MATCH_4))
                        .count()).append("개\n");
        result.append("5개 일치 (1,500,000원) - ")
                .append(matches.stream().filter(enumLottoPrice -> enumLottoPrice.equals(EnumLottoPrice.MATCH_5))
                        .count()).append("개\n");
        result.append("5개 일치, 보너스 볼 일치 (30,000,000원) - ")
                .append(matches.stream().filter(enumLottoPrice -> enumLottoPrice.equals(EnumLottoPrice.MATCH_5_EXCEPT_BONUS))
                        .count()).append("개\n");
        result.append("6개 일치 (2,000,000,000원) - ")
                .append(matches.stream().filter(enumLottoPrice -> enumLottoPrice.equals(EnumLottoPrice.MATCH_6))
                        .count()).append("개\n");

        System.out.print(result);
    }

    private void printRate() {
        StringBuilder result = new StringBuilder();
        double value = ( (double) this.winningAmount / (generatedLottos.size() * MINIMUM_MONEY)) * 100;
        result.append("총 수익률은 ").append(String.format("%.1f", value)).append("%입니다.");

        System.out.println(result);
    }
}
