package mp1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author Furton
 */
public class mp1 {

    public static void main(String[] args) throws IOException{
        ArrayList <String> instructions = new ArrayList<>();
        ArrayList <Instructions> insArray = new ArrayList<>();
        
        FileWriter fw = new FileWriter("MP1.out");
        
        FileInputStream read_file = new FileInputStream("C://mp1.in");
	BufferedReader br = new BufferedReader(new InputStreamReader(read_file));
 
	String line;
        String register = br.readLine();
        
        //storing the values in the register to an array
        String[] strArray=register.split(" ");
        int[] registerArray = new int[strArray.length];
        
        //parsing the initial values in the register into int
        for(int i=0; i<strArray.length; i++){
            registerArray[i] = Integer.parseInt(strArray[i]);
        }
        
        //storing the instructions in an arraylist as a whole string
	while ((line = br.readLine()) != null) {
		instructions.add(line);
	}
        
        System.out.println(java.util.Arrays.toString(registerArray));
        fw.write(java.util.Arrays.toString(registerArray) + "\n");
        
        //creating instructions objects and storing in an arraylist
        for(int i =0; i<instructions.size() ; i++){
            String[] temp = instructions.get(i).split(" ");
            Instructions ins = new Instructions();
            ins.setLineNum(i+1);
            ins.setOperation(temp[0]);
            String[] tmp = Arrays.copyOfRange(temp, 1, temp.length);
            ins.setIndexes(tmp);
            insArray.add(ins);
        }
        
        //printing the instructions
        for(int i=0; i<insArray.size();i++){
            System.out.println(insArray.get(i).lineNum + "\t" + insArray.get(i).operation + "\t" + java.util.Arrays.toString(insArray.get(i).indexes));
        }
        
        int c=0;
        String[] tmp;
        while(c<insArray.size()){
            if(insArray.get(c).operation == 'J'){
                tmp = insArray.get(c).indexes;
                if(registerArray[Integer.parseInt(tmp[0])] == registerArray[Integer.parseInt(tmp[1])]){
                    c = (Integer.parseInt(tmp[2]))-1;
                }
                else{
                    c++;
                }
                System.out.println(java.util.Arrays.toString(registerArray));
                fw.write(java.util.Arrays.toString(registerArray) + "\n");
            }
            
            if(insArray.get(c).operation == 'S'){
                tmp = insArray.get(c).indexes;
                registerArray[Integer.parseInt(tmp[0])] = (registerArray[Integer.parseInt(tmp[0])]) +1;
                System.out.println(java.util.Arrays.toString(registerArray));
                c++;
                fw.write(java.util.Arrays.toString(registerArray) + "\n");
            }
            
            if(insArray.get(c).operation == 'C'){
                tmp = insArray.get(c).indexes;
                registerArray[Integer.parseInt(tmp[1])] = registerArray[Integer.parseInt(tmp[0])];
                System.out.println(java.util.Arrays.toString(registerArray));
                c++;
                fw.write(java.util.Arrays.toString(registerArray) + "\n");
            }
            
            if(insArray.get(c).operation == 'Z'){
                tmp = insArray.get(c).indexes;
                registerArray[Integer.parseInt(tmp[0])] = 0;
                System.out.println(java.util.Arrays.toString(registerArray));
                c++;
                fw.write(java.util.Arrays.toString(registerArray) + "\n");
            }
        }
        br.close();
        fw.close();
    }
}
