package minesweeper;

public class Tile
{
	private boolean isFlagged;
	private boolean isBomb;
	private boolean isSelected;
	private int adjacentBombs;	
	
	public Tile()
	{
		this.isFlagged = false;
		this.isBomb = false;
		this.isSelected = false;
		this.adjacentBombs = 0;
	}
			
	public void flagTile(boolean isFlagged)
	{
		if(this.isFlagged)
		{
			this.isFlagged = false;
		}
		else
		{
			this.isFlagged = true;
		}
	}
	
	public void select()
	{
		this.isSelected = true;
	}
	
	@Override
	public String toString()
	{
		if (this.isSelected)
		{
			if (this.isBomb)
				{
					return "B";
				}
			else
			{
				return((Integer)adjacentBombs).toString();
			}
		}
		else if (this.isFlagged)
		{
			return "F";
		}
		
		else
		{
			return "_";
		}
	}
	
	public boolean getIsBomb()
	{
		return isBomb;
	}
	
	public void setIsBomb(boolean isBomb)
	{
		this.isBomb = isBomb;
	}
	
	public boolean getIsSelected()
	{
		return isSelected;
	}
	
	public void setIsSelected(boolean isSelected)
	{
		this.isSelected = isSelected;
	}
	
	public boolean getIsFlagged()
	{
		return isFlagged;
	}
	
	public void setIsFlagged(boolean isFlagged)
	{
		this.isFlagged = isFlagged;
	}
	
	public int getAdjacentBombs()
	{
		return adjacentBombs;
	}
	
	public void setAdjacentBombs(int adjacentBombs)
	{
		 this.adjacentBombs = adjacentBombs;
	}
}

