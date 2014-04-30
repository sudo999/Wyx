import java.util.ArrayList;


public class User {
	//static class
	private static ArrayList<Item> inv; //inventory
	private static int health; //health
	private static int maxHealth; //maximum possible health
	private static double multiplier; //damage multiplier; changes with armor and status effects
	private static Location loc; //location
	private static Direction prev; //previous direction traveled
	
	public static ArrayList<Item> getInv(){ 
		return inv;
	}
	public static boolean pickUp(Item i){ //only works if i is in loc.contents
		if(loc.remove(i)){
			inv.add(i);
			return true;
		}else{
			return false;
		}
		
	}
	public static void obtain(Item i){ //always works when i exists
		i.getLoc().remove(i);
		inv.add(i);
	}
	public static boolean drop(Item i){ //only works if i is in inventory
		if(inv.contains(i)){
			inv.remove(i);
			loc.add(i);
			return true;
		}else{
			return false;
		}
	}
	public static boolean go(Direction d){ //only works if there is a location in that direction
		if(loc.getConnect(d)!=null){
			User.setLoc(loc.getConnect(d));
			return true;
		}else{
			return false;
		}
	}
	public static boolean cont(){ //keeps go()ing in the direction previously specified as long as prev is defined. 
		return User.go(prev);
	}
	public static boolean back(){ //works like go() so long as prev has an opposite and the connection is two-way. 
		return User.go(prev.getOpposite());  
	}
	public static void setLoc(Location l){ //always works so long as l exists
		loc=l;
	}
	public static void heal(int hp){ //adds health up to maxHealth
		health=Math.max(health+hp, maxHealth);
	}
	public static void hpUp(int hp){ //increases maxHealth
		maxHealth+=hp;
	}
	public static void fullHeal(){//full heal
		health=maxHealth;
	}
	public static boolean damage(int dmg){//decreases health. returns true if health<=dmg*multiplier (in the event of death)
		if(health>dmg*multiplier){
			health-=dmg*multiplier;
			return false;
		}else{
			health=0;
			return true;
		}
	}
}
