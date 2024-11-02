package lotto;

import camp.nextstep.edu.missionutils.*;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 로또 구입 금액 입력 받기
        System.out.println("구입금액을 입력해 주세요.");
        int inputCash = Integer.parseInt(Console.readLine());
        // 1000 단위, 숫자 여부 검증 필요
        int lottoCount = inputCash / 1000;

        // 로또 생성 과정
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6);))
        }
    }
}
