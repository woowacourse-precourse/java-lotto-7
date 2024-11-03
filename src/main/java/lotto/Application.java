package lotto;

import camp.nextstep.edu.missionutils.Console;


public class Application {
    static String introduction = "구입 금액을 입력해 주세요.";

    public static void spaceString() {
        System.out.println();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(introduction);
        String money = Console.readLine();
        Customer customer = new Customer(money);
        spaceString();
        System.out.println(customer.getLottoCount() + "개를 구매했습니다");
        LottoNumberProducer producer = new LottoNumberProducer(customer.getLottoCount());
        producer.createRandomNumbers();
        producer.displayLottoNumbers();
    }
}
