import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

class Member { 

String forename;
String surname;
double distance;

}

 class Main {
  public static void main(String[] args) {
 
 Member [] memberList = new Member [20];
 String fileName = "members.txt";


 memberList = readFromClassList(fileName);

  }

public static Member[] readFromClassList (String nameOfFile) {
Scanner fileScanner = null;

Member [] tempMember = new Member [20];

int index = 0;

try {
fileScanner = new Scanner (new BufferedReader (new FileReader (nameOfFile)));
fileScanner.useDelimiter("[\\r\\n,]+");
while (fileScanner.hasNext()) {
tempMember[index] = new Member();
tempMember[index].forename = fileScanner.next();
tempMember[index].surname = fileScanner.next();
tempMember[index].distance = fileScanner.nextDouble();
index = index + 1;
}
}
catch (FileNotFoundException error ) {
  System.out.println("File not found, fix the code and try again");
} 
finally{
if(fileScanner!=null){
fileScanner.close();
} 
}
return tempMember;
}

public static double furthest (Member [] memberList) {

double furthest = memberList[0].distance;
for(int i = 0; i < 20; i ++){
if(memberList[i].distance < furthest){
furthest = memberList[i].distance; 
}
} 
System.out.println(furthest + " is the furthest distance walked."); 

return furthest;

 }

public static void file (Member [] memberList, furthest) throws IOException{

String content1 = "The prize winning members are.";
int prizeNumber = furthest * 0.7;
String content2 = "The number of whole marathons walked by each member is.";
double marathon = 0;

String fileName = "results.txt";

File writeFile = new File (fileName);

if(!writeFile.exists()) {
  writeFile.createNewFile();
}

FileWriter fw = new FileWriter(writeFile.getAbsoluteFile());
BufferedWriter bw = new BufferedWriter(fw);

bw.write(content1);
bw.write("\n");
for(int loop = 0; loop < 20; loop ++){
 if (memberList[loop].distance > prizeNumber){
 bw.write(memberList[loop].forename + "\n");
 bw.write(memberList[loop].surname + "\n"); 
}
}
bw.write(content2);
bw.write("\n");
for(int index = 0; index < 20; index ++){
  marathon = Math.round(memberList[index].distance/26.22);
  bw.write(memberList[index].forename + "\n");
  bw.write(memberList[index].surname + "\n");
  bw.write(marathon + "\n");
}

bw.newLine();

bw.close();
}
 }
  
  

