package lotto.domain;

public enum LottoInfo {

	MIN_NUMBER(1),
	MAX_NUMBER(45),
	SIZE(6);

	private final int info;

	LottoInfo(int info) {
		this.info = info;
	}

	public int getInfo() {
		return info;
	}
}
