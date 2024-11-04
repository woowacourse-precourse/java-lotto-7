package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
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

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int purchaseAmount = getValidPurchaseAmount();

        int ticketCount = purchaseAmount / Constant.LOTTO_PRICE;

        System.out.println(ticketCount + "개를 구매했습니다.");

        // 로또 머신에서 입력 받은 횟수만큼 로또를 돌리고 로또 저장소에 저장함.
        LottoMachine lottoMachine = new LottoMachine();
        lottoMachine.generateLottoNumbers(ticketCount);

        // 로또들을 출력함 .
        List<Lotto> myLottoNumbers = LottoRepository.getInstance().findAll();
        for (Lotto lotto : myLottoNumbers) {
            System.out.println(lotto);
        }

        // 당첨번호 입력
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();

        List<Integer> winningNumberInput = parseInt(input);

        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());

        WinningNumber winningNumber = new WinningNumber(winningNumberInput, bonusNumber);

        LottoMatchingService lottoMatchingService = new LottoMatchingService();
        lottoMatchingService.checkLotto(winningNumber);
        lottoMatchingService.printResults(purchaseAmount);
    }
}
