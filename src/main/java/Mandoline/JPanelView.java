package Mandoline;

/**
 *
 * @author STEPHAN
 */
public abstract class JPanelView extends javax.swing.JPanel implements ModelListener{
	/**
     *
     */
    protected MainController controller = null;
 
	/**
     *
     * @param controller
     */
    public JPanelView(MainController controller){
		super();
 
		this.controller = controller;
	}
 
	/**
     *
     * @return
     */
    public final MainController getController(){
		return controller;
	}
}
