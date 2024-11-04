package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

public class LottoView {
    private List<Integer> winningNumbersStored;

    public int readPurchaseAmount() throws IllegalArgumentException {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            String purchaseAmountRawtext = Console.readLine();
            int amount = Integer.parseInt(purchaseAmountRawtext);
            System.out.println();

            return amount;
        } catch (NumberFormatException npe) {
            throw new IllegalArgumentException("[ERROR] 입력하신 구입금액은 숫자가 아닙니다. 숫자만 입력해 주세요.");
        }
    }

    public List<Integer> readWinningNumbers() throws IllegalArgumentException {
        try {
            System.out.println("당첨 번호를 입력해 주세요.");
            String winningNumbersRawtext = Console.readLine()
                                                    .replace(" ", "");

            List<String> winningNumbersSplitted = Arrays.asList(winningNumbersRawtext.split(","));
            List<Integer> winningNumbers = winningNumbersSplitted.stream().map(Integer::parseInt).collect(Collectors.toList());
            this.winningNumbersStored = winningNumbers;

            if (winningNumbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 당첨 번호는 총 6자리를 입력해야 합니다.");
            }

            System.out.println();
            return winningNumbers;
        } catch (NumberFormatException npe) {
            throw new IllegalArgumentException("[ERROR] 입력하신 당첨 번호가 숫자가 아닙니다. 숫자만 입력해 주세요.");
        } 
    }

    public int readBonusNumber() throws IllegalArgumentException {
        try {
            System.out.println("보너스 번호를 입력해 주세요.");
            String bonusNumberRawtext = Console.readLine();
            int bonusNumber = Integer.parseInt(bonusNumberRawtext);

            if (this.winningNumbersStored.contains(bonusNumber)) {
                throw new IllegalArgumentException("[ERROR] 입력하신 보너스 번호가 당첨 번호 중 하나와 중복됩니다.");
            }
            
            System.out.println();

            return bonusNumber;
        } catch (NumberFormatException npe) {
            throw new IllegalArgumentException("[ERROR] 입력하신 보너스 번호가 숫자가 아닙니다. 숫자만 입력해 주세요.");
        }
    }

    public void printIssuedLottos(int purchaseCount, List<Lotto> lottos) {
        System.out.println(purchaseCount + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            List<Integer> lottoNumbers = lotto.getNumbers();
            System.out.println(lottoNumbers);
        }
        System.out.println();
    }

    public void printErrorMessage(String msg) {
        System.out.println(msg);
        System.out.println();
    }
    
}
