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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Renew extends Application{

	private Label SubId,price;
	private TextField SubIdInfo;
	private ComboBox<String> Times_week;
	private Button Renew;
	private Alert A1=new Alert(Alert.AlertType.ERROR);
	private int Times=8;
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,500,300,Color.BLANCHEDALMOND);
		stage.setScene(S1);
		stage.setTitle("تجديد الاشتراك");
		
		Glow glow=new Glow();
		glow.setLevel(0.3);
		
		Scale scale=new Scale();
		scale.setX(1.040);
		scale.setY(1.040);
		
		SubId=new Label("معرف المشترك");
		SubId.setLayoutX(130);
		SubId.setLayoutY(15);
		SubId.setFont(new Font("bold",40));
		
		
		SubIdInfo=new TextField();
		SubIdInfo.setLayoutX(95);
		SubIdInfo.setLayoutY(80);
		SubIdInfo.setFont(new Font("bold",25));
		SubIdInfo.setPromptText("معرف المشترك");
		SubIdInfo.setStyle("-fx-background-radius: 14px");
		SubIdInfo.setAlignment(Pos.TOP_CENTER);
		
		Times_week=new ComboBox<>();
		Times_week.getItems().addAll("2 في الاسبوع","3 في الاسبوع","4 في الاسبوع","5 في الاسبوع","يوميا");
		Times_week.setValue("2 في الاسبوع");
		Times_week.setLayoutX(130);
		Times_week.setLayoutY(155);
		Times_week.setStyle("-fx-font-size: 14px;-fx-background-radius: 12px;-fx-background-color: BURLYWOOD");
		Times_week.setOnAction((ActionEvent E)->{
			String Selected=Times_week.getSelectionModel().getSelectedItem();
			if(Selected=="2 في الاسبوع")
			{
				price.setText(String.valueOf(ManageDataBase.getPriceByDays(2))+"$");
				Times=8;
			}
			else if(Selected=="3 في الاسبوع")
			{
				price.setText(String.valueOf(ManageDataBase.getPriceByDays(3))+"$");
				Times=12;
			}
			else if(Selected=="4 في الاسبوع")
			{
				price.setText(String.valueOf(ManageDataBase.getPriceByDays(4))+"$");
				Times=16;
			}
			else if(Selected=="5 في الاسبوع")
			{
				price.setText(String.valueOf(ManageDataBase.getPriceByDays(5))+"$");
				Times=20;
			}
			else
			{
				price.setText(String.valueOf(ManageDataBase.getPriceByDays(7))+"$");
				Times=30;
			}						
			
		});
		
		price=new Label(String.valueOf(ManageDataBase.getPriceByDays(2))+"$");
		price.setLayoutX(300);
		price.setLayoutY(152);
		price.setFont(new Font("bold",25));
		price.setTextFill(Color.RED);
		
		
		Renew=new Button("تجديد");
		Renew.setLayoutX(95);
		Renew.setLayoutY(200);
		Renew.setPrefSize(310, 25);
		Renew.setFont(new Font("bold",35));
		Renew.setStyle("-fx-background-radius: 16px;-fx-background-color: ORANGE");
		Renew.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);	
			Renew.getTransforms().add(scale);
			Renew.setEffect(glow);
		});
		Renew.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);	
			Renew.getTransforms().remove(scale);
			Renew.setEffect(null);
		});
		Renew.setOnAction((ActionEvent E)->{
			try
			{
				if(ManageDataBase.IsFound(Integer.valueOf(SubIdInfo.getText())))
				{
					ManageDataBase.RenewTimes(Integer.valueOf(SubIdInfo.getText()),Times ,Integer.valueOf(price.getText().substring(0,3)));					
				}
				else
				{
					A1.setTitle("خطا");
					A1.setContentText("هذا المعرف غير موجود");
					A1.getDialogPane().setStyle("-fx-font-size: 12px");
					A1.show();
				}
				
			}
			catch(Exception E1)
			{
				A1.setTitle("جطا");
				A1.setContentText("حدث خطا في الادخال");
				A1.getDialogPane().setStyle("-fx-font-size: 12px");
				A1.show();
			}
			
			
		});
		
		Root.getChildren().addAll(SubId,SubIdInfo,Times_week,price,Renew);
		stage.setResizable(false);
		stage.show();
	}

}
