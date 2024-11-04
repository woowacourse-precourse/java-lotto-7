package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Application {

    public static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력 형식입니다.";

    public static List<Integer> parseInt(String input) {
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private static int getValidPurchaseAmount() {
        while (true) {
            try {
                System.out.println("구입금액을 입력해 주세요.");
                String purchaseAmountInput = Console.readLine();
                int purchaseAmount = Integer.parseInt(purchaseAmountInput);
                return purchaseAmount;
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_MESSAGE);
                // 입력값이 잘못되었으면 재귀 함수 이용해서 다시 물어봄.
                return getValidPurchaseAmount();
            }
        }
    }

    public static void printMyLottos() {
        List<Lotto> myLottoNumbers = LottoRepository.getInstance().findAll();
        for (Lotto lotto : myLottoNumbers) {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            Collections.sort(sortedNumbers);
            System.out.println(sortedNumbers);
        }
    }

    public static int calculateTicketCount(int purchaseAmount) {
        return purchaseAmount / Constant.LOTTO_PRICE;
    }

    public static String inputWinningNumber() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine();
    }

    public static int inputBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getValidPurchaseAmount();

        int ticketCount = calculateTicketCount(purchaseAmount);
        System.out.println(ticketCount + "개를 구매했습니다.");

        // 로또 머신에서 입력 받은 횟수만큼 로또를 돌리고 로또 저장소에 저장함.
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.generateLottoNumbers(ticketCount);

        // 로또들을 출력함 .
        printMyLottos();

        // 당첨번호 입력
        String input = inputWinningNumber();
        List<Integer> winningNumberInput = parseInt(input);

        // 보너스 번호 입력
        int bonusNumber = inputBonusNumber();

        WinningNumber winningNumber = new WinningNumber(winningNumberInput, bonusNumber);

        // 결과 산정
        LottoMatchingService lottoMatchingService = new LottoMatchingService();
        lottoMatchingService.checkLotto(winningNumber);
        lottoMatchingService.printResults(purchaseAmount);
    }
}
