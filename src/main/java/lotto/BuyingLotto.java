package lotto;

import camp.nextstep.edu.missionutils.Console;

public class BuyingLotto {
    public void PayforLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = "";

        try {
            inputMoney = Console.readLine();
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException("구입금액이 입력되지 않았습니다.");
        }

        return inputMoney;
    }

    public void BuyforLotto() {
        int CountLotto = ConvertLotto();
        System.out.print(CountLotto);
        System.out.println("개를 구매했습니다.");
    }

    public int ConvertLotto() {
        String inputMoney = PayforLotto();
        int convertInt = ConvertInteger(inputMoney);
        int convertLotto = convertInt/1000;

        return convertLotto;
    }

    public int ConvertInteger(String BuyforLotto) {
        try {
            int convertInt = Integer.parseInt(inputMoney.trim())
        } catch {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위의 정수로 입력할 수 있습니다.");
        }

        if (!(convertInt%1000)) {
            throw new IllegalArgumentException("로또 구입 금액은 1000원 단위로 입력할 수 있습니다.");
        }

        return convertInt;
    }
}
