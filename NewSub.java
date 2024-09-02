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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;

public class NewSub extends Application{

	private Label name,Age,job,social_case,times,price;
	private TextField name_entry,Age_entry,job_entry;
	private RadioButton Single,Married;
	private ComboBox<String> Times_week;
	private ToggleGroup Group=new ToggleGroup();
	private Button Subscribe,Reset_data;
	private int Times=8;
	private Alert A1=new Alert(Alert.AlertType.ERROR);
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,500,500,Color.BLANCHEDALMOND);
		stage.setScene(S1);
		stage.setTitle("اشتراك");
		
		Glow glow=new Glow();
		glow.setLevel(0.3);
		
		Scale scale=new Scale();
		scale.setX(1.040);
		scale.setY(1.040);
		
		name=new Label("الاسم");
		name.setLayoutX(400);
		name.setLayoutY(50);
		name.setFont(new Font("bold",25));
		
		
		name_entry=new TextField();
		name_entry.setLayoutX(160);
		name_entry.setLayoutY(55);
		name_entry.setStyle("-fx-text-alignment: right;-fx-background-radius: 12px;");
		name_entry.setPrefSize(200, 30);
		name_entry.setFont(new Font("bold",15));
		name_entry.setPromptText("ادخل الاسم");
		name_entry.setAlignment(Pos.TOP_RIGHT);
		
		
		Age=new Label("السن");
		Age.setLayoutX(400);
		Age.setLayoutY(110);
		Age.setFont(new Font("bold",25));
		
		
		Age_entry=new TextField();
		Age_entry.setLayoutX(160);
		Age_entry.setLayoutY(115);
		Age_entry.setStyle("-fx-background-radius: 12px;");
		Age_entry.setPrefSize(200, 30);
		Age_entry.setFont(new Font("bold",15));
		Age_entry.setPromptText("ادخل السن");
		Age_entry.setAlignment(Pos.TOP_RIGHT);
		
		
		job=new Label("الوظيفه");
		job.setLayoutX(375);
		job.setLayoutY(170);
		job.setFont(new Font("bold",25));
		
		job_entry=new TextField();
		job_entry.setLayoutX(160);
		job_entry.setLayoutY(175);
		job_entry.setStyle("-fx-background-radius: 12px;");
		job_entry.setPrefSize(200, 30);
		job_entry.setFont(new Font("bold",15));
		job_entry.setPromptText("ادخل الوظيفه");
		job_entry.setAlignment(Pos.TOP_RIGHT);
		
		
		social_case=new Label("الحاله الاجتماعيه");
		social_case.setLayoutX(295);
		social_case.setLayoutY(235);
		social_case.setFont(new Font("bold",25));
		
		Single=new RadioButton("اعزب");
		Single.setLayoutX(100);
		Single.setLayoutY(246);
		Single.setFont(new Font("bold",14));
		Single.setToggleGroup(Group);
		Single.setSelected(true);
		
		Married=new RadioButton("متزوج");
		Married.setLayoutX(200);
		Married.setLayoutY(246);
		Married.setFont(new Font("bold",14));
		Married.setToggleGroup(Group);
		
		
		times=new Label("عدد الحصص");
		times.setLayoutX(325);
		times.setLayoutY(300);
		times.setFont(new Font("bold",25));
		
		
		Times_week=new ComboBox<>();
		Times_week.getItems().addAll("2 في الاسبوع","3 في الاسبوع","4 في الاسبوع","5 في الاسبوع","يوميا");
		Times_week.setValue("2 في الاسبوع");
		Times_week.setLayoutX(180);
		Times_week.setLayoutY(307);
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
		price.setLayoutX(100);
		price.setLayoutY(305);
		price.setFont(new Font("bold",25));
		price.setTextFill(Color.RED);
		price.setBackground(Background.fill(Color.GOLD));
		
		
		Subscribe=new Button("اشتراك +");
		Subscribe.setLayoutX(80);
		Subscribe.setLayoutY(350);
		Subscribe.setFont(new Font("bold",25));
		Subscribe.setPrefSize(350, 30);
		Subscribe.setStyle("-fx-background-radius:15px;-fx-background-color: green;");
		Subscribe.addEventFilter(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);
			Subscribe.setEffect(glow);
			Subscribe.getTransforms().add(scale);
		});
		Subscribe.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);
			Subscribe.setEffect(null);
			Subscribe.getTransforms().remove(scale);
			
		});
		Subscribe.setOnAction((ActionEvent E)->{
			        if(name_entry.getText().isEmpty()||Age_entry.getText().isEmpty()||job_entry.getText().isEmpty())
			        {
			        	A1.setTitle("خطا");
			        	A1.setContentText("املا جميع الحقول");
			        	A1.show();			        	
			        }
			        else {
			        RadioButton selectedRadio=(RadioButton) Group.getSelectedToggle();
					ManageDataBase.NewSub(name_entry.getText(),Integer.valueOf(Age_entry.getText()), job_entry.getText(),selectedRadio.getText() , Times,Integer.valueOf(price.getText().substring(0,3)));
					stage.close();
			        }
			   });
		
		
		
		Reset_data=new Button("اعاده ادخال");
		Reset_data.setLayoutX(80);
		Reset_data.setLayoutY(430);
		Reset_data.setFont(new Font("bold",25));
		Reset_data.setPrefSize(350, 30);
		Reset_data.setStyle("-fx-background-radius:15px;-fx-background-color: orange;");
		Reset_data.addEventFilter(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);
			Reset_data.setEffect(glow);
			Reset_data.getTransforms().add(scale);
		});
		Reset_data.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);
			Reset_data.setEffect(null);
			Reset_data.getTransforms().remove(scale);
			
		});
		
		Reset_data.setOnAction((ActionEvent E)->{
			name_entry.setText("");
			Age_entry.setText("");
			job_entry.setText("");
			Times_week.setValue("2 في الاسبوع");
			Single.setSelected(true);
			price.setText(String.valueOf(ManageDataBase.getPriceByDays(2))+"$");
		});
		
		Root.getChildren().addAll(name,name_entry,Age,Age_entry,job,job_entry,social_case,Single,Married,times,Times_week,price,Subscribe,Reset_data);
		stage.setResizable(false);
		stage.show();
		
	}

}
