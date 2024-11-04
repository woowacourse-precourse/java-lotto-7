package lotto.view;

import lotto.model.LottoCollection;

public class OutputView {

    public static void outputErrorMessage(Exception e) {
        System.out.println();
        System.out.println(e.getMessage());
        System.out.println();
    }

    public static void outputLottoCollection(LottoCollection lottoCollection) {
        // TODO: message 상수로 빼기
        System.out.println();
        System.out.println(lottoCollection.getLottoCount() + "개를 구매했습니다.");
        System.out.println(lottoCollection.toString());
    }

}
