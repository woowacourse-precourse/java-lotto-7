package lotto.view;

import lotto.controller.LottoController;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.lang.Integer.parseInt;

public class UserView {
    private static final LottoController lottoController = new LottoController();

    public static void run() {
        buyingProcess();
    }

    private static void buyingProcess() {
        List<String> buyResult = lottoController.buyLotto(printAndGetPurchaseMoney());
        print(buyResult);
    }

    private static Integer printAndGetPurchaseMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return validateMoney(readLine());

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return printAndGetPurchaseMoney();
        }
    }

    private static Integer validateMoney(String s) {
        checkParsing(s);
        checkBlank(s);
        checkRange(s);
        checkChange(s);
        return parseInt(s);
    }

    private static void checkRange(String s) {
        if (parseInt(s) < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 구입금액은 1000원입니다.");
        }
    }

    private static void checkChange(String s) {
        if (parseInt(s) % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해주세요.");
        }
    }

    private static void checkBlank(String s) {
        if (s == null || s.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 구입금액을 입력해주세요.");
        }
    }

    private static void checkParsing(String s) {
        try {
            parseInt(s);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 문자열이 아닌 숫자를 입력해주세요.");
        }
    }

    private static void print(List<String> buyResult) {
        buyResult.forEach(System.out::println);
    }



}
