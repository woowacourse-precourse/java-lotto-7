package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    // 1. 프로그램 시작 및 예외 처리 루프
    public static void main(String[] args) {
        while (true) {
            try {
                run();
                break; 
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    // 2. 전체 실행 흐름 제어
    private static void run() {
        System.out.println("구매금액을 입력해 주세요.");
        String cost = Console.readLine();
        int num = parsePurchaseAmount(cost) / 1000;
        checkMinimumPurchaseAmount(num * 1000);

        List<List<Integer>> lottoBoxes = getLottoNumbers(num);

        System.out.println("\n당첨번호를 입력해주세요");
        Lotto lotto = new Lotto(parseLottoNumbers(Console.readLine()));

        System.out.println("\n보너스 번호를 입력해주세요");
        int bonusBall = getValidBonusBall();

        checkLottoResults(lottoBoxes, lotto, bonusBall, num);
    }

    // 3. 구매금액 처리
    private static int parsePurchaseAmount(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "잘못된 입력입니다. 숫자를 입력해 주세요.");
        }
    }

    private static void checkMinimumPurchaseAmount(int cost) {
        if (cost < 1000) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또는 1장에 1000원입니다.");
        }
    }

    // 4. 로또 번호 생성
    public static List<List<Integer>> getLottoNumbers(int num) {
        System.out.println(num + "개를 구매했습니다.");
        List<List<Integer>> lottoBoxes = initializeLottoBoxes(num);

        for (int i = 0; i < num; i++) {
            lottoBoxes.get(i).addAll(lottoRandomizer());
            Collections.sort(lottoBoxes.get(i));
            System.out.println(lottoBoxes.get(i));
        }
        return lottoBoxes;
    }

    private static List<List<Integer>> initializeLottoBoxes(int num) {
        List<List<Integer>> lottoBoxes = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            lottoBoxes.add(new ArrayList<>());
        }
        return lottoBoxes;
    }

    private static List<Integer> lottoRandomizer() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    // 5. 당첨 번호 및 보너스 번호 입력 처리
    private static List<Integer> parseLottoNumbers(String line) {
        String[] lottoNumbers = line.split(",");
        validateLottoNumbersLength(lottoNumbers);
        return convertLottoNumbers(lottoNumbers);
    }

    private static void validateLottoNumbersLength(String[] lottoNumbers) {
        if (lottoNumbers.length != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE + "로또 번호는 6개의 숫자로 구성되어야 합니다.");
        }
    }

    private static List<Integer> convertLottoNumbers(String[] lottoNumbers) {
        List<Integer> jackpotNumbers = new ArrayList<>();
        for (String numStr : lottoNumbers) {
            try {
                jackpotNumbers.add(Integer.parseInt(numStr.trim()));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ERROR_MESSAGE + "숫자로 입력해 주세요.");
            }
        }
        return jackpotNumbers;
    }

    


 
}
