import React, { Component } from 'react';
import { Button } from 'antd';

class Order extends Component {
    state = {
        handleFlag: false,
    }

    handleInfoClick = () => {
        URL = `http://localhost:8080/order/${this.props.order.id}`
        fetch(URL, {
            method:"DELETE",
        }).then(Response => {
            if (Response.status === 200) {
                this.setState({
                    handleFlag: false,
                })
            }
            else {
                this.setState({
                    handleFlag: false,
                })
                Promise.reject();
            }
        });
        alert("订单已删除，请刷新页面")
    }
    render() {
        return (
            <div className="orderList">
                <div className='content'>
                    <h2>{this.props.order.name}</h2>
                    <h2>{this.props.order.price}</h2>
                    <h2>{this.props.order.number}</h2>
                    <h2>{this.props.order.unit}</h2>
                    <Button type="link" danger onClick = {this.handleInfoClick}>
                        删除订单
                    </Button>
                </div>
            </div>
        );
    };
}

export default Order;
