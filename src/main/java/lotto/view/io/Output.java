package lotto.view.io;

import java.util.List;

public class Output {
    public void lottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public void lottoNumber(List<Integer> lottoNumber) {
        System.out.println(lottoNumber);
    }

    public void winningResult() {
        int ans = 0;
        System.out.println("3개 일치 (5,000원) - " + ans + "개");
        System.out.println("4개 일치 (50,000원) - " + ans + "개");
        System.out.println("5개 일치 (1,500,000원) - " + ans + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + ans + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + ans + "개");
    }
}
