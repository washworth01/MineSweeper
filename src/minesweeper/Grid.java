package minesweeper;

import java.util.Random;

public class Grid extends Game
{	
	private int size;
	private int numberOfBombs;
	private Tile[][] gameGrid;
	
	public Grid()
	{
		this.size = 9;
		this.setNumberOfBombs(10);
		createGrid(size, numberOfBombs);
	}
	
	private void createGrid(int size, int numberOfBombs)
	{	
		gameGrid = new Tile[size][size];
		
		for(int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				gameGrid[i][j] = new Tile();
				System.out.println(gameGrid[i][j].getIsBomb());
			}
		}
		
		placeBombs(numberOfBombs);
	}
	
	private void placeBombs(int numberOfBombs)
	{
		Random rand = new Random();
		int bombsLeft = numberOfBombs;
		
		while(bombsLeft > 0)
		{
			int xLocation = rand.nextInt(size);
			int yLocation = rand.nextInt(size);
	
			if (gameGrid[xLocation][yLocation].getIsBomb() == false)
			{
				gameGrid[xLocation][yLocation].setIsBomb(true);
				
				System.out.println(gameGrid[xLocation][yLocation].getIsBomb());
				
				calculateAdjacentBombs(xLocation, yLocation);
				bombsLeft--;
			}
		}
	}
	
	public void selectAdjacentEmptyTiles(int xLocation, int yLocation)
	{
		if (xLocation + 1 < 9 && gameGrid[xLocation + 1][yLocation].getIsBomb() != true  && gameGrid[xLocation + 1][yLocation].getIsSelected() != true)
		{
			gameGrid[xLocation + 1][yLocation].setIsSelected(true);
			if (gameGrid[xLocation + 1][yLocation].getAdjacentBombs() == 0)
			{
				selectAdjacentEmptyTiles(xLocation + 1, yLocation);
			}
		}
		if (xLocation - 1 > 0 && gameGrid[xLocation - 1][yLocation].getIsBomb() != true && gameGrid[xLocation - 1][yLocation].getIsSelected() != true)
		{
			gameGrid[xLocation - 1][yLocation].setIsSelected(true);
			if (gameGrid[xLocation - 1][yLocation].getAdjacentBombs() == 0)
			{
				selectAdjacentEmptyTiles(xLocation - 1, yLocation);
			}
		}
		if (yLocation + 1 < 9 && gameGrid[xLocation][yLocation + 1].getIsBomb() != true && gameGrid[xLocation][yLocation + 1].getIsSelected() != true)
		{
			gameGrid[xLocation][yLocation + 1].setIsSelected(true);
			if (gameGrid[xLocation][yLocation + 1].getAdjacentBombs() == 0)
			{
				selectAdjacentEmptyTiles(xLocation, yLocation + 1);
			}
		}
		if (yLocation - 1 > 0 && gameGrid[xLocation][yLocation - 1].getIsBomb() != true && gameGrid[xLocation][yLocation - 1].getIsSelected() != true)
		{
			gameGrid[xLocation][yLocation - 1].setIsSelected(true);
			if (gameGrid[xLocation][yLocation - 1].getAdjacentBombs() == 0)
			{
				selectAdjacentEmptyTiles(xLocation, yLocation - 1);
			}
		}
		if (xLocation + 1 < 9 && yLocation + 1 < 9 && gameGrid[xLocation + 1][yLocation + 1].getIsBomb() != true && gameGrid[xLocation + 1][yLocation + 1].getIsSelected() != true)
		{
			gameGrid[xLocation + 1][yLocation + 1].setIsSelected(true);
			if (gameGrid[xLocation + 1][yLocation + 1].getAdjacentBombs() == 0)
			{
				selectAdjacentEmptyTiles(xLocation + 1, yLocation + 1);
			}
		}
		if (xLocation - 1 > 0 && yLocation + 1 < 9 && gameGrid[xLocation - 1][yLocation + 1].getIsBomb() != true && gameGrid[xLocation - 1][yLocation + 1].getIsSelected() != true)
		{
			gameGrid[xLocation - 1][yLocation + 1].setIsSelected(true);
			if (gameGrid[xLocation - 1][yLocation + 1].getAdjacentBombs() == 0)
			{
				selectAdjacentEmptyTiles(xLocation - 1, yLocation + 1);
			}
		}
		if (xLocation - 1 > 0 && yLocation - 1 > 0 && gameGrid[xLocation - 1][yLocation - 1].getIsBomb() != true && gameGrid[xLocation - 1][yLocation - 1].getIsSelected() != true)
		{
			gameGrid[xLocation - 1][yLocation - 1].setIsSelected(true);
			if (gameGrid[xLocation - 1][yLocation - 1].getAdjacentBombs() == 0)
			{
				selectAdjacentEmptyTiles(xLocation + 1, yLocation -1);
			}
		}
		if (xLocation + 1 < 9 && yLocation - 1 > 0 && gameGrid[xLocation + 1][yLocation - 1].getIsBomb() != true && gameGrid[xLocation + 1][yLocation - 1].getIsSelected() != true)
		{
			gameGrid[xLocation + 1][yLocation - 1].setIsSelected(true);
			if (gameGrid[xLocation + 1][yLocation + 1].getAdjacentBombs() == 0)
			{
				selectAdjacentEmptyTiles(xLocation + 1, yLocation + 1);
			}
		}
	}
	
	private void calculateAdjacentBombs(int xLocation, int yLocation)
	{
		if (xLocation + 1 < 9)
		{
			gameGrid[xLocation + 1][yLocation].setAdjacentBombs(gameGrid[xLocation + 1][yLocation].getAdjacentBombs() + 1);
		}
		if (xLocation - 1 > 0)
		{
			gameGrid[xLocation - 1][yLocation].setAdjacentBombs(gameGrid[xLocation - 1][yLocation].getAdjacentBombs() + 1);
		}
		if (yLocation + 1 < 9)
		{
			gameGrid[xLocation][yLocation + 1].setAdjacentBombs(gameGrid[xLocation][yLocation + 1].getAdjacentBombs() + 1);
		}
		if (yLocation - 1 > 0)
		{
			gameGrid[xLocation][yLocation - 1].setAdjacentBombs(gameGrid[xLocation][yLocation - 1].getAdjacentBombs() + 1);
		}
		if (xLocation + 1 < 9 && yLocation + 1 < 9)
		{
			gameGrid[xLocation + 1][yLocation + 1].setAdjacentBombs(gameGrid[xLocation + 1][yLocation + 1].getAdjacentBombs() + 1);
		}
		if (xLocation - 1 > 0 && yLocation + 1 < 9)
		{
			gameGrid[xLocation - 1][yLocation + 1].setAdjacentBombs(gameGrid[xLocation - 1][yLocation + 1].getAdjacentBombs() + 1);
		}
		if (xLocation - 1 > 0 && yLocation - 1 > 0)
		{
			gameGrid[xLocation - 1][yLocation - 1].setAdjacentBombs(gameGrid[xLocation - 1][yLocation - 1].getAdjacentBombs() + 1);
		}
		if (xLocation + 1 < 9 && yLocation - 1 > 0)
		{
			gameGrid[xLocation + 1][yLocation - 1].setAdjacentBombs(gameGrid[xLocation + 1][yLocation - 1].getAdjacentBombs() + 1);
		}
	}
	
	public int getSize()
	{
		return size;
	}
	
	public void setSize(int size)
	{
		this.size = size;
	}
	
	public Tile[][] getGameGrid()
	{
		return gameGrid;
	}
	
	public void setGameGrid(Tile[][] gameGrid)
	{
		this.gameGrid = gameGrid;
	}

	public int getNumberOfBombs() {
		return numberOfBombs;
	}

	public void setNumberOfBombs(int numberOfBombs) {
		this.numberOfBombs = numberOfBombs;
	}
}
