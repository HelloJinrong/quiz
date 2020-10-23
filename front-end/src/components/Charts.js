import React, {Component} from 'react';
import {Button} from 'antd';
import Chart from './Chart';
import noCharts from './NoCharts'
import '../styles/Orders.css'


class Charts extends Component {
    state = {
        data: [],
    }

    componentDidMount = () => {
        URL = "http://localhost:8080/chart"
        fetch(URL, {
            method: "GET",
        }).then(Response => {
            if (Response.status === 200) {
                return Response.json();
            } else {
                Promise.reject();
            }
        }).then(jsonData => {
            console.log(jsonData)
            if (jsonData.length === 0) {
                this.props.history.push('/noCharts')
            } else {
                this.setState({
                    data: jsonData,
                })
            }
        })

    }
    handleInfoClick = () => {
        URL = `http://localhost:8080/chart/all`
        fetch(URL, {
            method: "DELETE",
        });
        alert("货品已清空，请刷新页面")
    }

    render() {
        console.log(this.state.data)
        return (
            <div className="orderList">
                <div className='content'>
                    <h2>名字</h2>
                    <h2>数量</h2>
                    <h2>删除</h2>
                    <h2>一键下单</h2>

                </div>
                {
                    this.state.data.map(chart => (
                        <Chart
                            key={chart.name}
                            chart={chart}
                        />
                    ))
                }
                <div className="deleteAll">
                    <Button type="primary" onClick={this.handleInfoClick}>清空购物车</Button>
                </div>
                <br/>
            </div>
        )
    };
}

export default Charts;
