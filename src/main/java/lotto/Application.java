package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> lottoNumbers = Lotto.generateLottoNumbers();
        System.out.println("생성된 로또 번호: " + lottoNumbers);

        // 구매 금액 입력 처리
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        int amount = LottoGame.validatePurchaseAmount(input);
        System.out.println("구입 금액: " + amount + "원");
    }
}
