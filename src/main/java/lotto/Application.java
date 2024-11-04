package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    private static final int LOTTO_PRICE = 1000; // 로또 한 장 가격 정의

    public static void main(String[] args) {
        try {
            int amount = inputAmount(); // 구입 금액 입력받기
            List<Lotto> purchasedLottos = purchaseLottos(amount / LOTTO_PRICE); // 구매한 로또 수량만큼 로또 생성
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 발생 시 에러 메시지 출력
        }
    }

    // 구입 금액 입력 및 1000원 단위 검증
    private static int inputAmount() {
        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            try {
                int amount = Integer.parseInt(Console.readLine()); // 구입 금액 입력
                if (amount < LOTTO_PRICE || amount % LOTTO_PRICE != 0) {
                    throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다."); // 구입 금액이 1,000원 단위가 아니면 예외 발생
                }
                return amount; // 유효한 금액일 경우 반환
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage()); // 유효하지 않을 경우 에러 메시지 출력 후 다시 입력
            }
        }
    }

     // 로또 구매 및 로또 번호 생성
    private static List<Lotto> purchaseLottos(int count) {
        System.out.println(count + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(generateLottoNumbers())); // count 수만큼 로또 생성하여 리스트에 추가
        }
        return lottos;
    }

    private static List<Integer> generateLottoNumbers() {
        // 1부터 45 사이의 중복되지 않는 랜덤 숫자 6개를 생성하여 정렬 후 반환
        List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
        Collections.sort(numbers);
        return numbers;
    }

}
