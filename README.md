# Spring Api 【Clean Architecture】 and OpenApi (Swagger) sample project

## Overview
クリーンアーキテクチャ的設計を意識したSpring APIのサンプルプロジェクト。また、APIドキュメントをOpenApi(Swagger)を利用して作成する。なお、docker-composeを用いてSwaggerを利用する。<br>
今後適宜修正予定。

- springApi <br>
Spring API サンプルプロジェクト
- swagger <br>
Swagger Editor, Swagger UI, Swagger API(Mock)を利用するためのパッケージ
    - docker-compose.yml <br>
        docker-compose設定ファイル。
    - api/openapi.yaml
        springApiプロジェクトのインターフェイス仕様書的位置付けとする。Swagger UIで参照し、Swagger Editorで編集を行う。

## How to use Swagger
1. `./java_api/api/`配下で下記コマンドを実行
    ```
    docker-compose up -d 
    ```
1. Swagger Editor にアクセス
    ```
    open http://localhost:8001
1. Swagger UI にアクセス
    ```
    open http://localhost:8002
    ```