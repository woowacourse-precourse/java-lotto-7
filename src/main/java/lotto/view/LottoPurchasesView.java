package lotto.view;

import lotto.dto.LottoPurchasesDto;

public class LottoPurchasesView implements OutputView {

    private static final String LOTTO_PURCHASES_OUTPUT_HEADLINE = "%n%d개를 구매했습니다.";
    private final LottoPurchasesDto lottoPurchasesDto;

    public LottoPurchasesView(LottoPurchasesDto lottoPurchasesDto) {
        this.lottoPurchasesDto = lottoPurchasesDto;
    }

    private void showHeadLine() {
        System.out.printf((LOTTO_PURCHASES_OUTPUT_HEADLINE) + "%n", lottoPurchasesDto.getNumberOfPurchase());
    }

    @Override
    public void display() {
        showHeadLine();
        System.out.printf(lottoPurchasesDto.getPurchasesMessage() + "%n");
    }
}
