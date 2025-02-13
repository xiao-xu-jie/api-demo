# api-demo
XGRIDS编程题

## 运行环境

- Java: 17+ LTS
- Spring Boot: 3.3.2
- Mysql：8.+

## 运行指令

```
mvn clean package -DskipTests
cd target
java --db.username=root --db.password=123456 -jar api-demo.jar
```

## 测试数据

接口地址：http://127.0.0.1:8899/server/isAvailable

请求方式：Post

```
{
  "userId": 1,			//必填 用户id
  "countryCode": "",	//必填 国家编号
  "province": "",		//必填 省 如：四川省
  "city": "",			//必填 市 如：广安市
  "district": ""		//可选 扩展字段 
}
```

数据库中测试数据：

用户 ID ： 1

可用区域：CN 四川省 成都市

CN 四川省 广安市

