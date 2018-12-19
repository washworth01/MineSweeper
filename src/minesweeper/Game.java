package minesweeper;

public class Game 
{
	static Grid grid = new Grid();
		
	static void selectTile(int xLocation, int yLocation)
	{
		grid.getGameGrid()[xLocation][yLocation].setIsSelected(true);
		grid.selectAdjacentEmptyTiles(xLocation, yLocation);
	}
	
	static void flagTile(int xLocation, int yLocation)
	{
		if (grid.getGameGrid()[xLocation][yLocation].getIsFlagged() == true)
		{
			grid.getGameGrid()[xLocation][yLocation].setIsFlagged(false);
		}
		else
		{
			grid.getGameGrid()[xLocation][yLocation].setIsFlagged(true);
		}
	}
	
	static boolean isSelectedBomb(int xLocation, int yLocation)
	{
		if(grid.getGameGrid()[xLocation][yLocation].getIsBomb() == true)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
