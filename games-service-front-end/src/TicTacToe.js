import React, { Component } from 'react';
import './TicTacToe.css';
import { Link } from 'react-router-dom';
import { Button, Container } from 'reactstrap';
import { Table, TableHead, TableRow, TableCell } from '@material-ui/core';
import { useEffect } from 'react';

class TicTacToe extends Component {

	data = {
		board: [
			[null, null, null],
			[null, null, null],
			[null, null, null]
		]
	};

	renderTable() {
		return (
			<Table aria-label="board">
				{ this.renderRow(0) }
				{ this.renderRow(1) }
				{ this.renderRow(2) }
			</Table>
		);
	}

	renderRow(x) {
		return (
			<TableRow>
				{ this.renderCell(x, 0) }
				{ this.renderCell(x, 1) }
				{ this.renderCell(x, 2) }
			</TableRow>
		);
	}

	renderCell(x, y) {
		return (
			<TableCell class="cell">
				{(() => {
					if(this.data.board[x][y] == 'X') {
						console.log("X")
						return (<img src="/cross.png" className="mark"/>)
					} else if(this.data.board[x][y] == 'O') {
						console.log("O")
						return (<img src="/circle.png" className="mark"/>)
					}
				})()}
			</TableCell>
		);
	}

  render() {
    return (
      <div>
        <Container fluid>
					<h1 className="title">
						<img src="/logo192.png" className="logo"/>
						<span className="title-text">Tic Tac Toe</span>
					</h1>
					{ this.renderTable() }
        </Container>
      </div>
    );
  }

	fetchData() {
			fetch('http://localhost:8080/api/v1/tictactoe/board')
	    .then(res => res.json())
	    .then((data) => {
				this.data = data
				console.log(this.data.board)
	    })
	    .catch(console.log)
	}

	componentDidMount() {
			this.fetchData();
  }

}

export default TicTacToe;
