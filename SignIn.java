package GymApp;


import java.util.Optional;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class SignIn extends Application{

	private ImageView username,password;
	private TextField username_entry;
	private PasswordField password_entry;
	private Label LoginForm;
	private Button SignIn;
	private Alert A1=new Alert(Alert.AlertType.INFORMATION);
	private Alert A2=new Alert(Alert.AlertType.ERROR);
	private Stage stage1=new Stage();
	@Override
	public void start(Stage stage) {
		Group Root=new Group();
		Scene S1=new Scene(Root,300,300,Color.DARKSEAGREEN);
		stage.setScene(S1);
		stage.setTitle("تسجيل الدخول");
		
		LoginForm=new Label("تسجيل الدخول");
		LoginForm.setLayoutX(45);
		LoginForm.setLayoutY(10);
		LoginForm.setFont(new Font("bold",35));
		
		
		username=new ImageView(new Image(getClass().getResourceAsStream("SignIn.png")));
		username.setLayoutX(45);
		username.setLayoutY(80);
		
		username_entry=new TextField();
		username_entry.setLayoutX(120);
		username_entry.setLayoutY(92);
		username_entry.setStyle("-fx-background-radius: 12px;");
		username_entry.setPromptText("اسم المستخدم");
        username_entry.setOnKeyPressed((KeyEvent E)->{
        	if(E.getCode()==KeyCode.DOWN)
        	{
        		password_entry.requestFocus();
        	}
        });
		
		
		password=new ImageView(new Image(getClass().getResourceAsStream("pass.png")));
		password.setLayoutX(45);
		password.setLayoutY(150);
		
		password_entry=new PasswordField();
		password_entry.setLayoutX(120);
		password_entry.setLayoutY(162);
		password_entry.setStyle("-fx-background-radius: 12px;");
		password_entry.setPromptText("كلمه السر");
		password_entry.setOnKeyPressed((KeyEvent E)->{
			if(E.getCode()==KeyCode.UP)
			{
				username_entry.requestFocus();
			}
		});
		
		SignIn=new Button("تسجيل الدخول");
		SignIn.setLayoutX(30);
		SignIn.setLayoutY(220);
		SignIn.setPrefSize(250,30);
		SignIn.setFont(new Font("bold",20));
		SignIn.setStyle("-fx-background-radius: 14px;");
		SignIn.setOnAction((ActionEvent E)->{
			if(ManageDataBase.IsTrue(username_entry.getText(),password_entry.getText())&&(!username_entry.equals("")&&!password_entry.equals((""))))
			{
				A1.setTitle("نجاح");
				A1.setContentText("تم تسجيل الدخول بنجاح");
				Optional<ButtonType> result=A1.showAndWait();
				if(result.isPresent()&&result.get()==ButtonType.OK)
				{
					try {
						new Menu().start(stage1);
					} catch (Exception e) {
					}
					stage.close(); {
					}
				}
			}
			else
			{
				A2.setTitle("فشل");
				A2.setContentText("خطا في اسم المستحدم او كلمه السر");
				A2.getDialogPane().setStyle("-fx-font-size: 12px");
				A2.show();
			}
		});
		
		Root.getChildren().addAll(LoginForm,username,username_entry,password,password_entry,SignIn);
		stage.setResizable(false);
		stage.show();
		
	}

}
