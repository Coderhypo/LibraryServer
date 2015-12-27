# LibraryServer

开发实践课作业：图书馆管理系统Server端。(2015-12)

## 需求

基础的图书馆管理系统,包括对图书的增删改查；用户的增删改查；图书的借阅、归还。

## 技术栈

Server端用到的技术栈：

 - Struts2
 - Hibernate
 - MySQL

## API

部分API需要验证管理员的token，而token的是在管理员登录的时候获取，并且管理员每次登录token将会随机刷新（并未将token放在首部）。

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
            bookname:借阅图书的名称
        }, ...
    ],
    debt:该读者延迟罚款
}
```

### 图书类

#### 添加图书

方法：POST

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
    canlend:是否馆藏(0：非馆藏本,other：馆藏本)
}
```
* 以上成员元素,缺一不可

返回json：
```
{
    status:状态码,
    message:信息
}
```
* 信息指如果成功则返回成功的消息;如果失败,返回失败原因（以下相同，不再重复解释）

#### 删除图书

方法：DELETE

URI：/api/book/delete

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    bookid:删除图书id
}
```

返回json：
```
{
    status:状态码,
    message:信息
}
```

#### 更新图书信息

方法：PUT

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
    message:信息
}
```

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
    canLend:是否馆藏(0：非馆藏本,other：馆藏本)
}
```


### 图书类别类

#### 添加图书类别

方法：POST

URI：/api/book/type/add

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    typecode:图书类别代码,
    typename:图书类别名称
}
```

返回json：
```
{
    status:状态码,
    message:消息,
    typeid:如果成功返回新增类型id
}
```

#### 删除图书类别

方法：DELETE

URI：/api/book/type/delete

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    typeid:图书类别id
}
```

返回json：
```
{
    status:状态码,
    message:消息
}
```

#### 修改图书类别信息

方法：PUT

URI：/api/book/type/update

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    typeid:图书分类ID,
    typecode:图书类别代码,
    typename:图书类别名称
}
```

返回json：
```
{
    status:状态码,
    message:消息
}
```

#### 查询所有图书类别

方法：GET

URI：/api/book/type/get

返回json：
```
{
    status:状态码,
    typelist:[
        {
            typeid:图书分类id,
            typecode:图书分类代码,
            typename:图书分类名称
        },...
    ]
}
```


### 用户类

#### 管理员

##### 添加管理员

方法：POST

URI：/api/admin/add

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    login:新增用户登录名,
    name:新增用户昵称,
    pass:用户登录密码
}
```

返回json：
```
{
    status:状态码,
    message:消息,
    userid:如果新增成功，返回新增用户id
}
```

##### 删除管理员

方法：DELETE

URI：/api/admin/delete

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    userid:被删除用户id
}
```

返回json：
```
{
    status:状态码,
    message:消息
}
```

##### 更新管理员信息

方法：PUT

URI：/api/admin/update

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    userid:被修改用户id,
    name:新用户名称,
    pass:新用户登录密码
}
```

返回json：
```
{
    status:状态码,
    message:消息
}
```

##### 获得管理员信息

方法：GET/POST

URI：/api/admin/get

json:
```
{
    userid:用户id,
    login:用户登录名
}
```
* 两个参数至少有一个，也可以全部包含

返回json：
```
{
    userid:用户id,
    login:用户登录名,
    name:用户昵称
}
```

#### 读者

##### 添加读者

方法：POST

URI：/api/reader/add

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    login:新增用户登录名,
    name:新增用户昵称,
    pass:用户登录密码
}
```

返回json：
```
{
    status:状态码,
    message:消息,
    userid:如果新增成功，返回新增用户id
}
```

##### 删除读者

方法：DELETE

URI：/api/reader/delete

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    userid:被删除用户id
}
```

返回json：
```
{
    status:状态码,
    message:消息
}
```

##### 更新读者信息

方法：PUT

URI：/api/reader/update

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    userid:被修改用户id,
    name:新用户名称,
    pass:新用户登录密码
}
```

返回json：
```
{
    status:状态码,
    message:消息
}
```

##### 获得读者信息

方法：GET/POST

URI：/api/reader/get

json:
```
{
    userid:用户id,
    login:用户登录名
}
```
* 两个参数至少有一个，也可以全部包含


返回json：
```
{
    userid:用户id,
    login:用户登录名,
    name:用户昵称
}
```


### 操作类

#### 借阅图书

方法：POST

URI：/api/lend

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    userid:读者用户id,
    bookid:被借阅图书id
}
```

返回json：
```
{
    status:状态码,
    message:消息
}
```

#### 归还图书

方法：POST

URI：/api/return

json:
```
{
    admin:当前管理员id,
    token:管理员当前token,
    bookid:被借阅图书id
}
```

返回json：
```
{
    status:状态码,
    message:消息
}
```


### 查询类

#### 查询图书

方法：GET/POST

URI：/api/search/book

json:
```
{
    bookid:图书ID,
    bookname:图书名称,
    bookauther:图书作者,
    bookpub:图书出版社,
    isbn:ISBN号,
    typeid:图书分类ID,
    booknum:返回图书列表的长度（默认10）
}
```
* 以上参数，除了booknum，至少包含一个（作为查询依据）

返回json：
```
{
    status:状态码,
    booklist:[
            {
                bookid:图书ID,
                bookname:图书名称,
                bookauther:图书作者,
                bookpub:图书出版社,
                isbn:ISBN号,
                typeid:图书分类ID,
                lendtime:借出时间,
                deadline:应归还时间,
                status:目前状态
            },...
        ]
}
```

#### 查询记录

##### 按照用户

方法：GET/POST

URI：/api/search/log

json:
```
{
    userid:被查询用户id,
    userlogin:被查询用户登录名,
    status:要查询的记录状态(0：未归还，1：已归还 | 默认查询全部状态),
    lognum:返回记录最大条数
}
```
* userid，userlogin两个参数至少有一个，lognum默认为10

返回json：
```
{
    status:状态码,
    loglist:[
        {
            bookid:被借图书id,
            bookname:被借图书名称,
            lendtime:借出时间,
            deadline:应归还时间,
            status:目前状态
        },...
    ]
}
```

##### 按照图书

方法：GET/POST

URI：/api/search/log

json:
```
{
    bookid:被查询图书id,
    lognum:返回记录最大条数
}
```

返回json：
```
{
    status:状态码,
    loglist:[
        {
            userid:借阅用户id,
            username:借阅用户昵称,
            lendtime:借阅时间,
            deadline:应还时间,
            status:目前状态
        },...
    ]
}
```
