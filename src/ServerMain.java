import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
//go back and change SErverListenerModified to ServersListener (class name and calling)

public class ServerMain
{
    public static void main(String[] args)
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(8001);

            Socket xCon = serverSocket.accept();
            ObjectOutputStream xos = new ObjectOutputStream(xCon.getOutputStream());
            ObjectInputStream xis = new ObjectInputStream(xCon.getInputStream());

            xos.writeObject(new CommandFromServer(CommandFromServer.CONNECTED_AS_RED,null));
            System.out.println("Red has Connected.");

            ServerListenerModified sl = new ServerListenerModified(xis,xos,'X');
            Thread t = new Thread(sl);
            t.start();

            Socket oCon = serverSocket.accept();
            ObjectOutputStream oos = new ObjectOutputStream(oCon.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(oCon.getInputStream());

            oos.writeObject(new CommandFromServer(CommandFromServer.CONNECTED_AS_BLUE,null));
            System.out.println("Blue has Connected.");

            sl = new ServerListenerModified(ois,oos,'O');
            t = new Thread(sl);
            t.start();


            xos.writeObject(new CommandFromServer(CommandFromServer.RED_TURN,null));
            oos.writeObject(new CommandFromServer(CommandFromServer.RED_TURN,null));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
