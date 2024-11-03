package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            int lottoCount = getPurchaseAmount(); // 구매한 로또 수 반환
            List<Lotto> userLottos = printGeneratedLottos(lottoCount); // 생성된 로또 출력 및 반환

            Lotto winningLotto = getWinningNumbers(); // 당첨 번호 입력 및 객체 생성
            final int bonusNumber = getBonusNumber(winningLotto); // 보너스 번호 입력 및 반환

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
        String inputPurchase = Console.readLine();

        // 구입 금액 검증 및 로또 개수 계산
        PurchaseCalculator pCalc = new PurchaseCalculator(inputPurchase);
        int lottoCount = pCalc.calculateLottoCount(); // 로또 개수 반환
        System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        return lottoCount;
    }

    private static List<Lotto> printGeneratedLottos(int lottoCount) {
        List<Lotto> generatedLottos = Lotto.makeLotto(lottoCount); // 로또 생성
        for (Lotto lotto : generatedLottos) {
            System.out.println(lotto.getNumbers()); // 각 로또 번호 출력
        }
        return generatedLottos;
    }

    private static Lotto getWinningNumbers() {
        System.out.println("\n당첨 번호를 입력해 주세요.");
        String inputNumber = Console.readLine(); // 당첨 번호 입력 받기
        List<Integer> numbers = parseInputToList(inputNumber); // 입력값 파싱
        return new Lotto(numbers); // Lotto 객체 생성하여 반환
    }

    private static int getBonusNumber(Lotto winningLotto) {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine(); // 보너스 번호 입력 받기
        int bonus = parseBonusToInt(inputBonusNum); // 입력값 파싱 및 정수 반환

        // 보너스 번호가 범위를 벗어나는지 확인
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 1부터 45 사이의 숫자를 입력하세요.");
        }

        // 당첨 번호와 중복되지 않는지 확인
        if (winningLotto.getNumbers().contains(bonus)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }

        return bonus; // 변환, 검증된 보너스 번호 반환
    }

    private static List<Integer> parseInputToList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim) // 공백 제거
                    .map(Integer::parseInt) // 정수 변환
                    .collect(Collectors.toList()); // 리스트로 반환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }

    private static int parseBonusToInt(String input) {
        try {
            return Integer.parseInt(input.trim()); // 입력값을 정수로 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }
}
