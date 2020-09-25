import React from 'react';
import {BrowserRouter as Router, NavLink, Route,Redirect,Switch} from 'react-router-dom';
import './App.css'
import logo from './logo.svg';
import Goods from "./components/Goods";
import NoMatch from './components/404';
import Orders from "./components/Orders";
import AddGoods from './components/AddGoods';
import NoOrder from './components/NoOrder';
import Footer from './components/Footer';

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>

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
                    <Route exact path='/order' component={Orders} />
                    <Route exact path='/add' component={AddGoods}/>
                    <Route exact path='/noOrder' component={NoOrder}/>
                    <Route component={NoMatch} />

                </Switch>
            </Router>


        </div>
        <footer>
            <Footer/>
        </footer>

    </div>
  );
}

export default App;
