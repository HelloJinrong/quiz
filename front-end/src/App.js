import React from 'react';
import {BrowserRouter as Router, NavLink, Route,Redirect,Switch} from 'react-router-dom';
import './App.css'
import 'antd/dist/antd.css';
import Goods from "./components/Goods";
import NoMatch from './components/404';
import Orders from "./components/Orders";
import AddGoods from './components/AddGoods';
import NoOrder from './components/NoOrder';
import NoCharts from './components/NoCharts';
import Footer from './components/Footer';
import Charts from "./components/Charts"

function App() {
  return (
    <div className="App">

        <div className="body">
            <Router>
                <div className='list'>
                    <ul>
                        <li>
                            <NavLink exact to='/'
                                     className='link' activeStyle={{
                                fontWeight:"bold",
                                color:"white"
                            }
                            }
                                     style={{color:'black'}}>商城</NavLink>
                        </li>
                        <li>
                            <NavLink  to='/chart' className='link'   activeStyle={{
                                fontWeight:"bold",
                                color:"white"
                            }
                            }  style={{color:'black'}}>购物车</NavLink>
                        </li>
                        <li>
                            <NavLink to='/order' className='link' activeStyle={{
                                fontWeight:"bold",
                                color:"white"
                            }
                            } style={{color:'black'}}>订单</NavLink>
                        </li>

                        <li>
                            <NavLink  to='/add' className='link'   activeStyle={{
                                fontWeight:"bold",
                                color:"white"
                            }
                            }  style={{color:'black'}}>添加商品</NavLink>
                        </li>
                    </ul>
                </div>
                <Switch>
                    <Route exact path='/' component={Goods}/>
                    <Route exact path='/chart' component={Charts}/>
                    <Route exact path='/goods' component={Goods}/>
                    <Route exact path='/order' component={Orders} />
                    <Route exact path='/add' component={AddGoods}/>
                    <Route exact path='/noOrder' component={NoOrder}/>
                    <Route exact path='/noCharts' component={NoCharts}/>

                    <Route component={NoMatch} />

                </Switch>
            </Router>


        </div>
        <div className="footer">
            <Footer/>
        </div>

    </div>
  );
}

export default App;
