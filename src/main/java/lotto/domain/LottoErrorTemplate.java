package lotto.domain;

public enum LottoErrorTemplate {

    NUMBER_OUT_OF_RANGE("보너스 넘버는 %d~%d 사이어야 합니다."),
    INVALID_LOTTO_NUMBER_SIZE("로또 번호는 %d개여야 합니다."),
    DUPLICATE_LOTTO_NUMBER("로또 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER_SIZE("당첨 번호는 %d개여야 합니다."),
    DUPLICATE_WINNING_NUMBER("당첨 번호는 중복될 수 없습니다.");

    private final String template;

    LottoErrorTemplate(String template) {
        this.template = template;
    }

    public String format(Object... args) {
        return String.format(this.template, args);
    }
}
