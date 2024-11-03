package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.model.Lotto;


public class ConsoleView {
    public Integer getPurchaseLottoAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        Integer purchaseAmount = Integer.parseInt(Console.readLine());
        System.out.println();
        return purchaseAmount;
    }

    public List<Integer> getWinningNumbers() { // 숫자가 아닌 값이면 예외
        System.out.println("당첨 번호를 입력해 주세요.");
        String userInputWinningNumbers = Console.readLine();
        System.out.println();
        return Arrays.stream(userInputWinningNumbers.split(",")).map(Integer::parseInt).toList();
    }

    public Integer getBonusNumber() { // 한글자의 숫자가 아니면 예외
        System.out.println("보너스 번호를 입력해 주세요.");
        Integer bonusNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        return bonusNumber;
    }

    public void printIssuedLotto(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");

        for (Lotto lotto: lottos) {
            System.out.println(lotto.getLottoNumbers().stream().sorted().toList());
        }
        System.out.println();
    }
}
