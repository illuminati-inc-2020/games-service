import React, { Component } from 'react';
import './App.css';
import Home from './Home';
import TicTacToe from './TicTacToe';
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

class App extends Component {
  render() {
    return (
      <Router>
        <Switch>
          <Route path='/' exact={true} component={Home}/>
          <Route path='/tic-tac-toe' exact={true} component={TicTacToe}/>
        </Switch>
      </Router>
    )
  }
}

export default App;
