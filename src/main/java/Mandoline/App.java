package Mandoline;

/**
 * Hello world!
 *
 */
    import uk.co.caprica.vlcj.binding.LibVlc;
    import uk.co.caprica.vlcj.runtime.RuntimeUtil;

    import com.sun.jna.Native;
    import com.sun.jna.NativeLibrary;
    import javax.swing.JFrame;
    import uk.co.caprica.vlcj.component.EmbeddedMediaPlayerComponent;
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), "C:/Program Files/VideoLAN/VLC");
        Native.loadLibrary(RuntimeUtil.getLibVlcLibraryName(), LibVlc.class);
        JFrame frame = new JFrame("vlcj Tutorial");

        EmbeddedMediaPlayerComponent mediaPlayerComponent = new EmbeddedMediaPlayerComponent();

        frame.setContentPane(mediaPlayerComponent);

        frame.setLocation(100, 100);
        frame.setSize(1050, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        mediaPlayerComponent.getMediaPlayer().playMedia("test.avi");
        mediaPlayerComponent.getMediaPlayer().start();
        while(mediaPlayerComponent.getMediaPlayer().getTime() < 8000){}
        mediaPlayerComponent.getMediaPlayer().pause();
        mediaPlayerComponent.getMediaPlayer().setPosition((float)0.5);
    }
}
