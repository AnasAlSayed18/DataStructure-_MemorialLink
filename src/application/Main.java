//Anas Al Sayed **1221020**
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Main extends Application {

	FileChooser fileC;
	File file;
	Label fileName;
	VBox vbox;
	Button ChooseFile;
	public  static DistrictLinkedList Dlist= new DistrictLinkedList();

	// CSS styles
	String s1="-fx-text-fill: #730039";
	String s2="-fx-text-fill: BLUE";
	String s3="-fx-text-fill: orange";
	String s4="-fx-text-fill: GREEN";
	String s5="-fx-text-fill: NAVAJOWHITE";

	DistrictScreen Ds = new DistrictScreen( Dlist);
	LocationScreen Ls = new LocationScreen(Dlist);

	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			root.setStyle("-fx-background: #2b2d31");


			ChooseFile=new Button("𝐂𝐇𝐎𝐎𝐒𝐄 𝐅𝐈𝐋𝐄",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-add-file-64.png",40,40,false,false)));
			ChooseFile.setStyle(s3);
			ChooseFile.setOnAction(e-> {
				fileC=new FileChooser();
				file=fileC.showOpenDialog(primaryStage);
				try {


					TabPane tab = new TabPane();
					Label lb1 = new Label("𝗣𝗥𝗢𝗝𝗘𝗖𝗧 𝗣𝗛𝗔𝗦𝗘 𝟭   𝗔𝗡𝗔𝗦 𝗔𝗟 𝗦𝗔𝗬𝗘𝗗 𝟭𝟮𝟮𝟭𝟬𝟮𝟬");

					Tab t1 = new Tab("𝘼𝘿𝘿 𝘿𝙄𝙎𝙏𝙍𝙄𝘾𝙏");
					t1.setStyle("-fx-background: orange");
					t1.setClosable(false);
					Tab t2= new Tab("𝘼𝘿𝘿 𝙇𝙊𝘾𝘼𝙏𝙄𝙊𝙉");
					t2.setStyle("-fx-background: red");
					t2.setClosable(false);

					Tab t3= new Tab("𝙎𝘼𝙑𝙀 𝙁𝙄𝙇𝙀");
					t3.setStyle("-fx-background: GREEN");
					t3.setClosable(false);


					t1.setContent(Ds.getRoot());

					t2.setContent(Ls.getRoot());

					t3.setContent(savePane(primaryStage));

              	tab.tabMinWidthProperty().bind(root.widthProperty().divide(11));


					root.setAlignment(lb1, Pos.TOP_CENTER);
					tab.getTabs().addAll(t1,t2,t3);





					fileName=new Label(file.getName());
					fileName.setStyle(s5);



					root.setAlignment(fileName,Pos.CENTER);
					root.setTop(lb1);
					root.setCenter(tab);




				}catch(Exception ec) {

				}

				try {
					readFile(file);
				} catch (Exception ex) {
					System.out.println("ERROR PLEASE ENTER A FILE...'");

				}


			});



			root.setCenter(ChooseFile);




			Scene scene = new Scene(root,1400,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Project_phase1");

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}




//1+1+1+1+n+(n*(4n))+4n+2n^2 -------< O(n^2).
	public  void readFile(File file) throws FileNotFoundException {
		Scanner in=new Scanner(file);

		in.nextLine();

		while(in.hasNextLine()) {
			String line=in.nextLine();
			String []token=line.split(",");

			if(token[2].equals("")) {
				token[2]="0";
			}

			DistrictNode dtemp=Dlist.getDistrict(token[4]);
			if(dtemp!=null) {
				LocationNode loc2=dtemp.Llist.getLocation(token[3]);
				if(loc2!=null) {
					dtemp.Llist.addMartyr(new Martyr(token[0],new Date(token[1]),Integer.parseInt(token[2]),new Location(token[3]),new District (token[4]),token[5]));
				}
				else {

					dtemp.Llist.addFirst(new Location(token[3]));

					Dlist.addLocation(token[4], dtemp.Llist);
		
					dtemp.Llist.addMartyr(new Martyr(token[0],new Date(token[1]),Integer.parseInt(token[2]),new Location(token[3]),new District (token[4]),token[5]));
				}
			}
			else {
				//n^2+n+n^2+n+n+ =4n+2n^2.
				Dlist.addFirst(new District (token[4]));
				DistrictNode d=Dlist.getDistrict(token[4]);
				d.Llist.addFirst(new Location(token[3]));

				Dlist.addLocation(token[4], d.Llist);
				d.Llist.addMartyr(new Martyr(token[0],new Date(token[1]),Integer.parseInt(token[2]),new Location(token[3]),new District (token[4]),token[5]));
			}
		}
	}

	public void save(File file) {
		PrintWriter write ;

		try {
			write=new PrintWriter(file);


			DistrictNode Dis=Dlist.getFirst();
			write.print("Name,Date,Age,location,District,Gender");
			write.print("\n");

			for(int i=0;i<Dlist.getSize()+1;i++) {
				LocationNode Loc=Dis.Llist.first;
				for(int j=0;j<Dis.Llist.count+1;j++) {
					MartyrNode M=Loc.nextMaryer;
					for(int k=0;k<Loc.countMaryer;k++) {
						write.print(((Martyr)M.getData()).toString());
						write.print("\n");
						M=M.next;
					}
					Loc=Loc.next;
				}
				Dis=Dis.getNext();
			}
		} catch (Exception s) {

		}
	}

	public  BorderPane savePane(Stage primaryStage) {
		BorderPane root = new BorderPane();
		root.setStyle("-fx-background: #2b2d31");
		Button saveB=new Button("𝐒𝐀𝐕𝐄 𝐅𝐈𝐋𝐄",new ImageView(new Image("file:///D:/ANAS/UNIVARSITY/Second%20year/second%20symester/Data%20Structer/WorkSpace/Project_Phase_1/src/application/icons8-save-30.png",30,30,false,false)));

		saveB.setStyle("-fx-border-color:green;"
				+ "-fx-border-width:2;"+"-fx-text-fill: green");
		saveB.setAlignment(Pos.CENTER);
		root.setCenter(saveB);

		saveB.setOnAction(e->{
			FileChooser FC=new FileChooser() ;
			FC.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("ADD ALL", "*") );
			FC.setTitle("Save File");
			File fileSave = FC.showSaveDialog(primaryStage);

			if(fileSave!=null) {
				save( fileSave);

			}
		});

		return root;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
