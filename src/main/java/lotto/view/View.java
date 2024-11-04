package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.LottoResult;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class View {
    public String getInputAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return readLineWithBlank();
    }

    public String getInputWinnerNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        return readLineWithBlank();
    }
    public String getInputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        return readLineWithBlank();
    }

    private String readLineWithBlank() {
        String input = Console.readLine();
        System.out.println();
        return input;
    }
    public void printBuyingLottoCount(long amount) {
        long count = amount / 1000;
        System.out.printf("%d개를 구매했습니다.", count);
        System.out.println();
    }
    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public void printLotto(Lotto lotto) {
        String lottoNumbers = lotto.getNumbers().stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println("[" + lottoNumbers + "]");
    }

    public void printLottoResults(LottoResult result) {
        System.out.println("당첨 통계");
        System.out.println("---");

        NumberFormat numberFormat = NumberFormat.getInstance(Locale.KOREA);

        for (LottoRank rank : LottoRank.values()) {
            if (rank == LottoRank.MISS) {
                continue;
            }
            int count = result.getRankCounts().get(rank);
            String prize = numberFormat.format(rank.getPrize());
            System.out.printf("%s (%s원) - %d개%n", rank.getDescription(), prize, count);
        }
        System.out.printf("총 수익률은 %.1f%%입니다.%n", result.getProfitRate());

    }

}
