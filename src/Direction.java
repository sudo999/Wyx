/*	This framework Copyright (C) 2014 Suzanne Norris. 
 *	For a full copyright statement, see the attached LISENCE.txt
 */
import java.util.ArrayList;


public class Direction {
	public Direction(String name){
		this.setName(name);
		dirs.add(this);
	}
	private String name;
	private Direction opposite;
	private static ArrayList<Direction> dirs;
	public static int getNum(){
		return dirs.size();
	}
	public Direction getOpposite() {
		return opposite;
	}
	public void setOpposite(Direction opposite) {
		this.opposite = opposite;
	}
	public int getID(){
		return dirs.indexOf(this);
	}
	public static Direction getDirection(int id){
		return dirs.get(id);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
