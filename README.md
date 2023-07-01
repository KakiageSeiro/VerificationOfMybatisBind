# 動かし方
1. src/main/database/docker-compose.ymlを起動する
1. するとsrc/main/database/script/04_hoge_piyoテーブル作成.sqlが実行されテーブルが作られる(ついでにサンプルデータも)
1. src/test/java/org/example/domain/service/Hogeサービス型Test.javaの各テストを実行する