---
order: 2
title: Antd-alert 可关闭的警告提示
date: 2018-3-12 12:50
tags: [react,antd,laert-Closable]
---

## zh-CN

显示关闭按钮，点击可关闭警告提示。

## en-US

To show close button.

````jsx
import { Alert } from 'antd';

const onClose = function (e) {
  console.log(e, 'I was closed.');
};

ReactDOM.render(
  <div>
    <Alert
      message="Warning Text Warning Text Warning TextW arning Text Warning Text Warning TextWarning Text"
      type="warning"
      closable
      onClose={onClose}
    />
    <Alert
      message="Error Text"
      description="Error Description Error Description Error Description Error Description Error Description Error Description"
      type="error"
      closable
      onClose={onClose}
    />
  </div>
, mountNode);
````
