package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {

        final int lottoCount; // 구매한 로또 수

        System.out.println("구입금액을 입력해주세요.");
        String inputPurchase = Console.readLine();

        // 구입금액 입력에 대한 예외 처리, 구매 갯수 출력
        try {
            PurchaseCalculator pCalc = new PurchaseCalculator(inputPurchase);
            lottoCount = pCalc.calculateLottoCount();
            System.out.println("\n" + lottoCount + "개를 구매했습니다.");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // 로또를 생성하는 함수 호출, 출력
        List<Lotto> generatedLottos = Lotto.makeLotto(lottoCount);
        for (Lotto lotto : generatedLottos) {
            System.out.println(lotto.getNumbers());
        }

        System.out.println("\n" + "당첨 번호를 입력해 주세요.");
        String inputNumber = Console.readLine();

        // 사용자가 입력한 번호, 보너스번호가 입력된 lotto 객체
        Lotto inputLottoNum;

        // 당첨번호 입력에 대한 예외 처리 후 List에 저장
        try {
            List<Integer> numbers = parseInputToList(inputNumber);
            inputLottoNum = new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        System.out.println("\n" + "보너스 번호를 입력해 주세요.");
        String inputBonusNum = Console.readLine();

        // 보너스 번호 입력 정수 변환 후 예외 처리
        try {
            int bonus = parseBonusToInt(inputBonusNum);
            inputLottoNum.setBonusNum(bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }

    // 당첨 번호 문자열->정수 변환
    private static List<Integer> parseInputToList(String input) {
        try {
            return Arrays.stream(input.split(","))
                    .map(String::trim) // 공백 제거
                    .map(Integer::parseInt) // 문자열->Integer 변환
                    .collect(Collectors.toList()); // 리스트로 변환
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }

    // 보너스 번호 문자열->숫자 변환
    private static int parseBonusToInt(String input) {
        try {
            return Integer.parseInt(input.trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 숫자를 입력하세요.");
        }
    }
}
