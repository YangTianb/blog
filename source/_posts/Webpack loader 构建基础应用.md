---
title: Webpack loader 构建基础应用
date: 2018-3-2 14:20
---

## 前文

[http://ikode.site/2018/03/01/react+webpack(%E4%B8%80)%EF%BC%9AWebpack%E5%9F%BA%E7%A1%80%E9%85%8D%E7%BD%AE/](http://ikode.site/2018/03/01/react+webpack(%E4%B8%80)%EF%BC%9AWebpack%E5%9F%BA%E7%A1%80%E9%85%8D%E7%BD%AE/ "react+webpack(一)：Webpack基础配置")

## 安装配置 babel-loader

因为我们的react 语法是jsx 非原生js 语法，浏览器是不能识别解析的。 要让jsx 转为js需要安装babel。


> npm i babel-core -D
> npm i bable-loader -D


并配置 “webpack-config.js”

``` bash

//指定绝对路劲
const path = require('path')

/**
 *
 * @type {{entry: {app: *}, output: {filename: string}}}
 */
module.exports = {
     
    module: {
        rules: [{
            test: /.jsx$/,
            loader: 'babel-loader' //babel-loader 是一个插件，需安装 babel-core 和bable-loader 使用npm i babel-core -D,npm i bable-loader
                                // ，指定用babel去编译，babel能识别各种js语法.
            },
            {
                test:/.js$/,
                loader: "babel-loader",
                //排除node_modules目录下的js 不使用babel编译
                exclude:[
                    path.join(__dirname,'../node_modules')
                ]
            }
        ]
    } 
}

```

安装 babelrc 要使用的插件

> npm i bable-preset-es2015 bable-preset-es2015-loose bable-preset-react -D

在项目根目录创建文件 ".babelrc",配置如下：

```
{
    //指定bable解析哪些语法,loose表示松散的态度的解析。需安装指定的包：
    // npm i bable-preset-es2015 bable-preset-es2015-loose bable-preset-react -D
    "presets":[
            ["es2015",{"loose":true}],
            "react"
    ]
}

```


## 添加HTMLPuglin

HTMLPuglin 用于 自动生成html，并引用webpack配置的entry。

安装插件：

> npm i html-webpack-plugin

并配置"webpack.config.js"

``` bash
//生成HTML，html的名字根据exports 配置生成，需要安装插件npm i html-webpack-plugin
const HTMLPlugin = require('html-webpack-plugin')

//指定绝对路劲
const path = require('path')

/**
 *
 * @type {{entry: {app: *}, output: {filename: string}}}
 */
module.exports = {     
    module: {
	plugins: [
            new HTMLPlugin()
    	]
	}
}

```


## 编写APP文件

编写app.js文件：

``` bash

/**
 * 应用入口
 * */
import  React from  'react'
import  ReactDOM from  'react-dom'
import  App from  './App.jsx'

/**
 * 挂载reactjsx到 dom节点
 */
ReactDOM.render(<App />,document.body)

```

编写App.js 文件

``` bash

import  React from  'react'
export  default  class  App extends  React.Component{
    render(){
        return (
            <h1>This is ReactApp </h1>
        )
    }
}


```

## 重新编译项目

> npm run build

会在dist 目录下生成编译后的文件 "index.html" 和 app.xxx.js文件：

如图：
![](https://i.imgur.com/1T044hN.png)



## 例子代码：

> https://github.com/YangTianb/ynode