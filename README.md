### AS导入工程慢或者失败等问题
1. build.gradle修改classpath, 指定自己支持打版本号,这里是2.2.2
`classpath 'com.android.tools.build:gradle:2.2.2'`
2. gradle/wrapper/gradle-wrapper.properties修改distributionUrl, 指定自己支持的gradle.zip
`distributionUrl=https\://services.gradle.org/distributions/gradle-2.14.1-all.zip`

### 涉及到的权限
网络请求和IEMI信息的获取,需要添加如下权限,桌面和桌面看看必须都添加

    <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
    <uses-permission android:name="android.permission.READ_PHONE_STATE" />
    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

桌面看看代码必须要添加的, 而一部分代码运行在桌面,所以桌面也需要添加

### 可以直接安装apk
根目录下有编译好的`app-debug.apk`

