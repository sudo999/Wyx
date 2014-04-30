
public class Item {
	public Item(String s, Location l, Function[] f){
		name=s;
		loc=l;
		START=loc;
		actions=f;
	}
	public Item(){
		name="an item";
		loc=null;
		START=loc;
		actions=null;
	}
	public String getName(){return name;}
	public Location getLoc(){return loc;}
	public Function getUses(){return actions[0];}
	
	public void setLoc(Location l){
		loc=l;
	}
	
	private String name;
	private Location loc;
	public final Location START;
	private Function[] actions;
}
class ItemUse extends Function{
	Item item;
	public ItemUse(String name,Class<Object> useOn, Item i) {
		super(name, useOn);
		item=i;
	}
	protected boolean testExec(Object o){
		return super.testExec(o);
	}
}