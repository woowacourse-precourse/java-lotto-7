package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Lotto;

public class InputView {

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());
        //1000원 단위 검증
        return purchaseAmount / 1000;
    }

    public Lotto getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");

        String[] winningNumberInput = Console.readLine().split(","); //","를 상수로
        List<Integer> winningLotto = convertArrayToList(winningNumberInput);

        return new Lotto(winningLotto);
    }

    public int getBonusNumber() {
        return Integer.parseInt(Console.readLine());
    }

    private List<Integer> convertArrayToList(String[] array) {
        List<Integer> list = new ArrayList<>();
        for (String number: array) {
            list.add(Integer.parseInt(number));
        }
        return list;
    }
}
