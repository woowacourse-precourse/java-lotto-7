package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String error_message = "[ERROR]";

    public static void main(String[] args) {
        try {
            int purchaseAmount = getPurchaseAmount();
            List<List<Integer>> lottoNumbers = makeLottoNumbers(purchaseAmount);
            List<Integer> winningNumbers = getWinningNumbers();


        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<List<Integer>> makeLottoNumbers(int purchaseAmount) {
        List<List<Integer>> lottoNumbersList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottoNumbers.sort(Integer::compareTo);
            System.out.println(lottoNumbers);
            lottoNumbersList.add(lottoNumbers);
        }
        return lottoNumbersList;
    }

    private static List<Integer> getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        String[] numbers = input.split(",");

        for (String number : numbers) {
                winningNumbers.add(Integer.parseInt(number.trim()));
        }
        winningNumbers.sort(Integer::compareTo);
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();

        Integer bonusNumber = Integer.parseInt(bonusInput.trim());
        winningNumbers.add(bonusNumber);

        return winningNumbers;
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            String input = Console.readLine();
            int purchaseAmount = Integer.parseInt(input);
            if (purchaseAmount % 1000 != 0){
                throw new IllegalArgumentException(error_message + "로또 구입 금액은 1,000 단위로 나누어 떨어져야 합니다.");
            }
            int numTickets = purchaseAmount / 1000;
            System.out.println(numTickets + "개를 구매했습니다.");
            return numTickets;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(error_message + "로또 금액은 숫자여야 합니다.");
        }
    }
}
