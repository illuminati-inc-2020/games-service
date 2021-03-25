import React, { Component } from 'react';
import './App.css';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';

class Home extends Component {
  render() {
    return (
      <div>
        <Container fluid>
          <Button color="link"><Link to="/tic-tac-toe">Tic Tac Toe</Link></Button>
          <Button color="link"><Link to="/towers-of-hanoi">Towers of Hanoi</Link></Button>
          <Button color="link"><Link to="/find-word">Find Word</Link></Button>
        </Container>
      </div>
    );
  }
}

export default Home;
