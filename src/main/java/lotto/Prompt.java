package lotto;

enum Prompt {
    PURCHASE("구입 금액을 입력해 주세요.");

    private final String guide;

    Prompt(String guide) {
        this.guide = guide;
    }

    public String getGuide() {
        return guide;
    }
}