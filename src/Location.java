/*	This framework Copyright (C) 2014 Suzanne Norris. 
 *	For a full copyright statement, see the attached LISENCE.txt
 */
import java.util.ArrayList;
public class Location {
	public Location(){
		contents=new ArrayList<Item>();
		connected=new Location[Direction.getNum()];
		locs.add(this);
	}
	
	private ArrayList<Item> contents;
	private Location[] connected; // [0] is to the direction with id 0, 1 is 1, etc
	
	private static ArrayList<Location> locs;
	
	public static boolean remove(Location l,Location newLoc){ //severs all connections and removes l from locs and sets contents' locations to newLoc
		for(Location adjacent: l.connected){
			adjacent.disconnect(l);
		}
		for(Item thing: l.contents){
			thing.setLoc(newLoc);
		}
		return locs.remove(l);
	}
	
	public Location getConnect(Direction d){
		return connected[d.getID()];
	}
	public void connect(Direction d, Location l){//location l is direction d of this one
		connected[d.getID()]=l;
		l.connect(d.getOpposite(),this);
	}
	public void connectOneWay(Direction d, Location l){//one way connection from this --> l but not back
		connected[d.getID()]=l;
	}
	public void disconnect(Location l){ //severs this --> l and this <-- l!
		for(int i=0;i<connected.length;i++){
			if(connected[i].equals(l)){
				connected[i]=null;
			}
		}
	}
	public ArrayList<Direction> getPassages(){ //list of directions available
		ArrayList<Direction> ret=new ArrayList<>();
		for(int i=0;i<connected.length;i++){
			if(connected[i]!=null){
				ret.add(Direction.getDirection(i));
			}
		}
		return ret;
	}
	public boolean contains(Item i){
		return contents.contains(i);
	}
	public void add(Item i){
		contents.add(i);
	}
	public boolean remove(Item i){
		return contents.remove(i);
	}
}
