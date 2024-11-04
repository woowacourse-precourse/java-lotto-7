package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
//    private static int PURCHASE_AMOUNT;
    private static List<Integer> LOTTO_NUMBER;
    private static int BONUS_NUMBER;
    private static Purchase purchase;
    private static Lotto lotto;
    private static BonusNumber bonusNumber;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // BonusNumber, Lotto 그리고 구입한 번호를 변수로 놓고
        // 각각의 변수와 get함수로 통계구하는 클래스에서 통계 구하기
        savePurchaseAmount();
        printPurchaseLottoNumbers();
        saveLottoNumbers();
        saveBonusNumber();
    }

    private static void savePurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        while(true) {
            try {
                purchase = new Purchase(Console.readLine());
                return;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void printPurchaseLottoNumbers() {
        System.out.println();
        List<Lotto> LottoNumbers = purchase.getLottoNumbers();
        System.out.println(LottoNumbers.size() + "개를 구매했습니다.");
        for(Lotto lotto : LottoNumbers) {
            System.out.println(lotto.getLottoNumber());
        }
    }

    private static String getLottoNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        LottoNumberValidator lottoNumberValidator = new LottoNumberValidator(input);
        // 입력된 문자열을 정수 리스트로 변환
        LOTTO_NUMBER = Arrays.stream(input.split(","))
//                .map(String::trim) // 공백 제거
                .map(Integer::parseInt) // String을 Integer로 변환
                .collect(Collectors.toList());
        return input;
    }

    private static void saveLottoNumbers() {
        while(true){
            try {
                String input = getLottoNumbers();
                lotto = new Lotto(LOTTO_NUMBER);
                return;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static void saveBonusNumber() {
        while(true) {
            System.out.println();
            System.out.println("보너스 번호를 입력해 주세요.");
            try {
                bonusNumber = new BonusNumber(Console.readLine(), LOTTO_NUMBER);
                return;
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
