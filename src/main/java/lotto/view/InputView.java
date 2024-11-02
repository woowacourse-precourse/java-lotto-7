package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputPrice(){
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }

    public String winningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
        return Console.readLine(); // 추후 분할
    }

    public int bonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        return Integer.parseInt(Console.readLine());
    }
}
