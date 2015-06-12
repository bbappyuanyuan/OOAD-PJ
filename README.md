# Spring3 + Hibernate4 + MySQL integration (annotations)
## Introduction
个人出版物管理系统 individual publications management system

考核目标：
- 如何用面向对象的方法实现灵活的软件系统

交付内容：
- 用例
- UML领域模型
- 可通过自动测试的可运行的代码

注意：
- 不是代码越多越好，不是文档越多越好，不是功能越多越好。
- 不需要实现用户界面，但是需要测试用例完成业务层的测试。

## Use Case 1 - 阅读书籍 Book Reading
1. 选择一本书开始阅读，通知系统这本书处于阅读中。
2. 写读书日志（可能有多篇），并录入系统。
3. 可以从网络或其他杂志收集该书的书评，记录到系统中。
4. 阅读完毕后，系统记录本次阅读完毕。

## Use Case 2 - 借还书籍 Book Borrowing
1. 朋友请求借阅某本书。
2. 用户可以使用系统查阅指定图书的借阅状态。如果可以借阅，则出借该书，系统记录出借信息
3. 朋友归还出借的书
4. 用户通过系统记录归还信息

## Code Description
**ooad.domain** - domain model / data entity

**ooad.repository** - DAO layer

**ooad.service** - service layer

**ooad.test** - JUnit test

## Class
<img src="https://raw.githubusercontent.com/bbappyuanyuan/OOAD-PJ/master/images/class%20diagram.bmp"/>

## Spring3 Configuration
see [applicationContext.xml](https://github.com/bbappyuanyuan/OOAD-PJ/blob/master/src/resources/applicationContext.xml)

## Hibernate4 Configuration
see [entity classes](https://github.com/bbappyuanyuan/OOAD-PJ/tree/master/src/main/java/ooad/domain)
