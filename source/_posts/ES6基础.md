---
layout: post
title: "ES6 标准规范-常用基础"
date: 2018-2-26 11:34
comments: true
tags: [ES6,react]
brief： "ES6 标准规范-常用基础"
---

## ES6里都有什么？

1. **块级作用域、字符串、函数**
2. **对象扩展、解构**
3. **类、模块化**

## 块级作用域
### let
let 只对 所在{}中起作用，在let所在{}外部不起作用
如：

> {
>   let name = 'bbb'
> }
> console.log(name);

`这里会报错，是没法取到name的`

### const
表示常量，定义后不允许修改。不能给常量赋值。


## 字符串，模板字符串处理
### 拼接
如：

> let name = 'bayker'
> let course='React开发APP'
> console.log('hello '+name +',course is '+course)
> console.log(`hello ${name},course is ${course}`)

结果是一样的。
### 换行不影响
> console.log(`hello
> 
> 
> world
> 
> `)

## 函数
例子：

> function hello(name){
>   console.log(`hello ${name} ！`);    
> }
> const hello1=(name)=>console.log(`hello ${name} ！`)

> hello('bayker')
> hello1('bayker')

这里结果是一样的。ES6 函数的写法主要是减少了 `function` 和 `{}` 的写法。
例子2：

> setTimeout(() => {
>    console.log('XXX');
> }, 1000);
> const double = x =>x*2
> console.log(double(5))

例子3：默认参数
> const hello =(name='bayker')=>{
>    console.log(`hello ${name} ！`)
> }
> hello()
> hello('lili')

例子4：展开符

> const hello=(name1,name2)=>console.log(name1,name2)
> let arr = ['bayker','lili'];
> hello(...arr)

...将数组对象展开，相当于将[]去掉。

## Object扩展
> const objet = {name:'bayker',course:'react开发app'}
> console.log(Object.keys(objet)) //["name", "course"]
> console.log(Object.values(objet)) //["bayker", "react开发app"]
> console.log(Object.entries(objet))//[Array(2), Array(2)]
## Object扩展属性Key
> const name = 'bayker';
> const obj = {
>    name,
>    [name]:'hello ',
>   hello:function(){
>    },
>    hello1(){
>    }
> }
> obj[name]='hello bayker';
> console.log(obj);
打印出来是：
> Object {name: "bayker", bayker: "hello bayker", hello: function, hello1: function}


##Object扩展 数组合并

> const obj = {name:'bayker',course:'react'}
> const obj2={type:'it',name:'chengdu'}
> console.log({...obj,...obj2,date:'2018'});

打印结果：
> Object {name: "chengdu", course: "react", type: "it", date: "2018"}


## 数组解构
> //批量赋值
> const arr = ['hello','bayker'];
> //从数组里取 第一个，和第二个值
> let [arg1,'|',arg2] = arr;
> console.log(arg1,arg2);

打印结果：
> hello | bayker

## 对象解构
> const obj = {name:'bayker',type:'react'}
> let {name,type}= obj;
> console.log(name,"|",type);

打印结果：
> bayker | react

### 类
> //类
> class MyApp{
>    //构造函数
>    constructor(){
>        this.name='bayker';
>    }
>    //自定义函数
>    sayHello(){
>        console.log(`hello ${this.name} !`);
>    }
> }
> //实例类
> const app = new MyApp();
> app.sayHello();



### 模块化
新建js 模块文件 module1.js
> export const name = 'bayker';
> export function sayHello(){
>     console.log('bayker react !');
> }
> export default function test(){
>     console.log('hello bayker');    
> }

其他文件引用 的几种方式：
> // 只引用 name对象
> import {name} from './module1'
> console.log(name);

> //引用方法
> import {sayHello} from './module1'
> syaHello();

> //全部引用
> import * as mod1 from './module1'
> console.log(mod1);
> mod1.sayHello();

## 数组的常见使用
> //遍历数组
>  [1,2,3].forEach(function(value,index){
>     console.log(value);
> })
> //映射新数组
> const arr = [1,2,3].map(v=>v*2);
> console.log(arr);
> //是否都大于3
> console.log([1,2,3].every(v=>v>3));
> //是否存在大于3
> console.log([1,2,3].some(v=>v>3));
> //获取大于3的
> console.log([1,2,3,4,5].filter(v=>v>3));
> //数组去重
> const arr1 = [1,2,3,4,3,2,1]
> console.log([...new Set(arr1)])

