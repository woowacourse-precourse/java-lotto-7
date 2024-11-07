package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoMachine {
    public void validateMoney(String str) {
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if(str.charAt(i) < '0' || str.charAt(i) > '9') {
                throw new IllegalArgumentException("[ERROR] 금액은 숫자로 입력해주세요.");
            }
        }
    }

    public void enterPay(Customer customer) {
        try{
            System.out.println("구입금액을 입력해 주세요.");
            String str = Console.readLine();
            validateMoney(str);
            int count = Integer.parseInt(str)/1000;
            System.out.println(count + "개를 구매했습니다.");
            customer.count = count;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            enterPay(customer);
        }
    }

    public void buyLotto(Customer customer) {

        for (int i = 0; i < customer.count; i++) {
            Lotto lotto = new Lotto( Randoms.pickUniqueNumbersInRange(1,45,6));
            lotto.printLottoNumber();
            customer.myLotto.add(lotto);
        }


    }
}
