package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;


public class LottoMachine {

    private final Set<Integer> winningNumbersSet = new HashSet<>();
    private final List<Lotto> lottoList = new ArrayList<>();
    private final List<Integer> winningNumbers = new ArrayList<>();

    public LottoMachine(){
        generateLottoNumbers();
        getWinningNumbers();
    }

    private int buy() {
        System.out.println("구입 금액을 입력해 주세요.");
        while (true) {
            try {
                int amount = Integer.parseInt(Console.readLine());
                validateAmount(amount);
                return (amount / 1000);
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자로만 입력해주세요.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateAmount(int amount) {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }

        if(amount < 0 || amount == 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 이상이어야 합니다.");
        }
    }

    private void generateLottoNumbers(){
        int lottoTicketCount = buy();
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
        for (int i = 0; i < lottoTicketCount; i++) {
            List<Integer> randomNumber = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottoList.add(new Lotto(randomNumber));
            System.out.println(randomNumber);
        }
    }

    private String[] inputWinningNumbers(){
        while (true) {
            winningNumbersSet.clear();
            System.out.println("당첨 번호를 입력해주세요.");
            String inputNumbers = Console.readLine();
            
            try {
                validateInputWinningNumbers(inputNumbers);
                return inputNumbers.split(",");
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자와 쉼표(,)로만 입력해주세요");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateInputWinningNumbers(String inputNumbers) {
        String[] numbers = inputNumbers.split(",");

        if (numbers.length != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개만 입력 가능합니다.");
        }

        for (String number : numbers) {
            int num = Integer.parseInt(number.trim());
            if (num < 1 || num > 45) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 1부터 45 사이여야 합니다.");
            }
            if (!winningNumbersSet.add(num)) {
                throw new IllegalArgumentException("[ERROR] 중복된 숫자가 입력되었습니다: " + num);
            }
        }
    }


    private String inputBonusNumber() {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumber = Console.readLine();

            try {
                validateBonusNumber(bonusNumber);
                return bonusNumber;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력하세요");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(String bonusNumber) {
        int num = Integer.parseInt(bonusNumber.trim());
        if (num < 1 || num > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이여야 합니다.");
        }
        if (winningNumbersSet.contains(num)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다: " + num);
        }
    }

    private void getWinningNumbers() {
        String[] winningNumbersArray = inputWinningNumbers();

        for (String number : winningNumbersArray) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        winningNumbers.add(Integer.parseInt(inputBonusNumber()));
    }


}
