package lotto.view;

import lotto.dto.LottoResultDto;
import lotto.model.Lotto;
import lotto.model.UserLottos;

public class OutputView {
    static final String ERROR_PREFIX = "[ERROR]";
    public static void printError(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printLottos(UserLottos userLottos) {
        System.out.println();
        System.out.println(userLottos.getLottoCount() + "개를 구매했습니다.");
        for (int i = 0; i < userLottos.getLottoCount(); i++) {
            Lotto lotto = userLottos.getLottos().get(i);
            System.out.println(lotto);
        }
    }

    public static void printResult(LottoResultDto resultDto) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - "+resultDto.getThreeMatchCount()+"개");
        System.out.println("4개 일치 (50,000원) - "+resultDto.getFourMatchCount()+"개");
        System.out.println("5개 일치 (1,500,000원) - "+resultDto.getFiveMatchCount()+"개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - "+resultDto.getFiveAndBonusMatchCount()+"개");
        System.out.println("6개 일치 (2,000,000,000원) - "+resultDto.getSixMatchCount()+"개");
        System.out.println("총 수익률은 " + String.format("%.1f", resultDto.getProfitRate()) + "%입니다.");
    }
}
