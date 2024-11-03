## 73b101d - LSBsity, 6분 전
refactor(all): 디렉터리 구조 변경
전체 디렉토리 구조 변경 및 테스트 가독성 향상


## 3ffe4c9 - LSBsity, 9분 전
refactor(LottoConst): 오류 메시지 수정


## f8251e1 - LSBsity, 11분 전
test(LottoTest): 테스트용도 객체 생성 팩토리 추가


## d56698a - LSBsity, 14분 전
feat(UserPurchasedLotto): 유저 로또를 1급 컬렉션으로 변경


## 2c905dd - LSBsity, 30시간 전
refactor(InputView): 함수형 인터페이스 추가
Predicate 상수화로 조건 로직 정의,
공통 예외 처리 메서드 정의


## 98b8645 - LSBsity, 2일 전
refactor(InputView): 메서드 네이밍 변경
자세한 메서드 네이밍으로 변경


## 82ecabb - LSBsity, 2일 전
test(LottoRank): 로또 ENUM 판별 테스트
맞춘 개수와 보너스 일치 여부에 따른 등수 반환 테스트


## 45d9dd0 - LSBsity, 3일 전
test(OutputViewTest): 당첨 로또 출력 테스트
당첨된 로또 정보를 출력하는 테스트


## a00af18 - LSBsity, 3일 전
feat(OutputView): 당첨 로또 출력
당첨된 로또를 등수에 따라 출력, 수익률 출력


## a5463ca - LSBsity, 3일 전
feat(LottoService): 로또 당첨 확인 핵심 로직
로또 당첨을 확인, 수익률 계산 로직 추가


## 31a34b3 - LSBsity, 3일 전
feat(InputViewTest): 보너스 번호 중복 예외 추가
보너스 번호 입력이 기존 당첨 번호와 겹치면 에외 발생


## a38c32b - LSBsity, 3일 전
rafactor(LottoGenerator): 인터페이스 분리
AutoGenerator로 변경 / 인터페이스 분리 작업


## 57128aa - LSBsity, 3일 전
test(LottoService): 로또 당첨 확인 기능 추가
로또 당첨 확인 기능 테스트


## d535452 - LSBsity, 3일 전
feat(LottoService): 로또 당첨 확인 기능 추가
로또 당첨을 확인하고 결과를 반환함


## c2c4347 - LSBsity, 4일 전
fix(LottoGenerator): 정렬 기능 누락 추가
랜덤한 번호를 생성하고 정렬하여 반환하는 기능 추가


## a655698 - LSBsity, 4일 전
fix(LottoGenerator): 정렬 기능 누락 추가
랜덤한 번호를 생성하고 정렬하여 반환하는 기능 추가


## 8a3d08d - LSBsity, 4일 전
test(OutputView): 생성된 로또 출력 기능 테스트
생성된 로또를 형식에 맞도록 사용자에게 출력


## 5ccd3db - LSBsity, 4일 전
test(Lotto): 로또 숫자 변환 기능 테스트
자신의 List<Integer>형태의 로또를 형식에 맞게 Join해서 반환함


## 3fc5cfd - LSBsity, 4일 전
feat(OutputView): 출력 기능 추가
로또를 형식에 맞게 출력함
그에 따른 의존성, 상수 추가


## a45db20 - LSBsity, 4일 전
test(InputView): 보너스 번호 입력 테스트


## 63b4c67 - LSBsity, 4일 전
feat(InputView): 보너스 번호 입력 기능 추가
보너스 번호를 받고 예외 검증


## 9a11666 - LSBsity, 4일 전
test(InputView): 사용자 당첨 번호 입력 기능 테스트
사용자에게 입력을 받은 당첨 번호를 검증함


## 7445ed9 - LSBsity, 4일 전
feat(InputView): 사용자 당첨 번호 입력 기능 추가
사용자에게 당첨 로또 번호를 받고 파싱, 검증


## 74b6807 - LSBsity, 4일 전
feat(User): 사용자 생성
구매 금액, 구입한 로또, 수익률을 흐름에 따라 저장할 User 객체


## a13c79a - LSBsity, 4일 전
feat(LottoController): 컨트롤러 생성
시스템 로직 틀을 담당할 컨트롤러 생성
의존성 주입을 위한 팩토리 생성


## b7b29b7 - LSBsity, 4일 전
test(LottoService): 로또 발행 로직 테스트
LottoService와 그에 관련된 클래스 테스트


## f4df3c1 - LSBsity, 5일 전
feat(LottoGenerate): 로또 발행 구현
주어진 금액을 통해 로또 개수를 계산하고 랜덤한 값을 추출해 로또를 발행함


## 8e398e7 - LSBsity, 5일 전
feat(Exception): 사용자 입력 예외 처리와 메시지
숫자가 아니거나, 로또 한 장당 가격으로 나누어 떨어지지 않을 시  생성되는 예외 클래스와 메시지


## a2e3eb1 - LSBsity, 5일 전
test(InputView): 사용자 입력 테스트
사용자에게 입력이 정상적으로 받아지는지 테스트함


## 757894c - LSBsity, 5일 전
feat(InputView): 사용자 입력 기능 추가
사용자에게 입력을 받고 요구사항에 맞게 검증함


## 9b0b176 - LSBsity, 5일 전
docs(README): 요구사항과 구현할 기능 정리
미션에서 요구한 요구 사항을 정리하고 개발 주의사항, 구현 순서 나열


## 99b1964 - jaeyeonling, 5일 전
feat: setup project

