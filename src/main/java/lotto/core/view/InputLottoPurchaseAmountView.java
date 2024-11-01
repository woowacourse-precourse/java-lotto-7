package lotto.core.view;

public class InputLottoPurchaseAmountView implements View<String> {

    private String content;

    public InputLottoPurchaseAmountView() {}

    public InputLottoPurchaseAmountView(String content) {
        this.content = content;
    }

    @Override
    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public void display() {
        System.out.println(this.content);
    }

}
