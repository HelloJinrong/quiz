import React, { Component } from 'react';
class NoOrder extends Component {
    state = {
        handleFlag: false,
    }

    render() {
        return (
            <div className="orderNotExists">
                <h1>暂无订单，返回商城页面继续购买</h1>
                <Link to='/Goods'>商城首页</Link> <br/>
            </div>
        );
    };
}

export default NoOrder;
