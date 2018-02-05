一：OrmLite
简述: 优点： 1.轻量级；2.使用简单，易上手；3.封装完善；4.文档全面。缺点：1.基于反射，效率较低（本人还没有觉得效率低）；2.缺少中文翻译文档

jar包 地址：http://ormlite.com/releases/

集成方法：把jar包复制到as的libs文件夹下，并且引用jar包即可

用于学习的相关博客：

我的博客
总结：比较好的一个数据库开源框架。不过Git上很久没有更新了，貌似人家好像不在git上做项目维护了，而是在 官网 上做维护更新。

二：LitePal
简述:暂无

git 地址：https://github.com/LitePalFramework/LitePal

集成方法：compile ‘org.litepal.Android:core:1.5.0’

用于学习的相关博客：

我的博客
郭霖的博客
总结：LitePal 框架是郭大神开源的数据库框架，他的博客也比较详细的介绍了其用法。还不错的框架。

三：GreenDao3.2
简述:其优点还包括以下几点:1.存取速度快; 2.支持数据库加密; 3.轻量级; 4.激活实体; 5.支持缓存; 6.代码自动生成

git 地址：https://github.com/greenrobot/greenDAO

集成方法： compile ‘org.greenrobot:greendao:3.2.0’

用于学习的相关博客：

GreenDao3.2.0项目的接入和简单的使用
GreenDao3.2的使用，爱不释手
鸿洋微信推荐 Android实战——GreenDao3.2的使用，爱不释手
关于GreenDao3.2的升级处理一个不错的git地址：GreenDaoUpgradeHelper

总结：效率很高，插入和更新的速度是sqlite的2倍，加载实体的速度是ormlite的4.5倍，目前git上一直在做更新维护，start数量为7000多。

四：Realm

官网地址：：

    https://realm.io/cn/docs/java/latest/#section

简述:
1.易用：Ream 不是在SQLite基础上的ORM，它有自己的数据查询引擎。并且十分容易使用。
2.快速：由于它是完全重新开始开发的数据库实现，所以它比任何的ORM速度都快很多，甚至比SLite速度都要快。
3.跨平台：Realm 支持 iOS & OS X (Objective‑C & Swift) & android。我们可以在这些平台上共享Realm数据库文件，并且上层逻辑可以不用任何改动的情况下实现移植。
4.高级：Ream支持加密，格式化查询，易于移植，支持JSON，流式api，数据变更通知等高级特性
5.可视化:


git 地址：https://github.com/realm/realm-java

官网地址：https://realm.io/docs/java/latest/#getting-started

集成方法：官网中或相关博客中已做详细说明

用于学习的相关博客：

【Android】Realm详解
Realm For Android详细教程
郭霖微信推荐 地址
总结：目前git上一直在做更新维护，start数量也为7000多。数据库Realm，是用来替代sqlite的一种解决方案，它有一套自己的数据库存储引擎，比sqlite更轻量级，拥有更快的速度，并且具有很多现代数据库的特性，比如支持JSON，流式api，数据变更通知，自动数据同步,简单身份验证，访问控制，事件处理，最重要的是跨平台，目前已有Java，Objective C，swift，React-Native，Xamarin这五种实现。和 SQLite 不同，它允许你在持久层直接和数据对象工作。在它之上是一个函数式风格的查询api，众多的努力让它比传统的SQLite 操作更快 。





==========



###GreenDao

    1.轻量级，整个库大小小于 150 k。

    2.
    @Entity 　表明这个实体类会在数据库中生成一个与之相对应的表。
    @Id 　对应数据表中的 Id 字段，有了解数据库的话，是一条数据的唯一标识。
    @Property(nameInDb = “STUDENTNUM”) 　表名这个属性对应数据表中的 STUDENTNUM 字段。
    @Property 　可以自定义字段名，注意外键不能使用该属性
    @NotNull 　该属性值不能为空
    @Transient 　该属性不会被存入数据库中
    @Unique 　表名该属性在数据库中只能有唯一值



    3.

    需要注意的是 offset 是要和 limit 配合使用的。

    list() 所有实体会直接加载到内存中。
    listLazy() 当你需要使用时，才会加载，会自动缓存。使用完必须关闭。
    listLazyUncached() 如你所见，就是不会缓存的意思。使用完必须关闭。
    listIterator() 通过迭代器遍历结果集，不会缓存。使用完必须关闭。
    unique() 返回一个或者零个结果
    uniqueOrThrow() 返回非空的结果，否则抛出异常

