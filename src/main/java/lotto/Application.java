package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");

        String inputAccount = Console.readLine();

        if (!inputAccount.matches("\\d+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 숫자만 입력하세요.");
        }

        int account = Integer.parseInt(inputAccount);
        if (account >= 1_000 && account <= 100_000) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 최소 1000원부터 최대 10만원입니다.");
        }

        if (account % 1_000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위로 입력하세요.");
        }

        int lottoCount = account / 1_000;


    }
}
