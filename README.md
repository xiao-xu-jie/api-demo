# api-demo

编程题

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

请求格式：

```
{
  "userId": ,			//必填 用户id Long
  "countryCode": "",	//必填 国家编号 
  "province": "",		//必填 省 如：xx省
  "city": "",			//必填 市 如：xx市
  "district": ""		//可选 扩展字段 
}
```



测试样例：

```
请求体：
{
  "userId": 1,
  "countryCode": "CN",
  "province": "广东省",
  "city": "",
  "district": ""
}
响应结果：
{
  "code": 200,
  "message": "用户可用",
  "data": true
}

```



```
请求体：
{
  "userId": 1,			 
  "countryCode": "CN",
  "province": "浙江省",
  "city": "杭州市",
  "district": ""
}
响应结果：
{
  "code": 200,
  "message": "用户可用",
  "data": true
}

```

```
请求体：
{
  "userId": 1,			 
  "countryCode": "CN",
  "province": "浙江省",
  "city": "宁波市",
  "district": ""
}
响应结果：
{
  "code": 200,
  "message": "用户在该区域无法使用",
  "data": false
}

```



