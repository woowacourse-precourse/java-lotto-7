package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("구입금액을 입력해 주세요.");
        int amount = Integer.parseInt(Console.readLine());
        LottoGenerator lottoGenerator = new LottoGenerator(amount); //1000단위 입력 확인
        TotalLotto totalLotto = new TotalLotto(lottoGenerator.generateTotalLotto());
        System.out.println(lottoGenerator.lottoCount+"개를 구매했습니다.");
        totalLotto.getLottos().stream()
                .forEach(lotto -> System.out.println(lotto.getNumbers().toString()));
    }
}
