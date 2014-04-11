package Mandoline;

public abstract class JFrameView extends javax.swing.JFrame implements ModelListener{
	protected MainController controller = null;
 
	public JFrameView(MainController controller){
		super();
 
		this.controller = controller;
	}
 
	public final MainController getController(){
		return controller;
	}
 
	public abstract void display();
	public abstract void close();
}
