package lotto.view;

import lotto.dto.LottoResultDto;

public class OutputView {

    public void printPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printErrorMessage(IllegalArgumentException e) {
        System.out.println(e.getMessage());
    }

    public void printPurchaseLottoList(LottoResultDto lottoDto) {
        System.out.println();
        System.out.println(lottoDto.getPurchaseQuantity() + "개를 구매했습니다.");
        lottoDto.getLottoList().forEach(System.out::println);
    }
}
