package GymApp;

import javafx.application.Application;
import javafx.application.Platform;
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


public class SignInSub extends Application{

	private Label SubId1,Age,SocialCase,Job,Times_Remaining,Pay;
	private TextField SubId,AgeInfo,SocialCaseInfo,JobInfo,Times_RemainingInfo,PayInfo;
	private Button Sign;
	private Alert A1=new Alert(Alert.AlertType.ERROR);
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,950,600,Color.BLANCHEDALMOND);
		stage.setTitle("تسجيل حضور");
		
		
		Glow glow=new Glow();
		glow.setLevel(0.3);
		
		Scale scale=new Scale();
		scale.setX(1.040);
		scale.setY(1.040);
		
		SubId1=new Label("معرف المشترك");
		SubId1.setLayoutX(330);
		SubId1.setLayoutY(20);
		SubId1.setFont(new Font("bold",50));
		
		
		SubId=new TextField();
		SubId.setLayoutX(115);
		SubId.setLayoutY(115);
		SubId.setPrefSize(700,50);
		SubId.setStyle("-fx-background-radius: 14px");		
		SubId.setPromptText("ادخل المعرف");
		SubId.setFont(new Font("bold",60));
		SubId.setAlignment(Pos.TOP_CENTER);
		
		Sign=new Button("تسجيل");
		Sign.setLayoutX(220);
		Sign.setLayoutY(255);
		Sign.setPrefSize(500, 40);
		Sign.setFont(new Font("bold",30));
		Sign.setStyle("-fx-background-radius: 14px;-fx-background-color: ORANGE");
		Sign.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);	
			Sign.getTransforms().add(scale);
			Sign.setEffect(glow);
		});
		Sign.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);	
			Sign.getTransforms().remove(scale);
			Sign.setEffect(null);
		});
		Sign.setOnAction((ActionEvent E)->{
			try {
			if(ManageDataBase.IsFound(Integer.valueOf(SubId.getText())))
			{
				if(ManageDataBase.getTimes(Integer.valueOf(SubId.getText()))==0)
				{
					A1.setTitle("خطا");
					A1.setContentText("تم انتهاء اشتراك هذا المشترك, يرجي التجديد");
					A1.show();
				}
				else {
				SubInfo Info=ManageDataBase.SignIn(Integer.valueOf(SubId.getText()));
				SubId.setText(Info.getName());
				SubId.requestFocus();
				SubId.selectAll();
				AgeInfo.setText(String.valueOf(Info.getAge()));
				SocialCaseInfo.setText(Info.getSocialCase());
				JobInfo.setText(Info.getJob());
				Times_RemainingInfo.setText(String.valueOf(Info.getTimes()));
				PayInfo.setText(String.valueOf(Info.getPrice()));
				}
			}
			else
			{
				A1.setTitle("خطا");
				A1.setContentText("لا يوجد مشترك بهذا المعرف");
				A1.getDialogPane().setStyle("fx-font-size: 12px");
				A1.show();
			}
			}
			catch(Exception E1)
			{
				A1.setTitle("خطا");
				A1.setContentText("حدث خطا في الادخال");
				A1.show();
			}
		});
		
		Age=new Label("السن");
		Age.setLayoutX(20);
		Age.setLayoutY(350);
		Age.setFont(new Font("bold",35));
		
		AgeInfo=new TextField();
		AgeInfo.setLayoutX(125);
		AgeInfo.setLayoutY(350);
		AgeInfo.setFont(new Font("bold",25));
		AgeInfo.setStyle("-fx-background-radius: 14px");
		AgeInfo.setEditable(false);
		
		SocialCase=new Label("الحاله");
		SocialCase.setLayoutX(490);
		SocialCase.setLayoutY(350);
		SocialCase.setFont(new Font("bold",35));
		
		SocialCaseInfo=new TextField();
		SocialCaseInfo.setLayoutX(625);
		SocialCaseInfo.setLayoutY(350);
		SocialCaseInfo.setFont(new Font("bold",25));
		SocialCaseInfo.setStyle("-fx-background-radius: 14px");
		SocialCaseInfo.setEditable(false);
		
		
		Job=new Label("الوظيفه");
		Job.setLayoutX(10);
		Job.setLayoutY(450);
		Job.setFont(new Font("bold",35));
		
		JobInfo=new TextField();
		JobInfo.setLayoutX(125);
		JobInfo.setLayoutY(450);
		JobInfo.setFont(new Font("bold",25));
		JobInfo.setStyle("-fx-background-radius: 14px");
		JobInfo.setEditable(false);
		
		Times_Remaining=new Label("الباقي");
		Times_Remaining.setLayoutX(490);
		Times_Remaining.setLayoutY(450);
		Times_Remaining.setFont(new Font("bold",35));
		
		Times_RemainingInfo=new TextField();
		Times_RemainingInfo.setLayoutX(625);
		Times_RemainingInfo.setLayoutY(450);
		Times_RemainingInfo.setFont(new Font("bold",25));
		Times_RemainingInfo.setStyle("-fx-background-radius: 14px");
		Times_RemainingInfo.setEditable(false);
		
		Pay=new Label("مدفوع");
		Pay.setLayoutX(260);
		Pay.setLayoutY(530);
		Pay.setFont(new Font("bold",35));
		
		PayInfo=new TextField();
		PayInfo.setLayoutX(390);
		PayInfo.setLayoutY(530);
		PayInfo.setFont(new Font("bold",25));
		PayInfo.setStyle("-fx-background-radius: 14px");
		PayInfo.setEditable(false);
		
		
		
	    Root.getChildren().addAll(SubId1,SubId,Sign,Age,AgeInfo,SocialCase,SocialCaseInfo,Job,JobInfo,Times_Remaining,Times_RemainingInfo,Pay,PayInfo);
		stage.setScene(S1);
		stage.setResizable(false);
		stage.show();		
	}

}
