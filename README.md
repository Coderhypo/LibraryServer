# LibraryServer

开发实践课作业：团书馆管理系统Server端。

## 需求

基础的图书馆管理系统,包括对图书的增删改查；用户的增删改查；图书的借阅、归还。

## 技术栈

 - Struts2
 - Hibernate
 - Mysql

## API

部分API需要验证管理员的token，而token的是在管理员登录的时候获取，并且管理员每次登录token将会随机刷新

### 登录

#### 管理员

方法：POST
URI：/api/admin/login
json:
```
{
    login:登录名,
    pass:明文密码
}
```

返回json：
```
```

#### 读者

方法：POST
URI：/api/reader/login
json:
```
{
    login:登录名,
    pass:管理员明文密码
}
```

返回json：
```
```

### 图书类

#### 添加图书

方法：PUT
URI：/api/book/add
json:
```
```

返回json：
```
```

#### 删除图书

方法：DELETE
URI：/api/book/delete
json:
```
```

返回json：
```
```

#### 更新图书信息

方法：POST
URI：/api/book/update
json:
```
```

返回json：
```
```

#### 获得信息

方法：GET/POST
URI：/api/book/get
json:
```
```

返回json：
```
```


### 用户类

#### 管理员

##### 添加管理员

方法：PUT
URI：/api/admin/add
json:
```
```

返回json：
```
```

##### 删除管理员

方法：DELETE
URI：/api/admin/delete
json:
```
```

返回json：
```
```

##### 更新管理员信息

方法：POST
URI：/api/admin/update
json:
```
```

返回json：
```
```

##### 获得管理员信息

方法：GET/POST
URI：/api/admin/get
json:
```
```

返回json：
```
```

#### 读者

##### 添加读者

方法：PUT
URI：/api/reader/add
json:
```
```

返回json：
```
```

##### 删除读者

方法：DELETE
URI：/api/reader/delete
json:
```
```

返回json：
```
```

##### 更新读者信息

方法：POST
URI：/api/reader/update
json:
```
```

返回json：
```
```

##### 获得读者信息

方法：GET/POST
URI：/api/reader/get
json:
```
```

返回json：
```
```


### 操作类

#### 借阅图书

方法：POST
URI：/api/lend
json:
```
```

返回json：
```
```

#### 归还图书

方法：POST
URI：/api/return
json:
```
```

返回json：
```
```