import React, {Component} from 'react';
import Good from './good';
import '../styles/Goods.css'
class Goods extends React.Component{
    state={
        data:[]
    }

    componentDidMount=()=> {
        URL = "http://localhost:8080/goods"
        fetch(URL,{
            method:"GET"
        }).then(Response=>{
            if(Response.status===200){
                return Response.json();
            }
            else{
                Promise.reject();
            }
        }).then(jsonData=>{
            this.setState({
                data:jsonData
            })
        })
    }

    render(){
        console.log(this.state.data)
        return (<div className='goodsList'>{
            this.state.data.map(good=>(
                <Good key ={good.name}
                      good ={good}/>
            ))
        }

        </div>)
    }
}

export  default Goods;
