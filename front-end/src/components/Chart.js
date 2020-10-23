import React, { Component } from 'react';
import { Button } from 'antd';

class Chart extends Component {
    state = {
        handleFlag: false,
    }

    handleInfoClick = () => {
        URL = `http://localhost:8080/chart/${this.props.chart.id}`
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
        alert("货品已删除，请刷新页面")
    }
    addOrders = () =>{
        this.setState({
            handleFlag: true,
        })
        URL = `http://localhost:8080/chart/${this.props.chart.id}`
        fetch(URL, {
            method:"POST",
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
        alert("添加成功！")
    }

    render() {
        return (
            <div className="orderList">
                <div className='content'>
                    <h2>{this.props.chart.name}</h2>
                    <h2>{this.props.chart.number}</h2>
                    <Button type="link" danger onClick = {this.handleInfoClick}>
                        删除货品
                    </Button>
                    <Button type="primary" onClick={this.addOrders}>一键下单</Button>
                </div>
            </div>
        );
    };
}

export default Chart;
