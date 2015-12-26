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
{
    status:状态码,
    userid:用户id,
    username:用户昵称,
    token:用户当前的token
}
```

#### 读者

方法：POST

URI：/api/reader/login

json:
```
{
    login:登录名,
    pass:明文密码
}
```

返回json：
```
{
    status:状态码,
    userid:用户id,
    username:用户昵称,
    token:用户当前的token,
    lendbooks: [
        {
            bookid:借阅图书的id,
            bookname:借阅图书的名
        }, ...
    ],
    debt:该读者延迟罚款
}
```

### 图书类

#### 添加图书

方法：PUT

URI：/api/book/add

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    bookname:图书名称,
    bookauther:图书作者,
    bookpub:图书出版社,
    isbn:ISBN号,
    price:图书价格,
    typeid:图书分类ID,
    canLend:是否馆藏(0非馆藏本,other:馆藏本)
}
```
* 以上成员元素,缺一不可

返回json：
```
{
    status:状态码,
    message:其他信息
}
```
* 其他信息指如果成功返回成功;如果失败,返回失败原因

#### 删除图书

方法：DELETE

URI：/api/book/delete

json:
```
{
    bookid:图书id,
    admin:当前管理员id,
    token:管理员当前token
}
```

返回json：
```
{
    status:状态码,
    message:其他信息
}
```
* 其他信息指如果成功返回成功;如果失败,返回失败原因

#### 更新图书信息

方法：POST

URI：/api/book/update

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    bookname:图书名称,
    bookauther:图书作者,
    bookpub:图书出版社,
    isbn:ISBN号,
    price:图书价格,
    typeid:图书分类ID
}
```
* 以上成员元素,除了admin,token外,其他的只需要写要更新的元素.当然,也可以都写.

返回json：
```
{
    status:状态码,
    message:其他信息
}
```
* 其他信息指如果成功返回成功;如果失败,返回失败原因

#### 获得信息

方法：GET/POST

URI：/api/book/get

json:
```
{
    bookid:图书id,
    bookname:图书名,
    auther:作者,
    bookpub:出版社,
    isbn:ISBN码,
    typeid:类型ID
}
```
* 只需要发送需要查找的信息项,如果有多个,将取交集.

返回json：
```
{
    bookname:图书名称,
    bookauther:图书作者,
    bookpub:图书出版社,
    isbn:ISBN号,
    price:图书价格,
    typeid:图书分类ID,
    canLend:是否馆藏(0非馆藏本,other:馆藏本)
}
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