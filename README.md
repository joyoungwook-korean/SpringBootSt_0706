# SpringBootSt_0706
호텔 예약 시스템

HOTEL　予約システムです。

## 紹介
## 소개

호텔 예약 시스템을 이용해서 희망일의 남아있는 룸을 검색해서 예약이 가능한 시스템을 만들었습니다.

ホテル予約システムを利用して希望日の残っているルームを検索して予約ができるようにするシステムでする。

## 機能
## 기능
1. 결제시스템을 구현했습니다. (현재 결제가 가능하고 서버에 저장 되지만 자동으로 취소 됩니다.)

2. 결제 완료시 예약 정보와 예약정보가 담겨있는 QR코드를 생성하여 휴대폰 MMS로 발신하는 서비스를 구현하였습니다. 

3.  AWS를 이용하여 실제로 운영 가능한 EC2 서비스를 만들었습니다.

4. AWS S3 서버를 이용해서, 파일 및 이미지를 실제 서버에서 가져올 수 있습니다.

5. AWS RDS(MariaDB)를 이용해서 DB 서버를 구축했습니다.

6. Spring Security의 OAuth2를 이용해서 소셜 자동로그인 및 회원가입(Kakao, Naver, Google) 및 권한 설정을 하였습니다.

7. Spring JPA를 이용해서 Entity를 생성 및 연관관계를 매핑 하였습니다.

8. 관리자 페이지를 구현해서 유저와의 권한을 설정 하였습니다.

9. 관리자와 문의가능한 mail기능을 구현 했습니다.

10. 관리자의 페이지에서 룸 정보, 예약 시스템, 유저 정보의 CRUD가 가능한 페이지를 구현하였습니다.

11. Google Map API 를 이용해서, 호텔의 위치 정보와 자신의 위치 정보를 찾을 수 있게 구현하였습니다.

12. 일정과 사람의 수를 지정해서, 남아있는 방을 검색하여 예약할 수 있는 로직을 구현하였습니다.

13. AJAX를 이용하여, 비동기 CRUD가 가능하게 만들었습니다.

１．決済システムを具現しました。

２．予約完了した時に予約情報をケータイメールを発信するサービス具現しました。

３．AWSを利用して実在に接続できるようにEC2サーバーを作りました。

４．AWS S3サーバーを利用して、ルームの写真をCRUDするシステムを開発しました。

５．AWS RDS（MariaDB）を利用して、DBを構築しました。

６．Spring SecurityのOAuth2利用してソーシャルログイン機能と権限を設定しました。

７．SpringJPAを利用して、DB連関関係を具現しました。

８．管理者のページを具現して権限を設定しました。

９．管理者とCONTACTできるメール機能を具現しました。

１０．管理者のページでROOM情報と予約情報とユーザー情報のCRUDができます。

１１．GoogleMAPを利用して、hotelの位置情報と自分の位置情報を具現しました。

１２.　日付と人数を指定して、残っている部屋を検索し予約することができます。

１３．AJAXを利用して、非同期CRUDと検索ができます。



### 開発言語
### 개발언어

frontEnd : Thymeleaf, HTML, JavaScript, Jquery, bootstrap, Ajax

DB : AWS RDS( MariaDB )

Backend : Java, Springboot, SpringJPA, Spring Security

その他 : AWS S3, AWS EC2, OAuth2(Social Login)-[Kakao, naver, google], Google Map, Mail(google SMTP), Naver Sens(MMS), QRCOde


[![Hotel Project](http://youtu.be/iDZ5_dUCReo/0.jpg)](https://youtu.be/iDZ5_dUCReo?t=0s) 


