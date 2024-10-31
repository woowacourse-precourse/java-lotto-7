package lotto.controller;

import lotto.dto.LottoResultDto;
import lotto.service.LottoService;
import lotto.view.InputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;

    public LottoController(LottoService lottoService, InputView inputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
    }

    public void run() {
        LottoResultDto lottoDto = purchaseLotto();
        printPurchaseLottoList(lottoDto);
    }

    private LottoResultDto purchaseLotto() {
        while (true) {
            try {
                int price = inputView.readPrice();
                return lottoService.createLottoList(price);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printPurchaseLottoList(LottoResultDto lottoDto) {
        System.out.println(lottoDto.getPurchaseQuantity() + "개를 구매했습니다.");
        lottoDto.getLottoList().forEach(System.out::println);
    }
}
