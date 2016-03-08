package mp1;

/**
 *
 * @author Furton
 */
public class Instructions {
    int lineNum;
    char operation;
    String[] indexes;
    
    Instructions(){
        this.lineNum = -1;
        this.operation = '\0';
        this.indexes = null;
    }
    Instructions(int line, String operation, String[] index){
        this.lineNum = line;
        this.operation = operation.charAt(0);
        this.indexes = index;
    }
    
    public void setLineNum(int i){
        this.lineNum = i;
    }
    
    public void setOperation(String o){
        this.operation = o.charAt(0);
    }
    
    public void setIndexes(String[] ind){
        this.indexes = ind;
    }
}
