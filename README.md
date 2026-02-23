📦注文サービス – マイクロサービス (Spring Boot + Docker + PostgreSQL)
🚀プロジェクト概要
Order Serviceは、JavaとSpring Bootを使用して構築された、本番環境対応のRESTfulマイクロサービスです。
マイクロサービスアーキテクチャの原則、コンテナ化、データベース統合を実証します。
このサービスは顧客の注文を管理し、Docker および Kubernetes 環境での展開用に設計されています。
________________________________________
🛠技術スタック
•	Java 17
•	スプリングブート3
•	Spring Data JPA (Hibernate)
•	PostgreSQL
•	メイヴン
•	ドッカー
•	Dockerコンポーズ
•	REST API
•	スプリングブートアクチュエータ
________________________________________
🏗建築
このプロジェクトは階層化アーキテクチャに従います。
コントローラー → サービス → リポジトリ → データベース
クライアント
↓REST コントローラー ↓サービス層（ビジネスロジック） ↓JPA リポジトリ ↓PostgreSQL
アプリケーションは Docker を使用してコンテナ化され、Docker Compose を使用して PostgreSQL と一緒に実行されます。
________________________________________
📂プロジェクト構造
order-service/ 
├── src/main/java/com/beniguha/orderservice │ ├── コントローラー │ ├── サービス │ ├──
リポジトリ │ ├── エンティティ
│ └── OrderServiceApplication.java ├── src/main/resources │ └── application.yml ├── Dockerfile ├── docker-compose.yml ├── pom.xml └── README.md
________________________________________
🗄データベース構成
サービスは PostgreSQL コンテナに接続します。
アプリケーション.yml:
spring:
データソース: url: jdbc:postgresql://postgres:5432/orderdb ユーザー名: postgres パスワード: postgres jpa: hibernate: ddl-auto: update show-sql: true
________________________________________
▶️ アプリケーションの実行方法
1️⃣ プロジェクトをビルドする
プロジェクトルートから:
mvn クリーンパッケージ
________________________________________
2️⃣ Docker Compose を使用して実行
docker compose up --build
これは次のように開始されます:
•	注文サービス
•	PostgreSQLデータベース
________________________________________
3️⃣ アプリケーションにアクセスする
アプリケーションは以下で実行されます:
http://localhost:8081
健康チェック:
http://localhost:8081/actuator/health
________________________________________
📡 APIエンドポイント
注文を作成
POST /注文
{ 
"productName": "ラップトップ", "quantity": 2, "price": 1200}
________________________________________
すべての注文を取得
GET /orders
________________________________________
IDで注文を取得
/orders/{id} を取得する
________________________________________
注文を削除
/orders/{id} を削除
________________________________________
🐳 Docker の設定
Dockerファイル
•	eclipse-temurin JDK 17 ベースイメージを使用します
•	コンテナ内でSpring Boot JARを実行する
•	ポート8081を公開する
ビルドイメージ:
docker build -t order-service:1.0 。
________________________________________
☸ Kubernetes 対応
このアプリケーションは Kubernetes にデプロイする準備ができています。
展開例:
apiVersion: apps/v1 
kind: Deploymentmetadata: name: order-servicespec: replicas: 2 selector: 
matchLabels: 
app: order-service template: metadata: labels: app: order-service spec: containers: - name: order-service image: your-dockerhub/order-service:1.0 ports: - containerPort: 8081
________________________________________
☁ クラウド導入準備完了
このマイクロサービスは以下にデプロイできます。
•	Amazon Elastic Kubernetes サービス
•	Amazon エラスティックコンテナサービス
•	アマゾンEC2
________________________________________
🔍生産機能
•	HikariCP 接続プール
•	Spring Bootアクチュエータ監視
•	コンテナ化されたアーキテクチャ
•	環境ベースの構成
•	スケーラブルな設計（Kubernetes対応）
________________________________________
📈今後の改善
•	APIゲートウェイを追加する
•	サービスディスカバリの追加（Eureka）
•	集中構成の追加
•	JWT認証を追加する
•	CI/CD パイプラインを追加する (GitHub Actions)
•	AWS無料利用枠にデプロイする

