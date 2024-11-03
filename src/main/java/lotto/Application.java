package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.publishingLotto.model.Lotto;

public class Application {
    public static void main(String[] args) {
        System.out.println("구매금액을 입력해 주세요.");
        int payment = Integer.parseInt(readLine());
        int numberOfTicket = payment / 1_000;
        System.out.println();
        System.out.println(numberOfTicket + "개를 구매했습니다.");

        // 구매자 로또티켓 생성
        List<Lotto> PurchasedLottoTickets = new ArrayList<>();
        for (int i = 0; i < numberOfTicket; i++) {
            PurchasedLottoTickets.add(publishLottoTicket());
        }

        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = readLine();

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int inputWinningBonusNumber = Integer.parseInt(readLine()); //유효성 검사 추가해야함

        // 당첨번호 정리
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber : inputWinningNumbers.split(",")) {
            winningNumbers.add(Integer.valueOf(winningNumber));
        }
        Collections.sort(winningNumbers);

        // 당첨 확인
        List<Integer> numberOfMatches = PurchasedLottoTickets.stream()
                .map(lotto -> (int) lotto.getNumbers().stream()
                        .filter(winningNumbers::contains)
                        .count())
                .collect(Collectors.toList());

        // 보너스 당첨 확인
        for (int i = 0; i < numberOfTicket; i++) {
            if(numberOfMatches.get(i) == 5) {
                numberOfMatches.set(i, matchBonusNumber(PurchasedLottoTickets.get(i), inputWinningBonusNumber));
            }
        }

        // 당첨 통계 확인
        System.out.println();
        Map<Integer, Integer> ranks = checkWinningRank(numberOfMatches);
        double rateOfReturn = calculateRateOfReturn(ranks, payment);
        System.out.println("총 수익률은 " + rateOfReturn + "%입니다.");
    }

    // 추가 기능
    public static Lotto publishLottoTicket() {
        List<Integer> publishedNumber = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        System.out.println(publishedNumber);
        return new Lotto(publishedNumber);
    }

    public static int matchBonusNumber(Lotto fiveMatchesTicket, int inputBonusNumber) {
        boolean isMatchedWithBonus = fiveMatchesTicket.getNumbers().stream().anyMatch(number -> number == inputBonusNumber);
        if(isMatchedWithBonus) {
            return 10;
        }
        return 5;
    }

    public static Map<Integer, Integer> checkWinningRank(List<Integer> numberOfMatches) {
        int firstRank = Collections.frequency(numberOfMatches, 6);
        int secondRank = Collections.frequency(numberOfMatches, 10);
        int thirdRank = Collections.frequency(numberOfMatches, 5);
        int fourthRank = Collections.frequency(numberOfMatches, 4);
        int fifthRank = Collections.frequency(numberOfMatches, 3);

        Map<Integer, Integer> ranks = new HashMap<>(5);
        ranks.put(firstRank, 2_000_000_000);
        ranks.put(secondRank, 3_000_000);
        ranks.put(thirdRank, 1_500_000);
        ranks.put(fourthRank, 50_000);
        ranks.put(fifthRank, 5_000);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + fifthRank + "개");
        System.out.println("4개 일치 (50,000원) - " + fourthRank + "개");
        System.out.println("5개 일치 (1,500,000원) - " + thirdRank + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + secondRank + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + firstRank + "개");

        return ranks;
    }

    public static double calculateRateOfReturn(Map<Integer, Integer> ranks, int payment) {
        double sum = 0;
        for (int numberOfWinning : ranks.keySet()) {
            sum += numberOfWinning * ranks.get(numberOfWinning);
        }

        sum /= payment;
        sum *= 100;

        return Math.round(sum * 100) / 100.0;
    }
}
