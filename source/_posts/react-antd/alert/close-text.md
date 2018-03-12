---
order: 5
title: Antd-alert-自定义关闭
date: 2018-3-12 12:50
tags: [react,antd,laert-banner]
---

## zh-CN

可以自定义关闭，自定义的文字会替换原先的关闭 `Icon`。

## en-US

Replace the default icon with customized text.

````jsx
import { Alert } from 'antd';

ReactDOM.render(
  <Alert message="Info Text" type="info" closeText="Close Now" />
, mountNode);
````
