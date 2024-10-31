package lotto;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static java.util.Arrays.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Application {
    // TODO: View class에 상수 정리
    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String AFTER_PURCHASE_AMOUNT_GUIDE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_GUIDE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_GUIDE = "보너스 번호를 입력해 주세요.";

    private static final String STATISTICS_RESULT = "당첨 통계\n" + "---";
    private static final String DELIMITER = ",";

    private static final int PURCHASE_UNIT = 1000;

    public static void main(String[] args) {
        System.out.println(PURCHASE_AMOUNT_GUIDE);
        int purchaseAmount = Integer.parseInt(readLine()); // TODO: 음수 검증 //"[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
        System.out.println("\n" + purchaseAmount/PURCHASE_UNIT + AFTER_PURCHASE_AMOUNT_GUIDE);
        List<Lotto> lottos = IntStream.range(0, purchaseAmount/PURCHASE_UNIT) // TODO: 1000원 단위 검증
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(1, 45, 6))).toList();
        lottos.stream().forEach(lotto -> System.out.println(lotto.toString()));
        System.out.println("\n" + WINNING_NUMBERS_GUIDE);
        List<Integer> winningNumbers = stream(readLine().split(DELIMITER, -1)).map(Integer::parseInt).toList(); // TODO: 중복 검증 // TODO: 1 ~ 45 범위 검증
        // TODO: "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
        System.out.println("\n" + BONUS_NUMBER_GUIDE);
        int bonusNumber = Integer.parseInt(readLine()); // TODO: 1 ~ 45 범위 검증 // TODO: 중복 검증
        // TODO: "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
        List<Prize> prizes = setPrize();
        getStatistics(prizes, lottos, winningNumbers, bonusNumber);
        int wholeCashPrize = 0;
        for (Prize prize : prizes) {
            if (prize.getLottoQuantity() > 0) {
                wholeCashPrize += prize.getCashPrize() * prize.getLottoQuantity();
            }
            System.out.println(prize.matchCount + "개 일치 (" +  prize.getCashPrize() + "원) - " + prize.getLottoQuantity() + "개");
        }
        System.out.println("총 수익률은 " + String.format("%.2f", (((double)wholeCashPrize / (double)purchaseAmount) * 100)) + "입니다.");
    }

    private static void getStatistics(List<Prize> prizes, List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        // lotto 배열을 순회하면서 일치하는 숫자 검증하고, bonus 숫자 매칭 확인하고 Prize의 lottoQuantity 증가시키기
        for (Lotto lotto: lottos) {
            Integer count = (int)lotto.getNumbers().stream().filter(number -> winningNumbers.contains(number)).count();
            if (count.equals(6)) {
                prizes.get(4).increaseLottoQuantity();
            } else if (lotto.getNumbers().contains(bonusNumber)) {
                prizes.get(3).increaseLottoQuantity();
            } else if (count.equals(5)) {
                prizes.get(2).increaseLottoQuantity();
            } else if (count.equals(4)) {
                prizes.get(1).increaseLottoQuantity();
            } else if (count.equals(3)) {
                prizes.get(0).increaseLottoQuantity();
            }
        }
    }

    private static List<Prize> setPrize() {
        List<Prize> prizes = new ArrayList<>();
        prizes.add(new Prize(3, 5_000));
        prizes.add(new Prize(4, 50_000));
        prizes.add(new Prize(5, 1_500_000));
        prizes.add(new Prize(5, 30_000_000));
        prizes.add(new Prize(6, 2_000_000_000));
        return prizes;
    }

    static class Prize {
        private final int matchCount;
        private final int cashPrize;
        private int lottoQuantity;
        Prize(int matchCount, int cashPrize) {
            this.matchCount = matchCount;
            this.cashPrize = cashPrize;
            this.lottoQuantity = 0;
        }
        int getMatchCount() {
            return this.matchCount;
        }

        int getCashPrize() {
            return  this.cashPrize;
        }

        int getLottoQuantity() {
            return this.lottoQuantity;
        }

        void increaseLottoQuantity() {
            this.lottoQuantity++;
        }
    }
}



