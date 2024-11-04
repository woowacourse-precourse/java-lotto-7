package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    private static final int THOUSAND_UNIT = 1000;
    private static final int START_MATCH = 3;
    public static void main(String[] args) {
        try {
            int[] matchCountArray = new int[8];
            // 구입 금액 입력 및 검증
            System.out.println("구입금액을 입력해 주세요.");
            int input_purchaseAmount = Integer.parseInt(Console.readLine());
            Lotto.validatePurchaseAmount(input_purchaseAmount);
            System.out.println("");

            // 로또 발행
            int lotto_count = input_purchaseAmount / THOUSAND_UNIT;
            List<Lotto> MyLotto = Lotto.create_Lotto(lotto_count);
            System.out.println("");

            // 당첨 번호 입력
            System.out.println("당첨 번호를 입력해 주세요.");
            String input_winningNumbers = Console.readLine();
            int[] winningNumbers = Lotto.parse_winNumberArray(input_winningNumbers);
            System.out.println("");

            // 보너스 번호 입력
            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());
            Lotto.validateNoDuplicatesBonusNumber(winningNumbers, bonusNumber);
            System.out.println("");

            System.out.println("당첨 통계");
            System.out.println("---");

            // 당첨 확인
            for (Lotto lotto : MyLotto) {
                Lotto.checkLottoMatch(lotto, winningNumbers, bonusNumber, matchCountArray);
            }
            for (int i = START_MATCH; i < matchCountArray.length; i++) {
                Lotto.printWinResult(i, matchCountArray[i]);
            }

            //전체 수익 계산
            int totalIncome = Lotto.calculateIncome(matchCountArray);

            //전체 수익률 계산
            Lotto.calculateROI(totalIncome, input_purchaseAmount);
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자를 입력해 주세요.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
