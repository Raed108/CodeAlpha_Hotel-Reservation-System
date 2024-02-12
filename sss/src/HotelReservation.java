import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class HotelReservation extends Application {
    public String [][] a=new String[200][4];
    public String [][] k=new String[200][5];
    public Button search=new Button("Search For Rooms");
    public Button bookingDetails=new Button("Booking Details");
    public Button okay=new Button("Okay");
    public Button back=new Button("Back");
    public Button back1=new Button("Back");
    public Button back2=new Button("Back");
    public Label u=new Label("");
    public static void main(String[]args){launch(args);}
    double lastY=0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox root = new VBox(20);
        Scene scene=new Scene(root,800,600);
        primaryStage.setTitle("Hotel Reservation");
        root.requestFocus();
        root.setAlignment(Pos.CENTER);
        primaryStage.setScene(scene);
        primaryStage.show();
        Label l1=new Label("Welcome to our Hotel");
        l1.setFont(Font.font("Arial", FontWeight.BOLD, 50));
        Random random = new Random();
        for (int i=0;i<100;i++){
            a[i][0]=String.valueOf(i+101);
            a[i][1]="Standard Room";
            int randomNumber = random.nextInt(121) + 380;
            a[i][2]= String.valueOf(randomNumber);
            a[i][3]= "Unreserved";
        }
        for (int i=100;i<150;i++){
            a[i][0]=String.valueOf(i+101);
            a[i][1]="Standard Suite";
            int randomNumber = random.nextInt(141) + 640;
            a[i][2]= String.valueOf(randomNumber);
            a[i][3]= "Unreserved";
        }
        for (int i=150;i<180;i++){
            a[i][0]=String.valueOf(i+101);
            a[i][1]="Premium Suite";
            int randomNumber = random.nextInt(151) + 1650;
            a[i][2]= String.valueOf(randomNumber);
            a[i][3]= "Unreserved";
        }
        for (int i=180;i<200;i++){
            a[i][0]=String.valueOf(i+101);
            a[i][1]="Presidential Suite";
            int randomNumber = random.nextInt(1501) + 3500;
            a[i][2]= String.valueOf(randomNumber);
            a[i][3]= "Unreserved";
        }
        for(int i=0;i<200;i++){
            k[i][0]=a[i][0];
            k[i][1]=a[i][1];
            k[i][2]=a[i][2];
            k[i][3]=a[i][3];
        }
        okay.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        okay.setOnMouseEntered(event -> {
            okay.setStyle("-fx-background-color: #315a7d; -fx-text-fill: white;");
        });
        okay.setOnMouseExited(event -> {
            okay.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        });
        back.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        back.setOnMouseEntered(event -> {
            back.setStyle("-fx-background-color: #b30000; -fx-text-fill: white;");
        });
        back.setOnMouseExited(event -> {
            back.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        });
        back1.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        back1.setOnMouseEntered(event -> {
            back1.setStyle("-fx-background-color: #b30000; -fx-text-fill: white;");
        });
        back1.setOnMouseExited(event -> {
            back1.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        });
        back2.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        back2.setOnMouseEntered(event -> {
            back2.setStyle("-fx-background-color: #b30000; -fx-text-fill: white;");
        });
        back2.setOnMouseExited(event -> {
            back2.setStyle("-fx-background-color: red; -fx-text-fill: white;");
        });
        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(2.0);
        dropShadow.setOffsetY(2.0);
        back.setEffect(dropShadow);
        back1.setEffect(dropShadow);
        back2.setEffect(dropShadow);
        okay.setEffect(dropShadow);
        search.setEffect(dropShadow);
        bookingDetails.setEffect(dropShadow);
        search.setOnAction(event -> {
            VBox v=new VBox(25);
            v.setAlignment(Pos.CENTER);
            ScrollPane scrollPane = new ScrollPane(v);
            scrollPane.setPrefSize(800, 600);
            Scene scene1 = new Scene(scrollPane);
            Label la=new Label("Available Rooms");
            la.setFont(Font.font("Arial", FontWeight.BOLD, 30));
            Label lc=new Label("");
            v.getChildren().addAll(lc,la,back);
            primaryStage.setScene(scene1);
            back.setOnAction(event1 -> {
                u.setText("");
                primaryStage.setScene(scene);
            });
            for (int i=0;i<200;i++){
                Label l=new Label("   Room Number : "+k[i][0]+"   Room Categorization : "+k[i][1]+"    Price : "+k[i][2]+"$    Status : "+k[i][3]+"   ");
                Button b=new Button("Reserve");
                if(k[i][3].equals("Reserved")){
                    b.setDisable(true);
                }
                b.setEffect(dropShadow);
                b.setStyle("-fx-background-color: #670067 ; -fx-text-fill: white;");
                b.setOnMouseEntered(e -> {
                    b.setStyle("-fx-background-color: #350035; -fx-text-fill: white;");
                });
                b.setOnMouseExited(e -> {
                    b.setStyle("-fx-background-color: #670067; -fx-text-fill: white;");
                });
                int finalI = i;
                b.setOnAction(event1 -> {
                    ToggleGroup toggleGroup = new ToggleGroup();
                    RadioButton radioButton1 = new RadioButton("Cash           ");
                    radioButton1.setToggleGroup(toggleGroup);
                    RadioButton radioButton2 = new RadioButton("Credit Card");
                    radioButton2.setToggleGroup(toggleGroup);
                    VBox vBox=new VBox(20);
                    Pane pane=new Pane();
                    Scene scene2=new Scene(vBox,800,600);
                    okay.setDisable(true);
                    Label l2=new Label("Payment Method");
                    l2.setFont(Font.font("Arial", FontWeight.BOLD, 25));
                    pane.getChildren().addAll(okay,back1);
                    okay.setLayoutX(30);
                    okay.setLayoutY(20);
                    back1.setLayoutX(100);
                    back1.setLayoutY(20);
                    pane.setMaxSize(200,200);
                    vBox.getChildren().addAll(l2,radioButton1,radioButton2,pane);
                    vBox.requestFocus();
                    vBox.setAlignment(Pos.CENTER);
                    primaryStage.setScene(scene2);
                    toggleGroup.selectedToggleProperty().addListener((obs, oldToggle, newToggle) -> {
                        if (newToggle != null) {
                                    okay.setDisable(false);
                                }
                        RadioButton selectedRadioButton = (RadioButton) newToggle;
                        String s= selectedRadioButton.getText();
                        k[finalI][4]=s+"   ";
                            });
                    okay.setOnAction(event2 -> {
                        l.setText("   Room Number : "+a[finalI][0]+"   Room Categorization : "+a[finalI][1]+"    Price : "+a[finalI][2]+"$    Status : Reserved      ");
                        b.setDisable(true);
                        primaryStage.setScene(scene1);
                        k[finalI][0]=a[finalI][0];
                        k[finalI][1]=a[finalI][1];
                        k[finalI][2]=a[finalI][2];
                        k[finalI][3]="Reserved";
                    });
                    back1.setOnAction(event2 -> {
                        u.setText("");
                        primaryStage.setScene(scene1);
                    });
                });
                HBox h=new HBox(15);
                l.setMaxHeight(40);
                l.setStyle("-fx-background-color: #f2cccc;");
                h.getChildren().addAll(l,b);
                Label lj=new Label("");
                lj.setMaxHeight(0);
                v.getChildren().addAll(h,lj);
            }
        });
        bookingDetails.setOnAction(event -> {
            for(int i=0;i<200;i++){
                if(k[i][3].equals("Reserved")){
                    VBox m=new VBox(25);
                    m.setAlignment(Pos.CENTER);
                    ScrollPane scrollPane1 = new ScrollPane(m);
                    scrollPane1.setPrefSize(800, 600);
                    Scene scene3 = new Scene(scrollPane1);
                    primaryStage.setScene(scene3);
                    Label g=new Label("Booking Details");
                    g.setFont(Font.font("Arial", FontWeight.BOLD, 30));
                    Label r=new Label("");
                    m.getChildren().addAll(r,g,back2);
                    back2.setOnAction(event1 -> {
                        u.setText("");
                        primaryStage.setScene(scene);
                    });
                    for(int j=0;j<200;j++){
                        if(k[j][3].equals("Reserved")){
                            Label l=new Label("   Room Number : "+k[j][0]+"   Room Categorization : "+k[j][1]+"    Price : "+k[j][2]+"$    Payment Method : "+k[j][4]+"   ");
                            l.setStyle("-fx-background-color: #f2cccc;");
                            l.setMinHeight(40);
                            m.getChildren().addAll(l);
                        }
                    }
                }
                else{
                    u.setText("Warning : You haven't booked any room yet.");
                    u.setStyle("-fx-text-fill: red;");
                    u.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                }
            }
        });
        search.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        search.setOnMouseEntered(e -> {
            search.setStyle("-fx-background-color: #315a7d; -fx-text-fill: white;");
        });
        search.setOnMouseExited(e -> {
            search.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        });

        bookingDetails.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        bookingDetails.setOnMouseEntered(e -> {
            bookingDetails.setStyle("-fx-background-color: #315a7d; -fx-text-fill: white;");
        });
        bookingDetails.setOnMouseExited(e -> {
            bookingDetails.setStyle("-fx-background-color: #4682B4; -fx-text-fill: white;");
        });
        u.setText("");
        Label n=new Label("");
        root.getChildren().addAll(l1,n,search,bookingDetails,u);
    }
}
