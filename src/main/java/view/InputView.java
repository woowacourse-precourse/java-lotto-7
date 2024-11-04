package view;

//당첨 통계
//---
//        3개 일치 (5,000원) - 1개
//4개 일치 (50,000원) - 0개
//5개 일치 (1,500,000원) - 0개
//5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
//6개 일치 (2,000,000,000원) - 0개
//총 수익률은 62.5%입니다.


import camp.nextstep.edu.missionutils.Console;

//구입금액을 입력해 주세요.
//8개를 구매했습니다.
//당첨 번호를 입력해 주세요.
//보너스 번호를 입력해 주세요.
public class InputView {
    Messages messages;

    public String getCost() {
        System.out.println(messages.PAYMENT_INPUT_MSG.getMessage());
        return Console.readLine();
    }

    public String getLottoNumbers(){
        System.out.println(messages.LOTTO_INPUT_MSG.getMessage());
        return Console.readLine();
    }

}
