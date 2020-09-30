import React from 'react';
import Component from 'react';
import Router from 'react';
import Route from 'react';
import './App.css';
import './TicTacToe.js';

class App extends Component {
  render() {
    return (
      <Router>
        <Route exact path="/tictactoe" component={TicTacToe} />
      </Router>
    );
  }
}

export default App;
