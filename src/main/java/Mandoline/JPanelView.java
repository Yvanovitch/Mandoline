package Mandoline;

public abstract class JPanelView extends javax.swing.JPanel implements ModelListener{
	protected MainController controller = null;
 
	public JPanelView(MainController controller){
		super();
 
		this.controller = controller;
	}
 
	public final MainController getController(){
		return controller;
	}
}
