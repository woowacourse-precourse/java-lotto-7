# 🍀java-lotto-precourse


---

### [JunHakLee03](https://github.com/JunHakLee03)의 우테코 7기 프리코스 3주차 <span style="color:gold"> **[ 로또 ]** </span> 입니다.

사용자가 입력한 금액 만큼의 <span style="color:gold"> **로또** </span>를 랜덤 발급해주고 
사용자가 입력한 당첨번호와 비교해 당첨 결과와 수익률을 출력해주는 프로그램입니다.

![java-lotto – Application java  java-lotto main  2024-11-03 14-57-09](https://github.com/user-attachments/assets/fb9f80ab-e9bd-4274-a744-8af3668961ad)

---

# 📜목차

---
<span style="font-size:105%">

- ### [미션 시작하기](#미션-시작하기)
- ### [구현할 기능 목록](#구현할-기능-목록)
    - #### [구매 금액 입력받기](#구매-금액-입력받기)
    - #### [당첨 번호와 보너스 번호 입력 받기](#당첨-번호와-보너스-번호-입력-받기)
    - #### [구매 금액만큼의 로또 발급하기](#구매-금액만큼의-로또-발급하기)
    - #### [수익률 계산하기](#수익률-계산하기)
    - #### [당첨 내역과 수익률 출력하기](#당첨-내역과-수익률-출력하기)

</span>

## 🚩미션 시작하기

---
<span style="font-size:130%">

레포지토리를 Clone 하고 IDE에서 애플리케이션을 실행합니다.  

`git clone -b {브랜치명} --single-branch https://github.com/woowacourse-precourse/java-lotto-7`

</span>

## 🖥️구현할 기능 목록

---
<span style="font-size:110%">

### 구매 금액 입력받기

- 1장에 1000원인 로또의 구입 액수를 입력 받는다
- 구매한 장수를 출력한다
- <span style="color:orange"> [에외처리] </span> 구입 금액이 양의 정수가 아닌 경우
- <span style="color:orange"> [에외처리] </span> 구입 금액이 1000원 단위가 아닌 경우
<span style="font-size:87%; color:gray"> *예외처리 후 해당 단계부터 다시 시행하도록 구현 </span>

### 당첨 번호와 보너스 번호 입력 받기

- 중복이 아닌 1~45의 숫자 5개를 당첨번호로 입력 받는다
- 당첨 번호와 중복되지 않는 보너스 번호 1개를 입력 받는다
- <span style="color:orange"> [에외처리] </span> 숫자가 아닌 값을 입력 받는 경우
- <span style="color:orange"> [에외처리] </span> 숫자 범위가 1~45가 아닌 경우
- <span style="color:orange"> [에외처리] </span> 당첨 번호에 중복이 존재하는 경우
- <span style="color:orange"> [에외처리] </span> 보너스 번호가 당첨 번호와 중복되는 경우
<span style="font-size:87%; color:gray"> *예외처리 후 해당 단계부터 다시 시행하도록 구현 </span>

### 구매 금액만큼의 로또 발급하기

- 1~45의 숫자 중 랜덤으로 6개의 숫자를 생성한다
- 입력 받은 구입 액수의 장수만큼 발급한다
- 발급된 로또 번호를 출력한다

### 당첨 등수 판정하기

- 사용자가 입력한 당첨 번호 리스트와 구입한 번호를 비교한다
- 일치한 갯수와 보너스 번호 일치 여부에 따라 등수를 결정한다

### 수익률 계산하기

- 저장된 등수의 당첨금을 총합하고 입력받았던 구입 액수로 나눠 수익률을 계산한다
- 수익률은 소수점 둘째자리에서 반올림한다

### 당첨 내역과 수익률 출력하기

- 등수별 당첨금과 당첨 횟수를 출력한다
- 수익률을 출력한다

</span>
