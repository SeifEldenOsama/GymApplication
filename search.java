package GymApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class search extends Application{

	private TextField search;
	private Button search_button;
	private ImageView search_image;
	private ListView<String> resultsList;
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,600,420,Color.BLANCHEDALMOND);
		stage.setScene(S1);
		stage.setTitle("بحث بالاسم");
		
		search=new TextField();
		search.setLayoutX(120);
		search.setLayoutY(45);
		search.setPrefSize(350, 30);
		search.setAlignment(Pos.TOP_RIGHT);
		search.setFont(new Font("tahoma",20));
		search.setStyle("-fx-background-radius: 16px");
		search.setPromptText("ادخل الاسم");
		
		search.textProperty().addListener((observable, oldValue, newValue) -> {
            ManageDataBase.SearchList(newValue);
        });

        resultsList = new ListView<>();
        resultsList.setItems(ManageDataBase.results);
        resultsList.setLayoutX(10);
        resultsList.setLayoutY(200);
        resultsList.setPrefSize(580, 200);
        resultsList.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent E)->{       	
        	search.setText(resultsList.getSelectionModel().getSelectedItem());
        });
		
		
		search_image=new ImageView(new Image(getClass().getResourceAsStream("search.png")));
		
		search_button=new Button("بحث عن المعرف");
		search_button.setLayoutX(170);
		search_button.setLayoutY(100);
		search_button.setPrefSize(250, 30);
		search_button.setStyle("-fx-font-size: 20px;-fx-background-color: GRAY;-fx-background-radius: 16px");
		search_button.setGraphic(search_image);
		search_button.setContentDisplay(ContentDisplay.LEFT);
		search_button.addEventHandler(MouseEvent.MOUSE_ENTERED, (MouseEvent E)->{
			S1.setCursor(Cursor.HAND);			
		});
		search_button.addEventHandler(MouseEvent.MOUSE_EXITED, (MouseEvent E)->{
			S1.setCursor(Cursor.DEFAULT);			
		});
		
		search_button.setOnAction((ActionEvent E)->{
			search.setText(String.valueOf(ManageDataBase.getIdByName(search.getText())));
		});
		
		
		Root.getChildren().addAll(search,search_button,resultsList);
		stage.setResizable(false);
		stage.show();
		
	}
	

}
