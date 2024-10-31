package lotto.entity;

import java.util.Scanner;

public class Consumer { // 로또 구매자
    private int lottoCount; // 구매할 로또 수량
    private int totalLottoCost; // 총 로또 구매 금액

    private static final int LOTTO_PRICE = 1000; // 로또 한 장 가격

    public Consumer() {
        Scanner sc = new Scanner(System.in);

        System.out.println("로또 구매할 수량을 입력해 주세요.");
        lottoCount = sc.nextInt(); // 구매할 로또 수량 입력 받기

        // 총 로또 구매 금액 계산
        totalLottoCost = lottoCount * LOTTO_PRICE;

        validateTotalLottoCost(totalLottoCost); // 구매 금액 유효성 검사
    }

    private void validateTotalLottoCost(int totalLottoCost) {
        // 총 로또 구매 금액이 1000원 단위인지 검사
        if (totalLottoCost % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매 금액은 1,000원 단위여야 합니다.");
        }
    }

    // Getter methods (optional)
    public int getLottoCount() {
        return lottoCount; // 구매할 로또 수량 반환
    }

    public int getTotalLottoCost() {
        return totalLottoCost; // 총 로또 구매 금액 반환
    }
}
