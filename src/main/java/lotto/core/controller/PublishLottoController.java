package lotto.core.controller;

import java.util.List;
import lotto.core.dto.LottoDto;
import lotto.core.dto.LottoPurchaseAmountDto;
import lotto.core.service.PublishLottoService;
import lotto.core.view.View;

public class PublishLottoController implements Controller<LottoPurchaseAmountDto, List<LottoDto>> {

    private PublishLottoService service;

    private View<List<LottoDto>> view;

    public PublishLottoController(PublishLottoService service, View<List<LottoDto>> view) {
        this.service = service;
        this.view = view;
    }

    @Override
    public List<LottoDto> request(LottoPurchaseAmountDto lottoPurchaseAmountDto) {
        List<LottoDto> lottoDtos = service.publish(lottoPurchaseAmountDto);
        view.setContent(lottoDtos);
        view.display();
        return lottoDtos;
    }
}
