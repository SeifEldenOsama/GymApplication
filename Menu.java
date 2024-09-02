package GymApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class Menu extends Application{

	private Screen screen=Screen.getPrimary();
	private Rectangle2D bounds=screen.getVisualBounds();
	private double screen_width=bounds.getWidth();
	private double screen_height=bounds.getHeight();
	private Button new_client,Enter_client,renew_client,delete_client,All_clients,close,search_byname,settings;
	private ImageView MenuImage,new_client_image,Enter_client_image,renew_client_image,delete_client_image,All_clients_image,close_image,search_image,settings_image;
	private Label Menu;
	private Rectangle R2;
	private Stage new_stage=new Stage(),new_stage1=new Stage(),new_stage2=new Stage(),new_stage3=new Stage(),new_stage4=new Stage(),new_stage5=new Stage(),new_stage6=new Stage();
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,screen_width,screen_height);
		stage.setScene(S1);
		stage.setTitle("الادارة");
		
		MenuImage=new ImageView(new Image(getClass().getResourceAsStream("back1.jpg")));
				
		R2=new Rectangle(0,0,screen_width,100);
		R2.setFill(Color.ORANGE);
		
		Menu=new Label("ادارة صاله الالعاب");
		Menu.setLayoutX(550);
		Menu.setLayoutY(5);
		Menu.setFont(new Font("bold",60));
		
		
		Glow glow=new Glow();
		glow.setLevel(0.3);
		
		Scale scale=new Scale();
		scale.setX(1.040);
		scale.setY(1.040);
 
		
		new_client_image=new ImageView(new Image(getClass().getResourceAsStream("new.png")));
		
		new_client=new Button("مشترك جديد");
		new_client.setLayoutX(200);
		new_client.setLayoutY(150);
		new_client.setPrefSize(350, 150);
		new_client.setFont(new Font("bold",30));
		new_client.setStyle("-fx-background-radius: 20px;-fx-background-color: DARKCYAN;");
		new_client.setGraphic(new_client_image);
		new_client.setContentDisplay(ContentDisplay.TOP);
		new_client.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     new_client.getTransforms().add(scale);
		     new_client.setEffect(glow);
		});
		new_client.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 new_client.getTransforms().remove(scale);
			 new_client.setEffect(null);
		});
		new_client.setOnAction((ActionEvent E)->{
			try {
				new NewSub().start(new_stage);
			} catch (Exception e) {
				e.printStackTrace();
			}			
		});
		
		Enter_client_image=new ImageView(new Image(getClass().getResourceAsStream("chech.png")));
		
		Enter_client=new Button("تسجيل حضور");
		Enter_client.setLayoutX(600);
		Enter_client.setLayoutY(150);
		Enter_client.setPrefSize(350, 150);
		Enter_client.setFont(new Font("bold",30));
		Enter_client.setStyle("-fx-background-radius: 20px;-fx-background-color: GREEN;");
		Enter_client.setGraphic(Enter_client_image);
        Enter_client.setContentDisplay(ContentDisplay.TOP);		
        Enter_client.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     Enter_client.getTransforms().add(scale);
		     Enter_client.setEffect(glow);
		});
        Enter_client.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 Enter_client.getTransforms().remove(scale);
			 Enter_client.setEffect(null);
		});
        Enter_client.setOnAction((ActionEvent E)->{
        	try {
				new SignInSub().start(new_stage1);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        
        renew_client_image=new ImageView(new Image(getClass().getResourceAsStream("renew.png")));
		
        renew_client=new Button("تجديد الاشتراك");
        renew_client.setLayoutX(1000);
        renew_client.setLayoutY(150);
        renew_client.setPrefSize(350, 150);
        renew_client.setFont(new Font("bold",30));
        renew_client.setStyle("-fx-background-radius: 20px;-fx-background-color: GRAY;");
        renew_client.setGraphic(renew_client_image);
        renew_client.setContentDisplay(ContentDisplay.TOP);		
        renew_client.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     renew_client.getTransforms().add(scale);
		     renew_client.setEffect(glow);
		});
        renew_client.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 renew_client.getTransforms().remove(scale);
			 renew_client.setEffect(null);
		});
        
        renew_client.setOnAction((ActionEvent E)->{
        	try {
				new Renew().start(new_stage2);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        
        delete_client_image=new ImageView(new Image(getClass().getResourceAsStream("delete.png")));
		
        delete_client=new Button("الغاء الاشتراك");
        delete_client.setLayoutX(200);
        delete_client.setLayoutY(400);
        delete_client.setPrefSize(350, 150);
        delete_client.setFont(new Font("bold",30));
        delete_client.setStyle("-fx-background-radius: 20px;-fx-background-color: CRIMSON;");
        delete_client.setGraphic(delete_client_image);
        delete_client.setContentDisplay(ContentDisplay.TOP);		
        delete_client.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     delete_client.getTransforms().add(scale);
		     delete_client.setEffect(glow);
		});
        delete_client.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 delete_client.getTransforms().remove(scale);
			 delete_client.setEffect(null);
		});
        
        delete_client.setOnAction((ActionEvent E)->{
        	try {
				new Delete().start(new_stage3);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        
        All_clients_image=new ImageView(new Image(getClass().getResourceAsStream("All.png")));
		
        All_clients=new Button("عرض بيانات المشتركين");
        All_clients.setLayoutX(600);
        All_clients.setLayoutY(400);
        All_clients.setPrefSize(350, 150);
        All_clients.setFont(new Font("bold",30));
        All_clients.setStyle("-fx-background-radius: 20px;-fx-background-color: MEDIUMAQUAMARINE;"); 
        All_clients.setGraphic(All_clients_image);
        All_clients.setContentDisplay(ContentDisplay.TOP);		
        All_clients.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     All_clients.getTransforms().add(scale);
		     All_clients.setEffect(glow);
		});
        All_clients.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 All_clients.getTransforms().remove(scale);
			 All_clients.setEffect(null);
		});
        All_clients.setOnAction((ActionEvent E)->{
        	try {
				new CheckAll().start(new_stage4);
			} catch (Exception e) {
				e.printStackTrace();
			}      	
        });
		
        
		
        search_image=new ImageView(new Image(getClass().getResourceAsStream("search.png")));

        search_byname=new Button("بحث عن المعرف بالاسم");
        search_byname.setLayoutX(1000);
        search_byname.setLayoutY(400);
        search_byname.setPrefSize(350, 150);
        search_byname.setFont(new Font("bold",30));
        search_byname.setStyle("-fx-background-radius: 20px;-fx-background-color: GOLD;"); 
        search_byname.setGraphic(search_image);
        search_byname.setContentDisplay(ContentDisplay.TOP);		
        search_byname.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     search_byname.getTransforms().add(scale);
		     search_byname.setEffect(glow);
		});
        search_byname.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 search_byname.getTransforms().remove(scale);
			 search_byname.setEffect(null);
		});
        search_byname.setOnAction((ActionEvent E)->{
        	try {
				new search().start(new_stage5);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        settings_image=new ImageView(new Image(getClass().getResourceAsStream("setting.png")));
        
        settings=new Button("اعدادات");
        settings.setLayoutX(400);
        settings.setLayoutY(600);
        settings.setPrefSize(350, 150);
        settings.setFont(new Font("bold",30));
        settings.setStyle("-fx-background-radius: 20px;-fx-background-color: BLACK;");
        settings.setGraphic(settings_image);
        settings.setContentDisplay(ContentDisplay.TOP);		
        settings.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     settings.getTransforms().add(scale);
		     settings.setEffect(glow);
		});
        settings.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 settings.getTransforms().remove(scale);
			 settings.setEffect(null);
		});
        settings.setOnAction((ActionEvent E)->{
        	try {
				new setting().start(new_stage6);
			} catch (Exception e) {
				e.printStackTrace();
			}
        });
        
        
        close_image=new ImageView(new Image(getClass().getResourceAsStream("close.png")));
		
        close=new Button("اغلاق");
        close.setLayoutX(800);
        close.setLayoutY(600);
        close.setPrefSize(350, 150);
        close.setFont(new Font("bold",30));
        close.setStyle("-fx-background-radius: 20px;-fx-background-color: DARKRED;"); 
        close.setGraphic(close_image);
        close.setContentDisplay(ContentDisplay.TOP);		
        close.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     close.getTransforms().add(scale);
		     close.setEffect(glow);
		});
        close.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 close.getTransforms().remove(scale);
			 close.setEffect(null);
		});
        close.setOnAction((ActionEvent E)->{
        	System.exit(0);
        });
        
        
        
		Root.getChildren().addAll(MenuImage,R2,Menu,new_client,Enter_client,renew_client,delete_client,All_clients,search_byname,settings,close);
		stage.show();
	}

}
