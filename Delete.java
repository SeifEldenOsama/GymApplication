package GymApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class Delete extends Application{

	private Label SubId;
	private TextField SubIdInfo;
	private Button Delete;
	private Alert A1=new Alert(Alert.AlertType.ERROR);
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,400,200,Color.BLANCHEDALMOND);
		stage.setScene(S1);
		stage.setTitle("الغاء اشتراك");
		
		
		Glow glow=new Glow();
		glow.setLevel(0.3);
		
		Scale scale=new Scale();
		scale.setX(1.040);
		scale.setY(1.040);
		
		
		SubId=new Label("معرف المشترك");
		SubId.setLayoutX(100);
		SubId.setLayoutY(5);
		SubId.setFont(new Font("bold",35));
		
		
		SubIdInfo=new TextField();
		SubIdInfo.setLayoutX(80);
		SubIdInfo.setLayoutY(60);
		SubIdInfo.setPrefSize(250, 30);
		SubIdInfo.setPromptText("ادخل المعرف");
		SubIdInfo.setFont(new Font("bold",25));
		SubIdInfo.setStyle("-fx-background-radius: 14px");
		SubIdInfo.setAlignment(Pos.TOP_CENTER);
		
		
		Delete=new Button("الغاء الاشتراك");
		Delete.setLayoutX(50);
		Delete.setLayoutY(130);
		Delete.setPrefSize(300, 25);
		Delete.setFont(new Font("bold",25));
		Delete.setStyle("-fx-background-radius: 16px;-fx-background-color: CRIMSON");
		Delete.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);
			Delete.getTransforms().add(scale);
			Delete.setEffect(glow);
		});
		Delete.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);
			Delete.getTransforms().remove(scale);
			Delete.setEffect(null);
		});
		
		Delete.setOnAction((ActionEvent E)->{
			try
			{
				if(ManageDataBase.IsFound(Integer.valueOf(SubIdInfo.getText())))
				{
					ManageDataBase.DeleteSub(Integer.valueOf(SubIdInfo.getText()));
				}
				else
				{
					A1.setTitle("خطا");
					A1.setContentText("هذا المعرف غير موجود");
					A1.show();
				}
			}
			catch(Exception E1)
			{
				A1.setTitle("خطا");
				A1.setContentText("حدث خطا في الادخال");
				A1.show();
				System.out.println(E1.getMessage());
			}
			
		});
		
		Root.getChildren().addAll(SubId,SubIdInfo,Delete);
		stage.setResizable(false);
		stage.show();
	}

}
