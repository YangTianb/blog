---
order: 3
title: Antd-alert-含有辅助性文字介绍
date: 2018-3-12 12:50
tags: [react,antd,laert-message]
---

## zh-CN

含有辅助性文字介绍的警告提示。

## en-US

Additional description for alert message.

````jsx
import { Alert } from 'antd';

ReactDOM.render(
  <div>
    <Alert
      message="Success Text"
      description="Success Description Success Description Success Description"
      type="success"
    />
    <Alert
      message="Info Text"
      description="Info Description Info Description Info Description Info Description"
      type="info"
    />
    <Alert
      message="Warning Text"
      description="Warning Description Warning Description Warning Description Warning Description"
      type="warning"
    />
    <Alert
      message="Error Text"
      description="Error Description Error Description Error Description Error Description"
      type="error"
    />
  </div>
, mountNode);
````
