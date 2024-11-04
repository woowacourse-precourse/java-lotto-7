package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.*;
import java.util.stream.Collectors;

public class LottoView {

    public static int getInputCash() {
        System.out.println("구입금액을 입력해 주세요.");
        int inputCash = Integer.parseInt(Console.readLine());
        return inputCash;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputNumbers = Console.readLine();

        List<Integer> winningNumbers = Arrays.stream(inputNumbers.replace(" ", "").split(",", -1))
                .map(Integer::parseInt)
                .peek(number -> {
                    if (number < 1 || number > 45) {
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                })
                .collect(Collectors.toList());
        return winningNumbers;
    }

    public static Integer getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(Console.readLine());
        // 유효성 검증 필요
        return bonusNumber;
    }

    public static void printLottos(int lottoCount, List<Lotto> lottos) {
        System.out.println(lottoCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            String lottoFormat = lotto.getNumbers().stream()
                    .map(String::valueOf)
                    .collect(Collectors.joining(", ", "[", "]"));
            System.out.println(lottoFormat);
        }
    }

    public static void printLottoResult(Map<LottoRank, Integer> rankCount) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {

            if (rank == LottoRank.SECOND) {
                System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n",
                        rank.getMatchCount(),
                        String.format("%,d", rank.getPrize()),
                        rankCount.get(rank));
                continue;
            }

            System.out.printf("%d개 일치 (%s원) - %d개%n",
                    rank.getMatchCount(),
                    String.format("%,d", rank.getPrize()),
                    rankCount.get(rank));

        }
    }

    public static void printReturnRate(int totalPrize, int inputCash) {
        System.out.printf("총 수익률은 %.1f%%입니다.", (double) totalPrize / inputCash * 100);
    }
}
