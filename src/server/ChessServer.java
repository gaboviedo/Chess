import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class ChessServer extends Application implements ChessConstants{
    private int sessionNo=1;
    @Override
    public void start(Stage primaryStage){
        TextArea taLog = new TextArea();
        //Create scene
        Scene scene=new Scene(new ScrollPane(taLog),450,200);
        primaryStage.setTitle("ChessServer");
        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(()->{
            try{
                //Create server socket
                ServerSocket serverSocket = new ServerSocket(8000);
                Platform.runLater(()->taLog.appendText(new Date()+": Server started at socket 8000"));
                //create session
                while(true){
                    Platform.runLater(()->taLog.appendText(new Date()+"Wait for opponenent to join session"+sessionNo+'\n'));
                    //conect p1
                    Socket p1=serverSocket.accept();
                    Platform.runLater(()->{
                        taLog.appendText(new Date()+"Player 1 joined session "+sessionNo+'\n');
                        taLog.appendText("Player 1's IP address"+p1.getInetAddress().getHostAddress()+'\n');
                    });
                    //initiate player 1
                    new DataOutputStream(p1.getOutputStream()).writeInt(PLAYER1);
                    //connect to player 2
                    Socket p2 = serverSocket.accept();
                    Platform.runLater(()->{
                        taLog.appendText(new Date()+": Player 2 has joined session "+sessionNo+'\n');
                        taLog.appendText("p2's ip address"+p2.getInetAddress().getHostAddress()+'\n');
                    });
                    //initiate p2
                    new DataOutputStream(p2.getOutputStream()).writeInt(PLAYER2);
                    //display this session and increment session number to allow for more games to run
                    Platform.runLater(()->
                            taLog.appendText(new Date()+":Start a threasd for session"+sessionNo++ +'\n'));
                    //Launch a new thread for this session of two players
                    new Thread(new HandleASession(p1,p2)).start();

                }
            }
            catch (IOException ex){
                ex.printStackTrace();
            }
        }).start();
    }

}