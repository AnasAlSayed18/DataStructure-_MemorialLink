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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DistrictScreen {
	DistrictLinkedList Dlist;
	BorderPane root ;

	Button InsertDis,UpdateDis,DeleteDis,NavigateDis,TotlaNumDate,GetFirstLoc;
	//InsertDis----->B1
	BorderPane B1root;
	Button InsertB1;
	VBox vB1;
	TextField DisNameB1;
	Label B1res;

	//UpdateDis----->B2
	BorderPane B2root;
	Button UpdateB2;
	VBox vB2;
	TextField DisNameB2;
	Label B2res;
	ComboBox <String> B2comboBox;

	//DeleteDis----->B3
	BorderPane B3root;
	Button DeleteB3;
	VBox vB3;
	TextField DisNameB3;
	Label B3res;
	ComboBox <String> B3comboBox;

	//NavigateDis----->B4
	BorderPane B4root;
	Button B4Next,B4Prev;
	VBox vB4,v1B4,v2B4;
	HBox hB4,h1B4;
	TextField B4MnumTEXT,B4MmaleNumTEXT,B4MfemaleNumTEXT,B4avgAgeTEXT,B4dateMaxTEXT;
	Label B4DisName,B4Mnum,B4MmaleNum,B4MfemaleNum,B4avgAge,B4dateMax;
	DistrictNode temp;

	//TotlaNumDate----->B5
	BorderPane B5root;
	VBox vB5;
	Label B5res;
	DatePicker datePickerB5 ;	

	//GetFirstLoc----->B6
	BorderPane B6root;
	VBox vB6;
	HBox hB6;
	Button GetFirstLocB6;

	TextField DisNameB6,B6MnumTEXT,B6MmaleNumTEXT,B6MfemaleNumTEXT,B6avgAgeTEXT,B6YoungestMTEXT,B6oldestMTEXT;
	Label B6res,B6Mnum,B6MmaleNum,B6MfemaleNum,B6avgAge,B6Youngest,B6oldest;
	ComboBox <String> B6comboBox;




	public  DistrictScreen( DistrictLinkedList Dlist) {
		try{
			root =new BorderPane ();
			root.setStyle("-fx-background: #2b2d31");
			VBox v1 = new VBox();
			this.Dlist=Dlist;
			InsertDis=new Button("𝐈𝐍𝐒𝐄𝐑𝐓 𝐃𝐒𝐓𝐑𝐈𝐂𝐓",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-add-64.png",30,30,false,false)));
			InsertDis.setStyle("-fx-border-color:orange;"
					+ "-fx-border-width:1;"+"-fx-text-fill: orange");
			InsertDis.setMaxWidth(220);
			InsertDis.setMaxHeight(30);

			UpdateDis=new Button("𝐔𝐏𝐃𝐀𝐓𝐄 𝐃𝐒𝐓𝐑𝐈𝐂𝐓",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-update-30.png",30,30,false,false)));
			UpdateDis.setStyle("-fx-border-color:orange;"
					+ "-fx-border-width:1;"+"-fx-text-fill: orange");
			UpdateDis.setMaxWidth(220);
			UpdateDis.setMaxHeight(30);

			DeleteDis=new Button("𝐃𝐄𝐋𝐄𝐓𝐄 𝐃𝐒𝐓𝐑𝐈𝐂𝐓",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-delete-30.png",30,30,false,false)));
			DeleteDis.setStyle("-fx-border-color:orange;"
					+ "-fx-border-width:1;"+"-fx-text-fill: orange");
			DeleteDis.setMaxWidth(220);
			DeleteDis.setMaxHeight(30);

			NavigateDis=new Button("𝐍𝐀𝐕𝐈𝐆𝐀𝐓𝐄 𝐃𝐒𝐓𝐑𝐈𝐂𝐓",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-Navigate-30.png",30,30,false,false)));
			NavigateDis.setStyle("-fx-border-color:orange;"
					+ "-fx-border-width:1;"+"-fx-text-fill: orange");
			NavigateDis.setMaxWidth(220);
			NavigateDis.setMaxHeight(30);

			TotlaNumDate=new Button("𝐓𝐎𝐓𝐋𝐀 𝐍𝐔𝐌𝐁𝐄𝐑 𝐁𝐘 𝐃𝐀𝐓𝐄",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-schedule-30.png",30,30,false,false)));
			TotlaNumDate.setStyle("-fx-border-color:orange;"
					+ "-fx-border-width:1;"+"-fx-text-fill: orange");
			TotlaNumDate.setMaxWidth(220);
			TotlaNumDate.setMaxHeight(30);

			GetFirstLoc=new Button("𝐋𝐎𝐀𝐃 𝐅𝐈𝐑𝐒𝐓 𝐋𝐎𝐂𝐀𝐓𝐈𝐎𝐍",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-first-30.png",30,30,false,false)));
			GetFirstLoc.setStyle("-fx-border-color:orange;"
					+ "-fx-border-width:1;"+"-fx-text-fill: orange");
			GetFirstLoc.setMaxWidth(220);
			GetFirstLoc.setMaxHeight(30);


			InsertDis.setOnAction(e->{


				InsertDisStage();

			});


			UpdateDis.setOnAction(e->{

				UpdateDisStage();
			});	

			DeleteDis.setOnAction(e->{

				DeleteDisStage();
			});	

			NavigateDis.setOnAction(e->{

				NavigateDisStage();
			});

			TotlaNumDate.setOnAction(e->{

				TotlaNumDateStage();
			});

			GetFirstLoc.setOnAction(e->{

				GetFirstLocDisStage();
			});

			v1.getChildren().addAll(InsertDis,UpdateDis,DeleteDis,NavigateDis,TotlaNumDate,GetFirstLoc);
			v1.setAlignment(Pos.CENTER);
			v1.setSpacing(30);



			root.setCenter(v1);


			Scene scene = new Scene(root,600,700);

		} catch(Exception e) {
			e.printStackTrace();
		}
	}




	public  void InsertDisStage() {
		Stage res = new Stage();
		B1root = new BorderPane();
		B1root.setStyle("-fx-background: #2b2d31");

		DisNameB1 = new TextField();
		DisNameB1.setFocusTraversable(false);
		DisNameB1.setMaxWidth(150);
		DisNameB1.setPromptText("District Name");
		//خليها شفافة-_-
		InsertB1=new Button("𝙄𝙉𝙎𝙀𝙍𝙏");
		InsertB1.setStyle("-fx-text-fill: orange");

		B1res =new Label() ;
		vB1 = new VBox();


		vB1.getChildren().addAll(DisNameB1,InsertB1,B1res);
		vB1.setSpacing(5);
		vB1.setAlignment(Pos.CENTER);



		InsertB1.setOnAction(e->{


			if(!DisNameB1.getText().isBlank()) {
				if(Dlist.notHere(DisNameB2.getText())) {

				Dlist.addFirst(new District(DisNameB1.getText()));
				B1res.setText("**The District has been added Successfully**");
				B1res.setStyle("-fx-text-fill: green");
				}else {
					B1res.setText("**ERROR,The District Name is alredy exisit**");
					B1res.setStyle("-fx-text-fill: red");
				}
			}else {
				B1res.setText("**ERROR,Please enter The District Name**");
				B1res.setStyle("-fx-text-fill: red");
			}
		});




		B1root.setCenter(vB1);
		Scene scene1 = new Scene(B1root,500,500);
		res.setScene(scene1);
		res.setTitle("Insert District Stage");
		res.show();;
	}




	public  void UpdateDisStage() {

		B2comboBox = new ComboBox();	
		B2comboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B2comboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");
		B2comboBox.setStyle("-fx-text-fill: orange");

		Stage res = new Stage();
		B2root = new BorderPane();
		B2root.setStyle("-fx-background: #2b2d31");



		DisNameB2 = new TextField ();
		DisNameB2.setPromptText("𝑫𝑰𝑺𝑻𝑹𝑰𝑪𝑻 𝑵𝑨𝑴𝑬");
		DisNameB2.setFocusTraversable(false);
		DisNameB2.setMaxWidth(150);

		//خليها شفافة-_-
		UpdateB2=new Button("𝙐𝙋𝘿𝘼𝙏𝙀");
		UpdateB2.setStyle("-fx-text-fill: orange");

		B2res =new Label() ;
		vB2 = new VBox();


		vB2.getChildren().addAll(B2comboBox,DisNameB2,UpdateB2,B2res);
		vB2.setSpacing(5);
		vB2.setAlignment(Pos.CENTER);



		UpdateB2.setOnAction(e->{

			try {
				if(!DisNameB2.getText().isBlank()) {
					if(Dlist.notHere(DisNameB2.getText())) {

					Dlist.uppdateDistrict(B2comboBox.getValue(), DisNameB2.getText());
					B2res.setText("**The District has been uppdated Successfully**");
					B2res.setStyle("-fx-text-fill: green");
					Dlist.printList1();
					}else {
						B2res.setText("**ERROR,The District Name is alredy exisit**");
						B2res.setStyle("-fx-text-fill: red");
					}
				}else{
					B2res.setText("**ERROR,Please enter The District Name**");
					B2res.setStyle("-fx-text-fill: red");
				}

			}
			catch(NullPointerException b) {

				B2res.setText("**ERROR,Please enter The District Name**");
				B2res.setStyle("-fx-text-fill: red");
			}
		});


		B2root.setCenter(vB2);
		Scene scene1 = new Scene(B2root,500,400);
		res.setScene(scene1);
		res.setTitle("Update District Stage");
		res.show();;
	}






	public  void DeleteDisStage() {

		B3comboBox = new ComboBox();	
		B3comboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B3comboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");
		B3comboBox.setStyle("-fx-text-fill: orange");



		Stage res = new Stage();
		B3root = new BorderPane();
		B3root.setStyle("-fx-background: #2b2d31");

		//خليها شفافة-_-
		DeleteB3=new Button("𝘿𝙀𝙇𝙀𝙏𝙀");
		DeleteB3.setStyle("-fx-text-fill: orange");


		B3res =new Label() ;
		vB3 = new VBox();


		vB3.getChildren().addAll(B3comboBox,DeleteB3,B3res);
		vB3.setSpacing(5);
		vB3.setAlignment(Pos.CENTER);



		DeleteB3.setOnAction(e->{

			try {




				Dlist.removeDistrict(B3comboBox.getValue());
				B3comboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
				B3comboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");
				B3comboBox.setStyle("-fx-text-fill: orange");
				B3res.setText("**The District has been Deleted Successfully**");
				B3res.setStyle("-fx-text-fill: green");

				Dlist.printList1();
			}catch(NullPointerException b) {
				B3res.setText("**ERROR,Please select The District Name**");
				B3res.setStyle("-fx-text-fill: red");
			}


		});


		B3root.setCenter(vB3);
		Scene scene1 = new Scene(B3root,500,400);
		res.setScene(scene1);
		res.setTitle("Delete District Stage");
		res.show();;
	}


	public  void NavigateDisStage() {

		//NavigateDis----->B4

		Stage res = new Stage();
		B4root = new BorderPane();
		B4root.setStyle("-fx-background: #2b2d31");

		B4Next=new Button(null,new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-next-30.png",30,30,false,false)));
		B4Next.setStyle("-fx-border-color:orange;"
				+ "-fx-border-width:1;"+"-fx-text-fill: orange");
		B4Prev=new Button(null,new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-previous-30.png",30,30,false,false)));
		B4Prev.setStyle("-fx-border-color:orange;"
				+ "-fx-border-width:1;"+"-fx-text-fill: orange");



		B4DisName = new Label("");
		B4Mnum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐌𝐀𝐑𝐓𝐘𝐑𝐒:                ");
		B4Mnum.setStyle("-fx-text-fill: orange");
		B4MmaleNum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐌𝐀𝐋𝐄:                ");
		B4MmaleNum.setStyle("-fx-text-fill: orange");
		B4MfemaleNum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐅𝐄𝐌𝐀𝐋𝐄:             ");
		B4MfemaleNum.setStyle("-fx-text-fill: orange");
		B4avgAge = new Label("𝐀𝐕𝐄𝐑𝐀𝐆𝐄 𝐌𝐀𝐑𝐓𝐘𝐑𝐒 𝐀𝐆𝐄𝐒:                    ");
		B4avgAge.setStyle("-fx-text-fill: orange");
		B4dateMax = new Label("𝐃𝐀𝐓𝐄 𝐇𝐀𝐒 𝐌𝐀𝐗𝐈𝐌𝐔𝐌 𝐌𝐀𝐑𝐓𝐘𝐑𝐒 𝐍𝐔𝐌𝐁𝐄𝐑:");
		B4dateMax.setStyle("-fx-text-fill: orange");




		B4MnumTEXT = new TextField ();
		B4MnumTEXT.setFocusTraversable(false);

		B4MmaleNumTEXT = new TextField ();
		B4MmaleNumTEXT.setFocusTraversable(false);

		B4MfemaleNumTEXT = new TextField ();
		B4MfemaleNumTEXT.setFocusTraversable(false);

		B4avgAgeTEXT = new TextField ();
		B4avgAgeTEXT.setFocusTraversable(false);

		B4dateMaxTEXT = new TextField ();
		B4dateMaxTEXT.setFocusTraversable(false);
		B4dateMaxTEXT.maxWidth(300);



		v1B4 = new VBox();
		v2B4 = new VBox();
		hB4 = new HBox();
		h1B4=new HBox();
		vB4= new VBox();


		v1B4.getChildren().addAll(B4Mnum,B4MmaleNum,B4MfemaleNum,B4avgAge,B4dateMax);
		v1B4.setSpacing(10);
		v1B4.setAlignment(Pos.CENTER);

		v2B4.getChildren().addAll(B4MnumTEXT,B4MmaleNumTEXT,B4MfemaleNumTEXT,B4avgAgeTEXT,B4dateMaxTEXT);
		v2B4.setSpacing(5);
		v2B4.setAlignment(Pos.CENTER);

		hB4.getChildren().addAll(v1B4,v2B4);
		hB4.setSpacing(20);
		hB4.setAlignment(Pos.CENTER);

		h1B4.getChildren().addAll(B4Prev,B4Next);
		h1B4.setSpacing(5);
		h1B4.setAlignment(Pos.CENTER);

		vB4.getChildren().addAll(B4DisName,hB4,h1B4);
		vB4.setSpacing(5);
		vB4.setAlignment(Pos.CENTER);
		temp =Dlist.getFirst();
		B4Prev.setDisable(true);
		try {	
			B4Prev.setDisable(false);

			B4DisName.setText(((District)temp.getData()).getDname()) ;
			B4DisName.setStyle("-fx-text-fill: orange");


			B4MnumTEXT.setText(String.valueOf(Dlist.getTotalMartyrCount(((District)temp.getData()).getDname()))+" Martyrs") ;
			B4MmaleNumTEXT.setText(String.valueOf(Dlist.getTotalMale(((District)temp.getData()).getDname()))+" Martyrs") ;
			B4MfemaleNumTEXT.setText(String.valueOf(Dlist.getTotalFmale(((District)temp.getData()).getDname()))+" Martyrs") ;
			B4avgAgeTEXT.setText(String.valueOf(Dlist.totalAgeAverage(((District)temp.getData()).getDname()))) ;
			B4dateMaxTEXT.setText(String.valueOf(Dlist.TotalDateCount(((District)temp.getData()).getDname()).toLocaleString())) ;

		}catch(NullPointerException n) {
			if(temp!=null) {
				temp=temp.getNext();
			}
			B4MnumTEXT.setText("0 Martyrs") ;
			B4MmaleNumTEXT.setText("0 Martyrs") ;
			B4MfemaleNumTEXT.setText("0 Martyrs") ;
			B4avgAgeTEXT.setText("0.0") ;
			B4dateMaxTEXT.setText(" ") ;
		}catch(ArithmeticException n) {

		}
		B4Next.setOnAction(e->{

			try {	
				B4Prev.setDisable(false);

				if(temp!=null) {
					temp=temp.getNext();
				}else {
					B4Prev.setDisable(true);
					B4Next.setDisable(true);

				}
				B4DisName.setText(((District)temp.getData()).getDname()) ;

				B4MnumTEXT.setText(String.valueOf(Dlist.getTotalMartyrCount(((District)temp.getData()).getDname()))+" Martyrs") ;
				B4MmaleNumTEXT.setText(String.valueOf(Dlist.getTotalMale(((District)temp.getData()).getDname()))+" Martyrs") ;
				B4MfemaleNumTEXT.setText(String.valueOf(Dlist.getTotalFmale(((District)temp.getData()).getDname()))+" Martyrs") ;
				B4avgAgeTEXT.setText(String.valueOf(Dlist.totalAgeAverage(((District)temp.getData()).getDname()))) ;

				B4dateMaxTEXT.setText(String.valueOf(Dlist.TotalDateCount(((District)temp.getData()).getDname()).toLocaleString())) ;

			}catch(NullPointerException n) {
				if(temp!=null) {
					temp=temp.getNext();
				}else {
					B4Prev.setDisable(true);
					B4Next.setDisable(true);
				}
				B4MnumTEXT.setText("0 Martyrs") ;
				B4MmaleNumTEXT.setText("0 Martyrs") ;
				B4MfemaleNumTEXT.setText("0 Martyrs") ;
				B4avgAgeTEXT.setText("0.0") ;
				B4dateMaxTEXT.setText(" ") ;
			}catch(ArithmeticException n) {

			}





		});
		B4Prev.setOnAction(e->{


			try {	
				if(temp!=null) {
					temp=temp.getPrev();
				}else {
					B4Prev.setDisable(true);
					B4Next.setDisable(true);
				}
				B4DisName.setText(((District)temp.getData()).getDname()) ;

				B4MnumTEXT.setText(String.valueOf(Dlist.getTotalMartyrCount(((District)temp.getData()).getDname()))+" Martyrs") ;
				B4MmaleNumTEXT.setText(String.valueOf(Dlist.getTotalMale(((District)temp.getData()).getDname()))+" Martyrs") ;
				B4MfemaleNumTEXT.setText(String.valueOf(Dlist.getTotalFmale(((District)temp.getData()).getDname()))+" Martyrs") ;
				B4avgAgeTEXT.setText(String.valueOf(Dlist.totalAgeAverage(((District)temp.getData()).getDname()))) ;
				B4dateMaxTEXT.setText(String.valueOf(Dlist.TotalDateCount(((District)temp.getData()).getDname()).toLocaleString())) ;

			}catch(NullPointerException n) {
				if(temp!=null) {
					temp=temp.getPrev();
				}else {
					B4Prev.setDisable(true);
					B4Next.setDisable(true);
				}
				B4MnumTEXT.setText("0 Martyrs") ;
				B4MmaleNumTEXT.setText("0 Martyrs") ;
				B4MfemaleNumTEXT.setText("0 Martyrs") ;
				B4avgAgeTEXT.setText("0.0") ;
				B4dateMaxTEXT.setText(" ") ;

			}catch(ArithmeticException n) {

			}






		});








		B4root.setCenter(vB4);
		Scene scene1 = new Scene(B4root,600,500);
		res.setScene(scene1);
		res.setTitle("Navigate District Stage");
		res.show();;
	}

	public  void TotlaNumDateStage() {


		datePickerB5= new DatePicker();


		Stage res = new Stage();
		B5root = new BorderPane();
		B5root.setStyle("-fx-background: #2b2d31");

		B5res =new Label() ;
		vB5 = new VBox();


		vB5.getChildren().addAll(datePickerB5,B5res);
		vB5.setSpacing(5);
		vB5.setAlignment(Pos.CENTER);



		datePickerB5.setOnAction(e->{

			try {
				if(datePickerB5.getValue()!=null) {
					B5res.setText("𝐓𝐇𝐄 𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐌𝐀𝐑𝐓𝐘𝐑𝐒 𝐅𝐎𝐑 𝐀 𝐆𝐈𝐕𝐄𝐍 𝐃𝐀𝐓𝐄: \n"+"			              	"
							+ "**"+String.valueOf(Dlist.TotalMartyrNumberInDate(datePickerB5.getValue()))+"**");
					B5res.setStyle("-fx-text-fill: green");
				}
				else {
					B5res.setText("**Please enter a date**");
					B5res.setStyle("-fx-text-fill: red");
				}
			}catch(NullPointerException s) {
				B5res.setText("**The Date is not exist**");
				B5res.setStyle("-fx-text-fill: red");
			}

		});


		B5root.setCenter(vB5);
		Scene scene1 = new Scene(B5root,400,200);
		res.setScene(scene1);
		res.setTitle("Totla Number of Matryr in Date Stage");
		res.show();;
	}


	public  void GetFirstLocDisStage() {


		B6comboBox = new ComboBox();	
		B6comboBox.setItems(FXCollections.observableArrayList(Dlist.getDistrictList().split(",")));
		B6comboBox.setValue("𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏𝙎");
		//GetFirstLoc----->B6



		Stage res = new Stage();
		B6root = new BorderPane();
		B6root.setStyle("-fx-background: #2b2d31");

		B6res = new Label("𝐅𝐈𝐑𝐒𝐓 𝐋𝐎𝐂𝐀𝐓𝐈𝐎𝐍: ");


		DisNameB6 = new TextField();
		DisNameB6.setFocusTraversable(false);
		DisNameB6.setMaxWidth(150);
		DisNameB6.setPromptText("First Location");

		B6Mnum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐌𝐀𝐑𝐓𝐘𝐑𝐒:");
		B6Mnum.setStyle("-fx-text-fill: orange");

		B6MmaleNum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐌𝐀𝐋𝐄:");
		B6MmaleNum.setStyle("-fx-text-fill: orange");

		B6MfemaleNum = new Label("𝐓𝐎𝐓𝐀𝐋 𝐍𝐔𝐌𝐁𝐄𝐑 𝐎𝐅 𝐅𝐄𝐌𝐀𝐋𝐄: ");
		B6MfemaleNum.setStyle("-fx-text-fill: orange");

		B6avgAge = new Label("𝐀𝐕𝐄𝐑𝐀𝐆𝐄 𝐌𝐀𝐑𝐓𝐘𝐑𝐒 𝐀𝐆𝐄𝐒: ");
		B6avgAge.setStyle("-fx-text-fill: orange");

		B6Youngest = new Label("𝐓𝐇𝐄 𝐘𝐎𝐔𝐍𝐆𝐄𝐒𝐓 𝐌𝐀𝐑𝐓𝐘𝐑𝐒: ");
		B6Youngest.setStyle("-fx-text-fill: orange");

		B6oldest = new Label("𝐓𝐇𝐄 𝐎𝐋𝐃𝐄𝐒𝐓 𝐌𝐀𝐑𝐓𝐘𝐑𝐒: ");
		B6oldest.setStyle("-fx-text-fill: orange");




		B6MnumTEXT = new TextField ();
		B6MnumTEXT.setMaxWidth(400);
		B6MmaleNumTEXT = new TextField ();
		B6MmaleNumTEXT.setMaxWidth(400);

		B6MfemaleNumTEXT = new TextField ();
		B6MfemaleNumTEXT.setMaxWidth(400);

		B6avgAgeTEXT = new TextField ();
		B6avgAgeTEXT.setMaxWidth(400);

		B6YoungestMTEXT = new TextField ();
		B6YoungestMTEXT.setMaxWidth(400);

		B6oldestMTEXT = new TextField ();
		B6oldestMTEXT.setMaxWidth(400);


		//خليها شفافة-_-
		GetFirstLocB6=new Button("𝐋𝐎𝐀𝐃 𝐅𝐈𝐑𝐒𝐓 𝐋𝐎𝐂𝐀𝐓𝐈𝐎𝐍");
		B6res =new Label() ;
		vB6 = new VBox();
		hB6 = new HBox();
		VBox v1B6= new VBox();
		VBox v2B6= new VBox();

		HBox h1B6 = new HBox();

		v1B6.getChildren().addAll(B6Mnum,B6MmaleNum,B6MfemaleNum,B6avgAge,B6Youngest,B6oldest);
		v1B6.setSpacing(10);
		v1B6.setAlignment(Pos.CENTER);

		v2B6.getChildren().addAll(B6MnumTEXT,B6MmaleNumTEXT,B6MfemaleNumTEXT,B6avgAgeTEXT,B6YoungestMTEXT,B6oldestMTEXT);
		v2B6.setSpacing(5);
		v2B6.setAlignment(Pos.CENTER);

		hB6.getChildren().addAll(DisNameB6);
		hB6.setSpacing(15);
		hB6.setAlignment(Pos.CENTER);

		h1B6.getChildren().addAll(v1B6,v2B6);
		h1B6.setSpacing(15);
		h1B6.setAlignment(Pos.CENTER);

		vB6.getChildren().addAll(B6comboBox,hB6,GetFirstLocB6,h1B6);
		vB6.setSpacing(5);
		vB6.setAlignment(Pos.CENTER);



		GetFirstLocB6.setOnAction(e->{

			try {
				B6res.setText(" ");


				DisNameB6.setText(Dlist.getFirstlocationToString(B6comboBox.getValue()));


				B6MnumTEXT.setText(String.valueOf(Dlist.getDistrict( B6comboBox.getValue()).Llist.getMartyrCount(Dlist.getFirstlocationToString(B6comboBox.getValue())))+" Martyrs") ;
				B6MmaleNumTEXT.setText(String.valueOf(Dlist.getDistrict( B6comboBox.getValue()).Llist.getMartyrMaleCount(Dlist.getFirstlocationToString(B6comboBox.getValue())))+" Martyrs") ;
				B6MfemaleNumTEXT.setText(String.valueOf(Dlist.getDistrict( B6comboBox.getValue()).Llist.getMartyrFmaleCount(Dlist.getFirstlocationToString(B6comboBox.getValue())))+" Martyrs") ;
				B6avgAgeTEXT.setText(String.valueOf(Dlist.getDistrict( B6comboBox.getValue()).Llist.getMartyrAverage(Dlist.getFirstlocationToString(B6comboBox.getValue())))+" ") ;
				B6YoungestMTEXT.setText(String.valueOf(Dlist.getDistrict( B6comboBox.getValue()).Llist.martyrYoungest(Dlist.getFirstlocationToString(B6comboBox.getValue())).getName())+" ") ;
				B6oldestMTEXT.setText(String.valueOf(Dlist.getDistrict( B6comboBox.getValue()).Llist.martyrOldest(Dlist.getFirstlocationToString(B6comboBox.getValue())).getName())+" ") ;		


			}catch(NullPointerException b) {
				B6res.setText("**ERROR, PLEASE ENTER A VALID NAME**");
				B6res.setStyle("-fx-text-fill: red");


			}
		});


		B6root.setCenter(vB6);
		Scene scene1 = new Scene(B6root,700,500);
		res.setScene(scene1);
		res.setTitle("Insert District Stage");
		res.show();;
	}
	public BorderPane getRoot() {
		return root;
	}

	public void setRoot(BorderPane root) {
		this.root = root;
	}



}
