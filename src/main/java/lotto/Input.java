package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Input {
    public static int parseMoney(String input) {
        if (!input.matches("[+-]?\\d*(\\.\\d+)?")) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
        }
        int money = Integer.parseInt(input);
        if (money % LottoInfo.price != 0 || money <= 0) {
            throw new IllegalArgumentException("[ERROR] " + LottoInfo.price + "의 양의 배수만 입력하세요");
        }

        return money;
    }

    public static Lotto parseWinningLotto(String input) {
        int maxNumLength = Integer.toString(LottoInfo.endNumber).length();
        int maxInputLength = maxNumLength * LottoInfo.count + LottoInfo.count - 1;
        if (input.length() > maxInputLength) { // 최대 길이 : 두 자리 숫자 6개가 뽑혔을때 17
            throw new IllegalArgumentException("[ERROR] 입력이 너무 깁니다.");
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i)) && input.charAt(i) != ',') {
                throw new IllegalArgumentException("[ERROR] 숫자와 쉼표 외의 문자는 입력할 수 없습니다.");
            }
        }
        if (input.charAt(input.length() - 1) == ',') {
            throw new IllegalArgumentException("[ERROR] 쉼표는 숫자 사이에 하나씩만 입력하세요.");
        }
        String[] numberArr = input.split(",");
        List<Integer> numbers = new ArrayList<>();

        for (String number : numberArr) {
            if (number.isEmpty()) {
                throw new IllegalArgumentException("[ERROR] 쉼표는 숫자 사이에 하나씩만 입력하세요.");
            }
            numbers.add(Integer.parseInt(number));
        }

        return new Lotto(numbers);
    }

    public static int parseBonusNumber(String input, ParamDto.WinningLottoNumbers winningLottoInfo) {
        if (input.length() > Integer.toString(LottoInfo.endNumber).length()) {
            throw new IllegalArgumentException("[ERROR] 입력이 너무 깁니다.");
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 숫자만 입력하세요.");
            }
        }
        int bonusNumber = Integer.parseInt(input);
        if (bonusNumber > LottoInfo.endNumber || bonusNumber < LottoInfo.startNumber){
            throw new IllegalArgumentException(
                    "[ERROR] 로또 번호는 " + LottoInfo.startNumber + "~" + LottoInfo.endNumber + " 사이여야 합니다.");
        }
        if (winningLottoInfo.numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return bonusNumber;
    }

    public static <T, U> T validate(U additionalParam, BiFunction<String, U, T> inputFunction) {
        while (true) {
            try {
                String input = Console.readLine();
                return inputFunction.apply(input, additionalParam);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
