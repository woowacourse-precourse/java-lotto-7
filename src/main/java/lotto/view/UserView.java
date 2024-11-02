package lotto.view;

import lotto.controller.LottoController;

import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.*;
import static java.lang.Integer.*;
import static lotto.view.InputTypeWithValidation.*;

public class UserView {
    private static final LottoController lottoController = new LottoController();

    public static void run() {
        buyingProcess();
        confirmWinningProcess();
    }

    private static void buyingProcess() {
        int parsedInt = parseInt(receive(MONEY));
        List<String> buyResult = lottoController.buyLotto(parsedInt);
        print(buyResult);
    }

    private static void confirmWinningProcess() {
        List<String> winning = Arrays.stream(receive(WINNING_NUMS).split(",")).toList();
        String bonus = receive(BONUS_NUM);
        checkDuplicateWithBonus(winning, bonus);
        //TODO: bonus가 winning에 있을 때 winning을 다시 받는 오류 수정 - bonus만 다시 받아야함
        List<String> confirmResult = lottoController.confirmWinnings(winning, bonus);
        print(confirmResult);
    }

    // 타입에 따라 Integer (money, bonus), List<Integer> (winning nums) 반환
    // 타입에 따라 입력 받은 값을 검증하고, 검증에 실패하면 재귀 호출(다시 입력)
    private static String receive(InputTypeWithValidation type) {
        System.out.println(type.getMessage());
        try {
            return type.validate(readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return receive(type);
        }
    }

    private static void checkDuplicateWithBonus(List<String> winning, String bonus) {
        try {
            if (winning.contains(bonus)) {
                throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            confirmWinningProcess();
        }
    }

    private static void print(List<String> result) {
        result.forEach(System.out::println);
    }


}
