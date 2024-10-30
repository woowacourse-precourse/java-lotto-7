package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class LottoView {
    public int inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        // 출력 테스트 -- 추후 삭제 예정
        return Integer.parseInt(Console.readLine());
    }
}
