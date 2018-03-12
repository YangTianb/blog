---
order: 1
title: Antd-alert-四种样式
date: 2018-3-12 12:50
tags: [react,antd,laert-type]
---

## zh-CN

共有四种样式 `success`、`info`、`warning`、`error`。

## en-US

There are 4 types of Alert: `success`, `info`, `warning`, `error`.

````jsx
import { Alert } from 'antd';

ReactDOM.render(
  <div>
    <Alert message="Success Text" type="success" />
    <Alert message="Info Text" type="info" />
    <Alert message="Warning Text" type="warning" />
    <Alert message="Error Text" type="error" />
  </div>
, mountNode);
````
