---
title: React+Webpack(一):Webpack基础配置
date: 2018-3-1 20：46
tags: [react,webpack,react-webpack-loader]
---


## Webpack 介绍

*webpack 现代js 的打包器。* 

下面我们用示例介绍webpack怎么打包，并且打包的效果是什么样子的。 


##项目搭建

### 安装Nodejs


官网下载对应操作系统环境版本安装。


### 使用npm 初始化项目

> npm init

会提示命名一些项目基本信息：项目名称，版本号，描述等信息，直接回车确认就行。

这样我们目录下就会生成一个“ package.json ” 项目文件，后面我们项目依赖的包都会在这里面。


### 安装webpack

> npm i webpack

### 安装react

> npm i react


<!--more-->

### 创建目录和文件
1. 在项目根目录，创建build目录
2. 在项目根目录创建client目录
3. 在build目录创建webpack.config.js文件
4. 在client目录创建app.js 和App.js文件

![](https://i.imgur.com/h8HHdkB.png)


####编写配置webpack.config.js
``` bash
//指定绝对路劲
const path = require('path')
/**
 *
 * @type {{entry: {app: *}, output: {filename: string}}}
 */
module.exports = {
    /**
     * 告诉webpack 该文件为程序入口，
     * 然后webpack会去找到app.js 又引用了哪些js ,然后找到所有需要打包的文件
     */
    entry: {
        app: path.join(__dirname,'../client/app.js')
    },
    /**
     * 指定打包到哪个文件
     * [name] entry配置中指定的文件名
     * [hash] 为每次打包生成的一个hash值，如果应用中有一个文件修改，这个hash就会从新生成，从而产生新的文件
     * 否则不打包新的文件。这样有利于浏览器缓存。
     *
     */
    output: {
        filename: "[name].[hash].js",
        path: path.join(__dirname,'../dist'), //打包目录
        publicPath: '/public' //静态资源文件引用时的目录

    }
}

```

#### 编写app.js
``` bash
alert(123)
```


### 编译项目

> npm run build


![](https://i.imgur.com/UDx9ltt.png)
编译后我们看到 多了“dist” 目录，并且生成了 一个 app.3fa5e3dd315365fb6eff.js 文件。文件内容为压缩后的js 内容。该内容是整个应用需要的js都在里面了。