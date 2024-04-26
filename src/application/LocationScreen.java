//Anas Al Sayed **1221020**
package application;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LocationScreen {
	DistrictLinkedList Dlist;
	BorderPane root ;
	VBox v1,v2;
	HBox h1,h2;

	Button InsertLoc,UpdateLoc,DeleteLoc,NavigateLoc, LocStatistics;
	Button InsertMart,UpdateMart,DeleteMart, SearchMart;


	//InsertLoc----->B1
	BorderPane B1root;
	Button InsertB1;
	VBox vB1;
	TextField LocNameB1;
	Label B1res;
	ComboBox <String> B1comboBox;


	//UpdateLoc----->B2
	BorderPane B2root;
	Button UpdateB2,getLocB2;
	VBox vB2;
	HBox h1B2;
	TextField LocNameB2;
	Label B2res;
	ComboBox <String> B2DisComboBox;
	ComboBox <String> B2LocComboBox;


	//DeleteLoc----->B3
	BorderPane B3root;
	Button DeleteB3,getLocB3;
	VBox vB3;
	HBox h1B3;
	Label B3res;
	ComboBox <String> B3DisComboBox;
	ComboBox <String> B3LocComboBox;
	//NavigateLoc----->B4

	BorderPane B4root;
	Button B4Next,B4getDis;
	VBox vB4;
	TextField B4LocNameTEXT;
	ComboBox <String> B4DisComboBox;
	LocationNode temp;
	TextArea B4texArea;

	//LocStatistics----->B5
	BorderPane B5root;
	VBox vB5,v1B5,v2B5;
	HBox hB5,h1B5;
	Button GetFirstLocB5,B5getLocStatistis;
	TextField B5MnumTEXT,B5MmaleNumTEXT,B5MfemaleNumTEXT,B5avgAgeTEXT,B5YoungestMTEXT,B5oldestMTEXT;
	Label B5Mnum,B5MmaleNum,B5MfemaleNum,B5avgAge,B5Youngest,B5oldest;
	DistrictNode B5temp;
	ComboBox <String> B5DisComboBox;
	ComboBox <String> B5LocComboBox;

	//InsertMart----->B6
	BorderPane B6root;
	VBox vB6;
	HBox hB6;
	Button GetFirstLocB6,B6AddM;
	TextField B6MnameTEXT,B6MdateTEXT,B6MageTEXT,B6genderTEXT;
	Label B6res;
	ComboBox <String> B6DisComboBox;
	ComboBox <String> B6LocComboBox;

	//updateMartyr----->B7
	BorderPane B7root;
	VBox vB7;
	HBox hB7,h1B7;
	Button GetFirstLocB7,B7updateMartyr,GetMartyrsB7;
	TextField B7MnameTEXT,B7MdateTEXT,B7MageTEXT,B7genderTEXT;
	Label B7res;
	ComboBox <String> B7DisComboBox;
	ComboBox <String> B7LocComboBox;
	ComboBox <String> B7MartComboBox;

	//DeleteMart----->B8
	BorderPane B8root;
	VBox vB8;
	HBox hB8,h1B8;
	Button GetFirstLocB8,B8DeleteMart,GetMartyrsB8;
	Label B8res;
	ComboBox <String> B8DisComboBox;
	ComboBox <String> B8LocComboBox;
	ComboBox <String> B8MartComboBox;


	//SearchMart----->B9
	BorderPane B9root;
	VBox vB9;
	HBox hB9;
	TextField B9MnameTEXT;
	Button B9SearchMart;
	Label B9res;
	TextArea B9textAtea;
	ComboBox <String> B9DisComboBox;



	public  LocationScreen( DistrictLinkedList Dlist) {
		try{
			root =new BorderPane ();
			root.setStyle("-fx-background: #2b2d31");
			v1 = new VBox();
			v2 = new VBox();
			h1 = new HBox();





			this.Dlist=Dlist;
			InsertLoc=new Button("𝐈𝐍𝐒𝐄𝐑𝐓 𝐋𝐎𝐂𝐀𝐓𝐈𝐎𝐍",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-add-30.png",30,30,false,false)));
			InsertLoc.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");
			UpdateLoc=new Button("𝐔𝐏𝐃𝐀𝐓𝐄 𝐋𝐎𝐂𝐀𝐓𝐈𝐎𝐍",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-update-31.png",30,30,false,false)));
			UpdateLoc.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");
			DeleteLoc=new Button("𝐃𝐄𝐋𝐄𝐓𝐄 𝐋𝐎𝐂𝐀𝐓𝐈𝐎𝐍",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-delete-30 (1).png",30,30,false,false)));
			DeleteLoc.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");
			NavigateLoc=new Button("𝐍𝐀𝐕𝐈𝐆𝐀𝐓𝐄 𝐋𝐎𝐂𝐀𝐓𝐈𝐎𝐍",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-arrow-30.png",30,30,false,false)));
			NavigateLoc.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");
			LocStatistics=new Button("𝐋𝐎𝐂𝐀𝐓𝐈𝐎𝐍 𝐒𝐓𝐀𝐓𝐈𝐒𝐓𝐈𝐂𝐒",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-positive-dynamic-30.png",30,30,false,false)));
			LocStatistics.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");
			InsertMart=new Button("𝐈𝐍𝐒𝐄𝐑𝐓 𝐌𝐀𝐑𝐓𝐘𝐑",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-insert-30.png",30,30,false,false)));
			InsertMart.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");
			UpdateMart=new Button("𝐔𝐏𝐃𝐀𝐓𝐄 𝐌𝐀𝐑𝐓𝐘𝐑",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-update-30 (1).png",30,30,false,false)));
			UpdateMart.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");
			DeleteMart=new Button("𝐃𝐄𝐋𝐄𝐓𝐄 𝐌𝐀𝐑𝐓𝐘𝐑",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-delete-30 (2).png",30,30,false,false)));
			DeleteMart.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");
			SearchMart=new Button("𝐒𝐄𝐀𝐑𝐂𝐇 𝐅𝐎𝐑 𝐌𝐀𝐑𝐓𝐘𝐑",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-search-30.png",30,30,false,false)));
			SearchMart.setStyle("-fx-border-color:red;"
					+ "-fx-border-width:1;"+"-fx-text-fill: red");


			InsertLoc.setOnAction(e->{


				InsertLocStage();

			});


			UpdateLoc.setOnAction(e->{

				UpdateLocStage();
			});	

			DeleteLoc.setOnAction(e->{

				DeleteLocStage();
			});	

			NavigateLoc.setOnAction(e->{

				NavigateLocStage();
			});

			LocStatistics.setOnAction(e->{

				LocStatisticsStage();
			});
			InsertMart.setOnAction(e->{

				InsertMartyrStage();

			});

			UpdateMart.setOnAction(e->{

				UpdateMartyrStage();

			});
			DeleteMart.setOnAction(e->{

				DeleteMartyrStage();

			});
			SearchMart.setOnAction(e->{

				SearchMartyrStage();

			});

			v1.getChildren().addAll(InsertLoc,UpdateLoc,DeleteLoc,NavigateLoc,LocStatistics);
			v1.setAlignment(Pos.CENTER);
			v1.setSpacing(30);
			v2.getChildren().addAll(InsertMart,UpdateMart,DeleteMart, SearchMart);
			v2.setAlignment(Pos.CENTER);
			v2.setSpacing(30);
			h1.getChildren().addAll(v1,v2);
			h1.setAlignment(Pos.CENTER);
			h1.setSpacing(30);

			root.setCenter(h1);


			Scene scene = new Scene(root,600,700);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}




	public  void InsertLocStage() {

		B1comboBox = new ComboBox();	
		B1comboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B1comboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");

		Stage res = new Stage();
		B1root = new BorderPane();
		B1root.setStyle("-fx-background: #2b2d31");

		LocNameB1 = new TextField();
		LocNameB1.setFocusTraversable(false);
		LocNameB1.setMaxWidth(150);
		LocNameB1.setPromptText("Location Name");

		InsertB1=new Button("𝙄𝙉𝙎𝙀𝙍𝙏");
		InsertB1.setStyle("-fx-text-fill: red");

		B1res =new Label() ;
		vB1 = new VBox();


		vB1.getChildren().addAll(B1comboBox,LocNameB1,InsertB1,B1res);
		vB1.setSpacing(5);
		vB1.setAlignment(Pos.CENTER);



		InsertB1.setOnAction(e->{
			try {
				
				if(!LocNameB1.getText().isBlank()) {
					if(Dlist.getDistrict(B1comboBox.getValue()).Llist.notHere(LocNameB1.getText())) {

						
				Dlist.getDistrict(B1comboBox.getValue()).Llist.addFirst(new Location(LocNameB1.getText()));
				B1res.setText("**The Location has been added Successfully**");
				B1res.setStyle("-fx-text-fill: green");
				Dlist.locationToString(B1comboBox.getValue());
					}else {
						B1res.setText("**Error,The Location is alredy exisit**");
						B1res.setStyle("-fx-text-fill: red");
					}
				}else {
					B1res.setText("**Please enter the Location name**");
					B1res.setStyle("-fx-text-fill: red");
				}
			
			
			}catch(NullPointerException b) {
				B1res.setText("**Please enter the Location name**");
				B1res.setStyle("-fx-text-fill: red");
			}


		});




		B1root.setCenter(vB1);
		Scene scene1 = new Scene(B1root,500,400);
		res.setScene(scene1);
		res.setTitle("Insert District Stage");
		res.show();;
	}




	public  void UpdateLocStage() {




		B2DisComboBox = new ComboBox();	
		B2DisComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B2DisComboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");

		B2LocComboBox = new ComboBox();	
		B2LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");



		Stage res = new Stage();
		B2root = new BorderPane();
		B2root.setStyle("-fx-background: #2b2d31");

		LocNameB2 = new TextField();
		LocNameB2.setMaxWidth(150);

		LocNameB2.setFocusTraversable(false);
		LocNameB2.setMaxWidth(150);
		LocNameB2.setPromptText("New Location Name");

		//خليها شفافة-_-
		UpdateB2=new Button("𝙐𝙋𝘿𝘼𝙏𝙀");
		UpdateB2.setStyle("-fx-text-fill: red");

		getLocB2 =new Button("𝙂𝙀𝙏 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
		getLocB2.setStyle("-fx-text-fill: red");


		B2res =new Label() ;
		vB2 = new VBox();
		h1B2= new HBox();



		h1B2.getChildren().addAll(B2LocComboBox,getLocB2);
		h1B2.setSpacing(5);
		h1B2.setAlignment(Pos.CENTER);


		vB2.getChildren().addAll(B2DisComboBox,h1B2,LocNameB2,UpdateB2,B2res);
		vB2.setSpacing(5);
		vB2.setAlignment(Pos.CENTER);

		


		getLocB2.setOnAction(e->{
			try {

				temp =Dlist.getDistrict(B2DisComboBox.getValue()).Llist.first;


				B2LocComboBox.setItems(FXCollections.observableArrayList(Dlist.getLocationList(B2DisComboBox.getValue()).split(",")));
				B2LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
			}catch(NullPointerException b) {
				B2res.setText("**Please enter the Location name**");
				B2res.setStyle("-fx-text-fill: red");
			}
		});

		UpdateB2.setOnAction(e->{
			try {
				if(B2DisComboBox.getValue()!=null) {
					
					B2LocComboBox.setItems(FXCollections.observableArrayList(Dlist.getLocationList(B2DisComboBox.getValue()).split(",")));
					getLocB2 =new Button("𝙂𝙀𝙏 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
					getLocB2.setStyle("-fx-text-fill: red");


				}
				if(B2LocComboBox.getValue()!=null) {
					
					if(!LocNameB2.getText().isBlank()) {
						if(Dlist.getDistrict(B1comboBox.getValue()).Llist.notHere(LocNameB1.getText())) {

					
					Dlist.getDistrict(B2DisComboBox.getValue()).Llist.uppdateLocation(B2LocComboBox.getValue(), LocNameB2.getText());
					B2res.setText("**The Location has been uppdated Successfully**");
					B2res.setStyle("-fx-text-fill: green");
					Dlist.locationToString(B2DisComboBox.getValue());
						}else {
							B2res.setText("**ERROR,The Location Name is alredy exisit**");
							B2res.setStyle("-fx-text-fill: red");
						}
					}else {
						B2res.setText("**Please enter the Location name**");
						B2res.setStyle("-fx-text-fill: red");
					}
					
				}else {
					B2res.setText("**Please enter the Location name**");
					B2res.setStyle("-fx-text-fill: red");
					
				}
			}catch(NullPointerException b) {
				B2res.setText("**Please enter the Location name**");
				B2res.setStyle("-fx-text-fill: red");
			}
		});


		B2root.setCenter(vB2);
		Scene scene1 = new Scene(B2root,500,400);
		res.setScene(scene1);
		res.setTitle("Update District Stage");
		res.show();;
	}






	public  void DeleteLocStage() {



		B3DisComboBox = new ComboBox();	
		B3DisComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B3DisComboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");

		B3LocComboBox = new ComboBox();	
		B3LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");


		Stage res = new Stage();
		B3root = new BorderPane();
		B3root.setStyle("-fx-background: #2b2d31");

		//خليها شفافة-_-
		DeleteB3=new Button("𝘿𝙀𝙇𝙀𝙏𝙀");
		DeleteB3.setStyle("-fx-text-fill: red");

		B3res =new Label() ;
		vB3 = new VBox();
		h1B3= new HBox();
		getLocB3 =new Button("𝙂𝙀𝙏 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
		getLocB3.setStyle("-fx-text-fill: red");



		h1B3.getChildren().addAll(B3LocComboBox,getLocB3);
		h1B3.setSpacing(5);
		h1B3.setAlignment(Pos.CENTER);


		vB3.getChildren().addAll(B3DisComboBox,h1B3,DeleteB3,B3res);
		vB3.setSpacing(5);
		vB3.setAlignment(Pos.CENTER);


		getLocB3.setOnAction(e->{
			try {
			B3LocComboBox.setItems(FXCollections.observableArrayList(Dlist.getLocationList(B3DisComboBox.getValue()).split(",")));
			B3LocComboBox.setValue("Locations");
			}catch(NullPointerException b) {
				B3res.setText("**Please select the Location name**");
				B3res.setStyle("-fx-text-fill: red");
			}
		});


		DeleteB3.setOnAction(e->{
			try {
				Dlist.locationToString(B3DisComboBox.getValue());


				Dlist.getDistrict(B3DisComboBox.getValue()).removeLocation( B3LocComboBox.getValue());
				B3LocComboBox.setItems(FXCollections.observableArrayList(Dlist.getLocationList(B3DisComboBox.getValue()).split(",")));
				B3LocComboBox.setValue("Locations");

				B3res.setText("**The District has been Deleted Successfully**");
				B3res.setStyle("-fx-text-fill: green");

				Dlist.locationToString(B3DisComboBox.getValue());

			}catch(NullPointerException b) {
				B3res.setText("**Please enter the Location name**");
				B3res.setStyle("-fx-text-fill: red");
			}
		});


		B3root.setCenter(vB3);
		Scene scene1 = new Scene(B3root,400,300);
		res.setScene(scene1);
		res.setTitle("Delete District Stage");
		res.show();;
	}


	public  void NavigateLocStage() {

		//NavigateLoc----->B4


		B4DisComboBox = new ComboBox();	
		B4DisComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B4DisComboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");

		Stage res = new Stage();
		B4root = new BorderPane();
		B4root.setStyle("-fx-background: #2b2d31");


		B4Next= new Button("𝑵𝑬𝑿𝑻");
		B4Next.setStyle("-fx-text-fill: red");



		B4LocNameTEXT = new TextField ();
		B4LocNameTEXT.setMaxWidth(150);
		B4LocNameTEXT.setFocusTraversable(false);

		B4getDis = new Button ("𝙂𝙀𝙏 𝙁𝙄𝙍𝙎𝙏 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉");
		B4getDis.setStyle("-fx-text-fill: red");



		vB4= new VBox();
		B4texArea= new TextArea();
		B4texArea.setMaxWidth(400);




		vB4.getChildren().addAll(B4DisComboBox,B4getDis,B4LocNameTEXT,B4Next,B4texArea);
		vB4.setSpacing(5);
		vB4.setAlignment(Pos.CENTER);

		try {

			//to get first Location in this discrit.
			B4getDis.setOnAction(e->{
				try {
					temp =Dlist.getDistrict(B4DisComboBox.getValue()).Llist.first;
				}catch(NullPointerException b) {

				}

			});

			B4Next.setOnAction(e->{

				try {

					B4LocNameTEXT.setText(String.valueOf((((Location)temp.getData()).getLname()))+" ") ;
					B4texArea.setText(Dlist.getDistrict(B4DisComboBox.getValue()).Llist.getMartyrList(((Location)temp.getData()).getLname()));
					temp=temp.getNext();
				}catch(NullPointerException b) {

				}


			});


		}catch(NullPointerException n) {

		}








		B4root.setCenter(vB4);
		Scene scene1 = new Scene(B4root,600,500);
		res.setScene(scene1);
		res.setTitle("Navigate District Stage");
		res.show();;
	}

	public  void LocStatisticsStage() {


		B5DisComboBox = new ComboBox();	
		B5DisComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B5DisComboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");
		//GetFirstLoc----->B5


		B5LocComboBox = new ComboBox();	
		B5LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");

		

		Stage res = new Stage();
		B5root = new BorderPane();
		B5root.setStyle("-fx-background: #2b2d31");

		GetFirstLocB5 = new Button("𝙂𝙀𝙏 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
		GetFirstLocB5.setStyle("-fx-text-fill: red");

		B5getLocStatistis = new Button("𝙂𝙀𝙏 𝙎𝙏𝘼𝙏𝙄𝙎𝙏𝙄𝙎");
		B5getLocStatistis.setStyle("-fx-text-fill: red");



		B5Mnum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐌𝐀𝐑𝐓𝐘𝐑𝐒:");
		B5Mnum.setStyle("-fx-text-fill: red");

		B5MmaleNum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐌𝐀𝐋𝐄:");
		B5MmaleNum.setStyle("-fx-text-fill: red");

		B5MfemaleNum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐅𝐄𝐌𝐀𝐋𝐄: ");
		B5MfemaleNum.setStyle("-fx-text-fill: red");

		B5avgAge = new Label("𝐀𝐕𝐄𝐑𝐀𝐆𝐄 𝐌𝐀𝐑𝐓𝐘𝐑𝐒 𝐀𝐆𝐄𝐒: ");
		B5avgAge.setStyle("-fx-text-fill: red");

		B5Youngest = new Label("𝐓𝐇𝐄 𝐘𝐎𝐔𝐍𝐆𝐄𝐒𝐓 𝐌𝐀𝐑𝐓𝐘𝐑𝐒: ");
		B5Youngest.setStyle("-fx-text-fill: red");

		B5oldest = new Label("𝐓𝐇𝐄 𝐎𝐋𝐃𝐄𝐒𝐓 𝐌𝐀𝐑𝐓𝐘𝐑𝐒: ");
		B5oldest.setStyle("-fx-text-fill: red");



		B5MnumTEXT = new TextField ();
		B5MmaleNumTEXT = new TextField ();
		B5MfemaleNumTEXT = new TextField ();
		B5avgAgeTEXT = new TextField ();
		B5YoungestMTEXT = new TextField ();
		B5oldestMTEXT = new TextField ();



		v1B5 = new VBox();
		v2B5 = new VBox();
		hB5= new HBox();
		h1B5=new HBox();
		vB5= new VBox();


		v1B5.getChildren().addAll(B5Mnum,B5MmaleNum,B5MfemaleNum,B5avgAge,B5Youngest,B5oldest);
		v1B5.setSpacing(10);
		v1B5.setAlignment(Pos.CENTER);

		v2B5.getChildren().addAll(B5MnumTEXT,B5MmaleNumTEXT,B5MfemaleNumTEXT,B5avgAgeTEXT,B5YoungestMTEXT,B5oldestMTEXT);
		v2B5.setSpacing(5);
		v2B5.setAlignment(Pos.CENTER);

		hB5.getChildren().addAll(v1B5,v2B5);
		hB5.setSpacing(20);
		hB5.setAlignment(Pos.CENTER);

		h1B5.getChildren().addAll(B5LocComboBox,GetFirstLocB5);
		h1B5.setSpacing(5);
		h1B5.setAlignment(Pos.CENTER);

		vB5.getChildren().addAll(B5DisComboBox,h1B5,B5getLocStatistis,hB5);
		vB5.setSpacing(5);
		vB5.setAlignment(Pos.CENTER);

		GetFirstLocB5.setOnAction(e->{
			try {
				B5LocComboBox.setItems(FXCollections.observableArrayList(Dlist.getLocationList(B5DisComboBox.getValue()).split(",")));
				B5LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
			}catch(NullPointerException b) {

			}

		});
		B5getLocStatistis.setOnAction(e->{
			try {


				B5MnumTEXT.setText(String.valueOf(Dlist.getDistrict( B5DisComboBox.getValue()).Llist.getMartyrCount(B5LocComboBox.getValue()))+" Martyrs") ;
				B5MmaleNumTEXT.setText(String.valueOf(Dlist.getDistrict( B5DisComboBox.getValue()).Llist.getMartyrMaleCount(B5LocComboBox.getValue()))+" Martyrs") ;
				B5MfemaleNumTEXT.setText(String.valueOf(Dlist.getDistrict( B5DisComboBox.getValue()).Llist.getMartyrFmaleCount(B5LocComboBox.getValue()))+" Martyrs") ;
				B5avgAgeTEXT.setText(String.valueOf(Dlist.getDistrict( B5DisComboBox.getValue()).Llist.getMartyrAverage(B5LocComboBox.getValue()))+" ") ;
				B5YoungestMTEXT.setText(String.valueOf(Dlist.getDistrict( B5DisComboBox.getValue()).Llist.martyrYoungest(B5LocComboBox.getValue()).getName())+" ") ;
				B5oldestMTEXT.setText(String.valueOf(Dlist.getDistrict( B5DisComboBox.getValue()).Llist.martyrOldest(B5LocComboBox.getValue()).getName())+" ") ;		
			}catch(NullPointerException b) {

				
			}

		});

		B5root.setCenter(vB5);
		Scene scene1 = new Scene(B5root,600,600);
		res.setScene(scene1);
		res.setTitle("Loction Statistics Stage");
		res.show();;
	}



	public  void InsertMartyrStage() {


		B6DisComboBox = new ComboBox();	
		B6DisComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B6DisComboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");
		//GetFirstLoc----->B5


		B6LocComboBox = new ComboBox();	
		B6LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");



		Stage res = new Stage();
		B6root = new BorderPane();
		B6root.setStyle("-fx-background: #2b2d31");

		GetFirstLocB6 = new Button("𝙂𝙀𝙏 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
		GetFirstLocB6.setStyle("-fx-text-fill: red");

		B6AddM = new Button("𝙄𝙉𝙎𝙀𝙍𝙏 𝙈𝘼𝙍𝙏𝙔𝙍𝙎");
		B6AddM.setStyle("-fx-text-fill: red");


		B6res=new Label();


		B6MnameTEXT = new TextField ();
		B6MnameTEXT.setPromptText("Martyr Name");
		B6MnameTEXT.setFocusTraversable(false);
		B6MnameTEXT.setMaxWidth(200);

		B6MdateTEXT = new TextField ();
		B6MdateTEXT.setPromptText("Martyr Date");
		B6MdateTEXT.setFocusTraversable(false);
		B6MdateTEXT.setMaxWidth(200);

		B6MageTEXT = new TextField ();
		B6MageTEXT.setPromptText("Martyr Age");
		B6MageTEXT.setFocusTraversable(false);
		B6MageTEXT.setMaxWidth(200);


		B6genderTEXT = new TextField ();
		B6genderTEXT.setPromptText("Martyr Gender");
		B6genderTEXT.setFocusTraversable(false);
		B6genderTEXT.setMaxWidth(200);





		hB6=new HBox();
		vB6= new VBox();





		hB6.getChildren().addAll(B6LocComboBox,GetFirstLocB6);
		hB6.setSpacing(5);
		hB6.setAlignment(Pos.CENTER);

		vB6.getChildren().addAll(B6MnameTEXT,B6MdateTEXT,B6MageTEXT,B6genderTEXT,B6DisComboBox,hB6,B6AddM,B6res);
		vB6.setSpacing(5);
		vB6.setAlignment(Pos.CENTER);

		GetFirstLocB6.setOnAction(e->{
			try {

				B6LocComboBox.setItems(FXCollections.observableArrayList(Dlist.getLocationList(B6DisComboBox.getValue()).split(",")));
				B6LocComboBox.setValue("Locations");
			}catch(NullPointerException b) {
				B6res.setText("**Please enter the Location name**");
				B6res.setStyle("-fx-text-fill: red");
			}

		});
		B6AddM.setOnAction(e->{
			try {

				Dlist.getDistrict(B6DisComboBox.getValue()).Llist.addMartyr(new Martyr(B6MnameTEXT.getText(),new Date(B6MdateTEXT.getText()),Integer.parseInt(B6MageTEXT.getText()),new Location(B6LocComboBox.getValue()),new District(B6DisComboBox.getValue()),B6genderTEXT.getText()));
				B6res.setText("**The Martyr has been aded sucssfuly**");
				B6res.setStyle("-fx-text-fill: green");
			}catch(NullPointerException s) {
				B6res.setText("**Please enter the Location name**");
				B6res.setStyle("-fx-text-fill: red");
			}
		catch(IllegalArgumentException ss) {
			B6res.setText("**Please enter a valid value**");
			B6res.setStyle("-fx-text-fill: red");
		}

		});

		B6root.setCenter(vB6);
		Scene scene1 = new Scene(B6root,500,500);
		res.setScene(scene1);
		res.setTitle("Insert Martyr Stage");
		res.show();
	}


	public  void DeleteMartyrStage() {

		//DeleteMartyr----->B8

		B8DisComboBox = new ComboBox();	
		B8DisComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B8DisComboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");


		B8MartComboBox = new ComboBox();	
		B8MartComboBox.setValue("𝙈𝘼𝙍𝙏𝙔𝙍𝙎");


		B8LocComboBox = new ComboBox();	
		B8LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");


		Stage res = new Stage();
		B8root = new BorderPane();
		B8root.setStyle("-fx-background: #2b2d31");

		GetFirstLocB8 = new Button("𝙂𝙀𝙏 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
		GetFirstLocB8.setStyle("-fx-text-fill: red");

		GetMartyrsB8 = new Button("𝙂𝙀𝙏 𝙈𝘼𝙍𝙏𝙔𝙍𝙎");
		GetMartyrsB8.setStyle("-fx-text-fill: red");

		B8DeleteMart = new Button("𝘿𝙀𝙇𝙀𝙏𝙀 𝙈𝘼𝙍𝙏𝙔𝙍𝙎");
		B8DeleteMart.setStyle("-fx-text-fill: red");



		B8res=new Label ("");



		hB8=new HBox();
		h1B8=new HBox();
		vB8= new VBox();


		h1B8.getChildren().addAll(B8LocComboBox,GetFirstLocB8);
		h1B8.setSpacing(5);
		h1B8.setAlignment(Pos.CENTER);


		hB8.getChildren().addAll(B8MartComboBox,GetMartyrsB8);
		hB8.setSpacing(5);
		hB8.setAlignment(Pos.CENTER);

		vB8.getChildren().addAll(B8DisComboBox,h1B8,hB8,B8DeleteMart,B8res);
		vB8.setSpacing(5);
		vB8.setAlignment(Pos.CENTER);

		GetFirstLocB8.setOnAction(e->{
try {
			B8LocComboBox.setItems(FXCollections.observableArrayList(Dlist.getLocationList(B8DisComboBox.getValue()).split(",")));
			B8LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");

}catch(NullPointerException s) {
	B8res.setText("**ERROR, Please select the District name**");
	B8res.setStyle("-fx-text-fill: red");
}



		});

		GetMartyrsB8.setOnAction(e->{
try {

			B8MartComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrict(B8DisComboBox.getValue()).Llist.getMartyerListB7(B8LocComboBox.getValue()).split(",")));
			B8MartComboBox.setValue("𝙈𝘼𝙍𝙏𝙔𝙍𝙎");
}catch(NullPointerException s) {
	B8res.setText("**ERROR, Please enter the Location name**");
	B8res.setStyle("-fx-text-fill: red");
}

		});

		B8DeleteMart.setOnAction(e->{

			try {			


				if(Dlist.getDistrict(B8DisComboBox.getValue()).Llist.removeMartyr(B8LocComboBox.getValue(), B8MartComboBox.getValue())==true) {
					B8res.setText("**The Martyer has been deleted Successfully**");
					B8res.setStyle("-fx-text-fill: green");	
				}else {
					B8res.setText("**ERROR Please Enter The Correct Value**");
					B8res.setStyle("-fx-text-fill: red");
				}



			}catch(NullPointerException s) {
				B8res.setText("**ERROR Please Enter The Correct Value**");
				B8res.setStyle("-fx-text-fill: red");	
			}


		});

		B8root.setCenter(vB8);
		Scene scene1 = new Scene(B8root,500,500);
		res.setScene(scene1);
		res.setTitle("Delete Martyr Stage");
		res.show();;
	}

	public  void UpdateMartyrStage() {


		B7DisComboBox = new ComboBox();	
		B7DisComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B7DisComboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");


		B7MartComboBox = new ComboBox();	
		B7MartComboBox.setValue("𝙈𝘼𝙍𝙏𝙔𝙍𝙎");
		//GetFirstLoc----->B5


		B7LocComboBox = new ComboBox();	
		B7LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");



		Stage res = new Stage();
		B7root = new BorderPane();
		B7root.setStyle("-fx-background: #2b2d31");

		GetFirstLocB7 = new Button("𝙂𝙀𝙏 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");
		GetFirstLocB7.setStyle("-fx-text-fill: red");

		GetMartyrsB7 = new Button("𝙂𝙀𝙏 𝙈𝘼𝙍𝙏𝙔𝙍𝙎");
		GetMartyrsB7.setStyle("-fx-text-fill: red");

		B7updateMartyr = new Button("𝙐𝙋𝘿𝘼𝙏𝙀 𝙈𝘼𝙍𝙏𝙔𝙍𝙎");
		B7updateMartyr.setStyle("-fx-text-fill: red");






		B7MnameTEXT = new TextField ();
		B7MnameTEXT.setPromptText("𝙈𝘼𝙍𝙏𝙔𝙍𝙎 Name");
		B7MnameTEXT.setFocusTraversable(false);
		B7MnameTEXT.setMaxWidth(200);

		B7MdateTEXT = new TextField ();
		B7MdateTEXT.setPromptText("𝙈𝘼𝙍𝙏𝙔𝙍𝙎 Date");
		B7MdateTEXT.setFocusTraversable(false);
		B7MdateTEXT.setMaxWidth(200);

		B7MageTEXT = new TextField ();
		B7MageTEXT.setPromptText("𝙈𝘼𝙍𝙏𝙔𝙍𝙎 Age");
		B7MageTEXT.setFocusTraversable(false);
		B7MageTEXT.setMaxWidth(200);


		B7genderTEXT = new TextField ();
		B7genderTEXT.setPromptText("𝙈𝘼𝙍𝙏𝙔𝙍𝙎 Gender");
		B7genderTEXT.setFocusTraversable(false);
		B7genderTEXT.setMaxWidth(200);

		B7res=new Label ("");



		hB7=new HBox();
		h1B7=new HBox();
		vB7= new VBox();


		h1B7.getChildren().addAll(B7LocComboBox,GetFirstLocB7);
		h1B7.setSpacing(5);
		h1B7.setAlignment(Pos.CENTER);


		hB7.getChildren().addAll(B7MartComboBox,GetMartyrsB7);
		hB7.setSpacing(5);
		hB7.setAlignment(Pos.CENTER);

		vB7.getChildren().addAll(B7DisComboBox,h1B7,hB7,B7MnameTEXT,B7MdateTEXT,B7MageTEXT,B7genderTEXT,B7updateMartyr,B7res);
		vB7.setSpacing(5);
		vB7.setAlignment(Pos.CENTER);

		GetFirstLocB7.setOnAction(e->{
try {
			B7LocComboBox.setItems(FXCollections.observableArrayList(Dlist.getLocationList(B7DisComboBox.getValue()).split(",")));
			B7LocComboBox.setValue("𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉𝙎");

}catch(NullPointerException s) {
	B7res.setText("**Please enter the District name**");
	B7res.setStyle("-fx-text-fill: red");
}


		});

		GetMartyrsB7.setOnAction(e->{
try {

			B7MartComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrict(B7DisComboBox.getValue()).Llist.getMartyerListB7(B7LocComboBox.getValue()).split(",")));
			B7MartComboBox.setValue("𝙈𝘼𝙍𝙏𝙔𝙍𝙎");
}catch(NullPointerException s) {
	B7res.setText("**Please enter the Location name**");
	B7res.setStyle("-fx-text-fill: red");
}

		});

		B7updateMartyr.setOnAction(e->{

			try {
				Martyr m=(Martyr)Dlist.getDistrict(B7DisComboBox.getValue()).Llist.getMartyr(B7LocComboBox.getValue(),B7MartComboBox.getValue()).getData();

				m.setName(B7MnameTEXT.getText());
				m.setAge(Integer.parseInt(B7MageTEXT.getText()));
				m.setDateOfDeath(new Date(B7MdateTEXT.getText()));
				m.setDistrict(new District(B7DisComboBox.getValue()));
				m.setGender(B7genderTEXT.getText());
				m.setLocation(new Location(B7LocComboBox.getValue()));
				B7res.setText("**The Martyer has been Updated Successfully**");
				B7res.setStyle("-fx-text-fill: green");
			}catch(NullPointerException s) {
				B7res.setText("**Please enter the Location name**");
				B7res.setStyle("-fx-text-fill: red");
			}
			catch(IllegalArgumentException ss) {
				B7res.setText("**ERROR ,Please enter a valid value**");
				B7res.setStyle("-fx-text-fill: red");
			}
			

		});

		B7root.setCenter(vB7);
		Scene scene1 = new Scene(B7root,500,500);
		res.setScene(scene1);
		res.setTitle("Update Martyr Stage");
		res.show();;
	}

	public  void SearchMartyrStage() {


		B9DisComboBox = new ComboBox();	
		B9DisComboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B9DisComboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");


		B9textAtea = new TextArea();
		B9textAtea.setMaxWidth(500);
		Stage res = new Stage();
		B9root = new BorderPane();
		B9root.setStyle("-fx-background: #2b2d31");

		B9SearchMart = new Button("𝐒𝐄𝐀𝐑𝐂𝐇");
		B9SearchMart.setStyle("-fx-text-fill: red");






		B9MnameTEXT = new TextField ();
		B9MnameTEXT.setPromptText("Martyr Name");
		B9MnameTEXT.setFocusTraversable(false);
		B9MnameTEXT.setMaxWidth(200);



		B9res=new Label ("");




		vB9= new VBox();






		vB9.getChildren().addAll(B9DisComboBox,B9MnameTEXT,B9res,B9textAtea,B9SearchMart);
		vB9.setSpacing(5);
		vB9.setAlignment(Pos.CENTER);



		B9SearchMart.setOnAction(e->{

			
			try {	
				if(B9res.getText().isBlank()) {
					B9res.setText("**Error, Please select a District**");
					B9res.setStyle("-fx-text-fill: red");	
				}
				B9textAtea.clear();			
				Dlist.getDistrict(B9DisComboBox.getValue()).Llist.searchMartyr(B9MnameTEXT.getText(),B9textAtea);
			
				B9res.setText(" ");
				B9res.setStyle("-fx-text-fill: green");	
			}catch(NullPointerException s) {
				B9res.setText("**The Martyer is not in this District**");
				B9res.setStyle("-fx-text-fill: red");
			}

		});

		B9root.setCenter(vB9);
		Scene scene1 = new Scene(B9root,600,500);
		res.setScene(scene1);
		res.setTitle("Search Martyr Stage");
		res.show();;
	}

	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}



}
