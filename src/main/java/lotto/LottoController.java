package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class LottoController {
    public void run() {
        int lottoCount = repeatUntilSuccess(this::getLottoPurchaseAmount);
        List<Lotto> lottoList = repeatUntilSuccess(() -> Lotto.issueLottoList(lottoCount));
        printLottoList(lottoList);
        List<Integer> winningNumbers = repeatUntilSuccess(this::getWinningNumbers);
        winningNumbers.add(repeatUntilSuccess(this::getBonusNumber));
        printWinningStatistics(lottoList, winningNumbers);
    }

    private <T> T repeatUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get(); // 성공 시 결과 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printWinningStatistics(List<Lotto> lottoList, List<Integer> winningNumbers) {

        LottoService lottoService = new LottoService();

        Map<Integer, Integer> stat = lottoService.calcWinningStatistics(lottoList, winningNumbers);
        double returnRate = lottoService.calcReturnRate(stat, lottoList.size());
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + stat.getOrDefault(5, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + stat.getOrDefault(4, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + stat.getOrDefault(3, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + stat.getOrDefault(2, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + stat.getOrDefault(1, 0) + "개");
        System.out.println("총 수익률은 " + returnRate + "%입니다.");
    }

    private void printLottoList(List<Lotto> lottoList) {
        System.out.println(lottoList.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottoList) {
            lotto.printNumbers();
        }
        System.out.println();
    }

    private int getLottoPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int purchaseAmount = parseInt(input);
        if (purchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 입력된 금액이 1,000원으로 나누어 떨어지지 않습니다.");

        }

        return purchaseAmount / 1000;
    }

    private List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] inputList = Console.readLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String input : inputList) {
            int number = parseInt(input);
            validateLottoNumber(number);
            winningNumbers.add(number);
        }
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        return winningNumbers;
    }

    private void validateLottoNumber(int winningNumber) {
        if (winningNumber < 1 || winningNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 1과 45 사이의 값이 아닙니다.");
        }
    }

    private int parseInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력된 값이 정수가 아닙니다.");
        }
    }

    private int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine();
        int bonusNumber = parseInt(input);
        validateLottoNumber(bonusNumber);
        System.out.println();
        return bonusNumber;
    }

}
