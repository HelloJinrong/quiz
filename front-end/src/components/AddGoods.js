import React, { Component } from 'react';

class AddGoods extends Component {
    constructor(props) {
        super(props);
        this.state = {
            name: null,
            price: null,
            unit: null,
            imgUrl: null
        }
    }

    handleClickaddProductButton = (event) => {
        console.log(this.state)
        event.preventDefault();
        let item = {
            name: this.state.name,
            price: this.state.price,
            unit: this.state.unit,
            imgUrl: this.state.imgUrl
        }
        let header = {method: "POST",
            body: JSON.stringify(item),
            headers: {
                'content-type': 'application/json'
            }}
        fetch("http://localhost:8080/goods", header);
    }


    render() {
        return (
            <div className="product">
                <form>
                    <h2>添加商品</h2>

                    <label htmlFor='name'>名称</label>
                    <input name='name'
                           placeholder='名称'
                           onChange={(event)=>this.setState({name: event.target.value})}
                    />

                    <label htmlFor='name'>价格</label>
                    <input name='price'

                           placeholder='价格'
                           onChange={(event)=>this.setState({price: event.target.value})}
                    />

                    <label htmlFor='name'>单位</label>
                    <input name='unit'
                           placeholder='单位'
                           onChange={(event)=>this.setState({unit: event.target.value})}
                    />

                    <label htmlFor='name'>图片</label>
                    <input  name='url'
                            placeholder='URL'
                            onChange={(event)=>this.setState({imgUrl: event.target.value})}
                    />


                    <input className='submitButton' type='submit' name='Submit'
                           disabled={!this.state.name ||
                           !this.state.price ||
                           !this.state.unit ||
                           !this.state.imgUrl}
                           onClick={this.handleClickaddProductButton}
                    />
                </form>
            </div>
        )
    };
}

export default AddGoods;
