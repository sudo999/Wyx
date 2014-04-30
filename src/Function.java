


public abstract class Function { //defines a function which "verbs" objects of type object
	public Function(String name,Class<Object> useOn){
		verb=name;
		type=useOn;
	}
	public String getVerb(){
		return verb;
	}
	private String verb;
	private Class<Object> type;
	protected boolean testExec(Object obj){
		if(obj.getClass().equals(type)){
			return true;
		}
		else{
			return false;
		}
	}
	public Object exec(Object obj){
		return null;
	}

}
