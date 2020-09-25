import React,{Component} from 'react';


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
    }
    render() {
        return (
            <div className="good">
                <img className='goodImg' src={this.props.good.imgUrl} alt='商品图片' />
                <div className='info'>
                    <h2>{this.props.good.name}</h2>
                    <p className='unit'>单价：{this.props.good.price}/{this.props.good.unit}</p>
                </div>
                <button className='addButton'
                        onClick={this.handleClickaddGoodButton}
                        disabled={this.state.handleFlag}
                >
                    +
                </button>


            </div>
        )
    };


}


export default Good;
