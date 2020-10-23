import React,{Component} from 'react';
import { Button } from 'antd';



class Good extends Component{
    state = {
        handleFlag:false,
    }
    handleClickaddGoodButton = () => {
        this.setState({
            handleFlag: true,
        })
        URL = `http://localhost:8080/goods/${this.props.good.id}`
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
            <div className="good">
                <img className='goodImg' src={this.props.good.imgUrl} alt='商品图片' />
                <div className='info'>
                    <h2>{this.props.good.name}</h2>
                    <p className='unit'>单价：{this.props.good.price}/{this.props.good.unit}</p>
                </div>
                <Button type="dashed" className='addButton'
                        onClick={this.handleClickaddGoodButton}
                        disabled={this.state.handleFlag}>添加购物车</Button>

            </div>
        )
    };


}


export default Good;
