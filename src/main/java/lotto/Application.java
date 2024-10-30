package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int price = Integer.parseInt(Console.readLine());
        if (price % 1000 != 0)
            System.out.println("천원단위만 입력하세요");

        int total = price / 1000;

        LottoList lottoList = new LottoList(total);

        System.out.println(lottoList.getLottoList().size());
        for (Lotto lotto : lottoList.getLottoList()) {
            System.out.println(lotto.getNumbers());
        }
    }
}
