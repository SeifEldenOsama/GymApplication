package GymApp;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CheckAll extends Application{

	private TableView <SubInfo> Table;
	private TableColumn<SubInfo,Integer> IdCol=new TableColumn<>("المعرف");
	private TableColumn<SubInfo,String> NameCol=new TableColumn<>("الاسم");
	private TableColumn<SubInfo,Integer> AgeCol=new TableColumn<>("السن");
	private TableColumn<SubInfo,String> JobCol=new TableColumn<>("الوظيفه");
	private TableColumn<SubInfo,String> SocialCaseCol=new TableColumn<>("الحاله الاجتماعيه");
	private TableColumn<SubInfo,Integer> TimesCol=new TableColumn<>("الحصص الباقيه");
	private TableColumn<SubInfo,Integer> PriceCol=new TableColumn<>("مدفوع");
	@Override
	public void start(Stage stage) throws Exception {
		Group Root=new Group();
		Scene S1=new Scene(Root,640,600);
		stage.setScene(S1);
		stage.setTitle("جميع المشتركين");
		
		ArrayList<SubInfo> List=ManageDataBase.GetAll();
		Table=new TableView<>();
		ObservableList<SubInfo> data=FXCollections.observableArrayList();
		for(int i=0;i<List.size();i++)
		{
			data.add(new SubInfo(List.get(i).getId(),List.get(i).getName(),List.get(i).getAge(),List.get(i).getJob(),List.get(i).getSocialCase(),List.get(i).getTimes(),List.get(i).getPrice()));
		}
		IdCol.setCellValueFactory(new PropertyValueFactory<>("Id"));
		NameCol.setCellValueFactory(new PropertyValueFactory<>("Name"));
		AgeCol.setCellValueFactory(new PropertyValueFactory<>("Age"));
		JobCol.setCellValueFactory(new PropertyValueFactory<>("Job"));
		SocialCaseCol.setCellValueFactory(new PropertyValueFactory<>("SocialCase"));
		TimesCol.setCellValueFactory(new PropertyValueFactory<>("Times"));
		PriceCol.setCellValueFactory(new PropertyValueFactory<>("Price"));
		
		
		SocialCaseCol.setPrefWidth(110);
		PriceCol.setPrefWidth(120);
		TimesCol.setPrefWidth(100);
		Table.getColumns().addAll(IdCol,NameCol,AgeCol,JobCol,SocialCaseCol,TimesCol,PriceCol);
		Table.setItems(data);
		Table.setLayoutX(0);
		Table.setLayoutY(0);
		Table.setPrefSize(640, 600);
		Table.setRowFactory(tv -> new TableRow<SubInfo>() {
		    protected void updateItem(SubInfo item, boolean empty) {
		        super.updateItem(item, empty);
		        if (empty || item == null) {
		            setStyle("-fx-background-color: transparent;");
		        } else {
		            // تغيير لون الخلفية بشكل متبادل
		            if (getIndex() % 2 == 0) {
		                setStyle("-fx-background-color: ORANGE;"); // لون الخلفية للصفوف الزوجية
		            } else {
		                setStyle("-fx-background-color: GRAY;"); // لون الخلفية للصفوف الفردية
		            }
		        }
		    }
		});
		
		
		
		Root.getChildren().addAll(Table);
		stage.setResizable(false);
		stage.show();
		
	}

}
