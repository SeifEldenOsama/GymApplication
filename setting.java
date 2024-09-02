package GymApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class setting extends Application{
 
	private ComboBox<String> Times_week;
	private TextField PriceInfo;
	private Button Update;
	private int Price,days;
	private Alert A1=new Alert(Alert.AlertType.ERROR);
	private Alert A2=new Alert(Alert.AlertType.INFORMATION);
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,400,230,Color.BLANCHEDALMOND);
		stage.setScene(S1);
		stage.setTitle("ضبط السعر");
		
		Glow glow=new Glow();
		glow.setLevel(0.3);
		
		Scale scale=new Scale();
		scale.setX(1.040);
		scale.setY(1.040);
		
		
		Times_week=new ComboBox<>();
		Times_week.setLayoutX(100);
		Times_week.setLayoutY(40);
		Times_week.setPrefSize(200, 30);
		Times_week.setStyle("-fx-background-radius: 16px; -fx-background-color: BURLYWOOD;-fx-font-size: 16px");
		Times_week.getItems().addAll("2 في الاسبوع","3 في الاسبوع","4 في الاسبوع","5 في الاسبوع","يوميا");
		Times_week.setValue("2 في الاسبوع");
		Times_week.setOnAction((ActionEvent E)->{
			String Selected=Times_week.getSelectionModel().getSelectedItem();
			if(Selected=="2 في الاسبوع")
			{
                    PriceInfo.setText(String.valueOf(ManageDataBase.getPriceByDays(2)));
                    days=2;
			}
			else if(Selected=="3 في الاسبوع")
			{
				PriceInfo.setText(String.valueOf(ManageDataBase.getPriceByDays(3)));
				days=3;
			}
			else if(Selected=="4 في الاسبوع")
			{
				PriceInfo.setText(String.valueOf(ManageDataBase.getPriceByDays(4)));
				days=4;
			}
			else if(Selected=="5 في الاسبوع")
			{
				PriceInfo.setText(String.valueOf(ManageDataBase.getPriceByDays(5)));
				days=5;
			}
			else
			{
				PriceInfo.setText(String.valueOf(ManageDataBase.getPriceByDays(7)));
				days=7;
			}						
			
		});
		
		PriceInfo=new TextField(String.valueOf(ManageDataBase.getPriceByDays(2)));
		PriceInfo.setLayoutX(50);
		PriceInfo.setLayoutY(100);
		PriceInfo.setPrefSize(300, 30);
		PriceInfo.setStyle("-fx-background-radius: 17px;-fx-font-size: 16px");
		PriceInfo.setAlignment(Pos.TOP_CENTER);
		
		
		Update=new Button("تعديل");
		Update.setLayoutX(50);
		Update.setLayoutY(150);
		Update.setPrefSize(300, 50);
		Update.setStyle("-fx-background-radius: 18px; -fx-font-size: 22px;-fx-background-color: DARKGREEN");
		Update.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
		     stage.getScene().setCursor(Cursor.HAND);
		     Update.getTransforms().add(scale);
		     Update.setEffect(glow);
		});
		Update.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			 stage.getScene().setCursor(Cursor.DEFAULT);	
			 Update.getTransforms().remove(scale);
			 Update.setEffect(null);
		});
		Update.setOnAction((ActionEvent E)->{
			try
			{
				Price=Integer.valueOf(PriceInfo.getText());
				ManageDataBase.UpdatePrice(Price, days);
				A2.setTitle("نجاح");
				A2.setContentText("تم التعديل بنجاح");
				A2.getDialogPane().setStyle("-fx-font-size: 16px");
				A2.show();
			}
			catch(Exception E1)
			{
				A1.setTitle("خطا");
				A1.setContentText("حدث خطا في الادخال");
				A1.getDialogPane().setStyle("-fx-font-size: 16px");
				A1.show();
			}
			
		});
		
		
		Root.getChildren().addAll(Times_week,PriceInfo,Update);
		stage.setResizable(false);
		stage.show();		
	}

}
