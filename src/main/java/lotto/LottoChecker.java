package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public LottoChecker() {
        this.winningNumbers = new ArrayList<>();
        this.bonusNumber = 0;
    }

    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String inputWinningNumbers = Console.readLine();
        System.out.println("보너스 번호를 입력해 주세요.");
        String inputBonusNumber = Console.readLine();
    }
}
