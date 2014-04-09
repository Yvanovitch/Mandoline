package Mandoline;

public abstract class AbstractView extends javax.swing.JFrame implements ViewListener{
	protected MainController controller = null;
 
	public AbstractView(MainController controller){
		super();
 
		this.controller = controller;
	}
 
	public final MainController getController(){
		return controller;
	}
 
	public abstract void display();
	public abstract void close();
}
