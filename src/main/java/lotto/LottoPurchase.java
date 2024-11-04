package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class LottoPurchase {
    private int purchaseAmount;
    private int purchaseCount;
    private WinningLotto winningLotto;

    public void inputAmount() {
        System.out.println("구입금액을 입력해주세요");
        String userInputAmount = Console.readLine();
        inputAmount(userInputAmount);
    }

    public void inputAmount(String userInputAmount) {
        if (!userInputAmount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
        int inputAmount = Integer.parseInt(userInputAmount);

        validateInputAmount(inputAmount);
        purchaseAmount = inputAmount;
        purchaseCount = inputAmount / 1000;
    }

    private void validateInputAmount(int inputAmount) {
        if (inputAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
        if (inputAmount < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입 금액은 1000원입니다.");
        }

    }

    public void inputLottoNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInputLottoNumber = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String userInputBonusNumber = Console.readLine();
        inputLottoNumber(userInputLottoNumber,userInputBonusNumber);

    }
    public void inputLottoNumber(String userInputLottoNumber,String userInputBonusNumber){
        if (!userInputLottoNumber.matches("^\\d+(?:,\\d+)*$")) {
            throw new IllegalArgumentException("[ERROR] 숫자와 쉼표만 입력해야 합니다.");
        }
        if (!userInputBonusNumber.matches("\\d+")){
            throw new IllegalArgumentException("보너스 번호는 숫자만 입력 가능합니다.");
        }
        winningLotto = new WinningLotto(splitLottoNumber(userInputLottoNumber),Integer.parseInt(userInputBonusNumber));
    }

    private List<Integer> splitLottoNumber(String userInputLottoNumber){
        return Arrays.stream(userInputLottoNumber.split(",")).map(Integer::parseInt).toList();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public WinningLotto getWinningLotto() {
        return winningLotto;
    }

    public int getPurchaseCount() {
        return purchaseCount;
    }
}
