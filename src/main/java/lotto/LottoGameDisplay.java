package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import lotto.validator.LottoGameValidator;

public class LottoGameDisplay {

    private static final String ERROR_MESSAGE_PREFIX = "[ERROR] ";

    public int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        while (true) {
            try {
                int money = inputNumber();

                LottoGameValidator.checkMoneyValid(money);

                return money;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public List<Integer> inputWinnerNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");

        while (true) {
            try {
                List<Integer> winNumbers = inputNumbers(",");
                LottoGameValidator.checkWinNumbersValid(winNumbers);

                return winNumbers;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }
    }

    public int inputBonusNumber(List<Integer> winnerNumbers) {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");

        while (true) {
            try {
                int bonus = inputNumber();
                LottoGameValidator.checkBonusValid(bonus, winnerNumbers);

                return bonus;
            } catch (IllegalArgumentException e) {
                printErrorMessage(e);
            }
        }

    }

    private int inputNumber() {
        String rawNumber = Console.readLine();

        LottoGameValidator.checkIsBlank(rawNumber);
        LottoGameValidator.checkIsNumeric(rawNumber);

        return Integer.parseInt(rawNumber);
    }

    private List<Integer> inputNumbers(String separator) {
        String rawNumberMess = Console.readLine();
        LottoGameValidator.checkIsBlank(rawNumberMess);

        List<String> rawNumbers = Arrays.stream(rawNumberMess.split(separator))
                .map(String::strip)
                .toList();

        for (String rawNum : rawNumbers) {
            LottoGameValidator.checkIsNumeric(rawNum);
        }

        return rawNumbers.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private void printErrorMessage(Exception e) {
        System.out.println(ERROR_MESSAGE_PREFIX + e.getMessage());
    }

    public void printPurchaseBreakdown(List<Lotto> lottos) {
        System.out.println();
        System.out.printf("%d개를 구매했습니다.\n", lottos.size());

        for (Lotto lotto : lottos) {
            printLotto(lotto);
        }
    }

    public void printLotto(Lotto lotto) {
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = lotto.getNumbers();
        Collections.sort(numbers);

        sb.append("[");
        for (int i = 0; i < numbers.size() - 1; i++) {
            sb.append(numbers.get(i).toString());
            sb.append(", ");
        }
        sb.append(numbers.getLast());
        sb.append("]");

        System.out.println(sb);
    }

    public void printWinStatistics(Map<LottoRank, Integer> rankMap, double rateOfResult) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        printRankBreakdown(rankMap);
        printRateOfResult(rateOfResult);
    }

    private void printRankBreakdown(Map<LottoRank, Integer> rankMap) {
        List<LottoRank> printLottoRanks = List.of(
                LottoRank.GRADE_5TH,
                LottoRank.GRADE_4TH,
                LottoRank.GRADE_3TH,
                LottoRank.GRADE_2TH,
                LottoRank.GRADE_1TH
        );

        for (LottoRank lottoRank : printLottoRanks) {
            System.out.printf("%s (%,d%s) - %d개\n",
                    lottoRank.getWinCondition(),
                    lottoRank.getPrizeMoney(), LottoRank.UNIT,
                    rankMap.get(lottoRank)
            );
        }
    }

    private void printRateOfResult(double rateOfResult) {
        // 둘째자리에서 반올림하여 출력
        double result = Math.round(rateOfResult * 100) / 100.0;
        System.out.printf("총 수익률은 %,.1f%%입니다.", result);
    }
}
