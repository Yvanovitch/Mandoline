package Mandoline;

/**
 *
 * @author STEPHAN
 */
public abstract class JFrameView extends javax.swing.JFrame implements ModelListener{
	/**
     *
     */
    protected MainController controller = null;
 
	/**
     *
     * @param controller
     */
    public JFrameView(MainController controller){
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
 
	/**
     *
     */
    public abstract void display();
	/**
     *
     */
    public abstract void close();
}
