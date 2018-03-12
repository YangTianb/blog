---
order: 7
title: Antd-alert-平滑地卸载
date: 2018-3-12 12:50
tags: [react,antd,laert-banner]
---

## zh-CN

平滑、自然的卸载提示

## en-US

Smoothly and unaffectedly unmount Alert.

````jsx
import { Alert } from 'antd';

class App extends React.Component {
  state = {
    visiable: true,
  }
  handleClose = () => {
    this.setState({ visiable: false });
  }
  render() {
    return (
      <div>
        {
          this.state.visiable ? (
            <Alert
              message="Alert Message Text"
              type="success"
              closable
              afterClose={this.handleClose}
            />
          ) : null
        }
        <p>placeholder text here</p>
      </div>
    );
  }
}

ReactDOM.render(
  <App />
, mountNode);
````
