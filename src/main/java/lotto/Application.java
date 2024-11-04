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
            List<List<Integer>> numbers = makeRandomNumbers(purchaseAmount);
            List<Integer> lottoNumbers = getLottoNumbers();

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static List<List<Integer>> makeRandomNumbers(int purchaseAmount) {
        List<List<Integer>> randomNumberList = new ArrayList<>();
        for (int i = 0; i < purchaseAmount; i++) {
            List<Integer> randomNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            randomNumbers.sort(Integer::compareTo);
            System.out.println(randomNumbers);
            randomNumberList.add(randomNumbers);
        }
        return randomNumberList;
    }

    private static List<Integer> getLottoNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        List<Integer> lottoNumbers = new ArrayList<>();
        String[] numbers = input.split(",");

        for (String number : numbers) {
            lottoNumbers.add(Integer.parseInt(number.trim()));
        }
        lottoNumbers.sort(Integer::compareTo);
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusInput = Console.readLine();

        Integer bonusNumber = Integer.parseInt(bonusInput.trim());
        lottoNumbers.add(bonusNumber);

        return lottoNumbers;
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
