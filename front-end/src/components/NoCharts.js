import React, { Component } from 'react';
import {Link} from 'react-router-dom';
class NoOrder extends Component {
    state = {
        handleFlag: false,
    }

    render() {
        return (
            <div className="orderNotExists">
                <h1>暂无货品，返回商城页面继续添加</h1>
                <Link to='/Goods'>商城首页</Link> <br/>
            </div>
        );
    };
}

export default NoOrder;
