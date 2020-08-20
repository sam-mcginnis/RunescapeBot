package fishingScript;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;



@Script.Manifest(name ="MFFS", description = "My First Fishing Script")
public class Polling extends PollingScript<ClientContext>{
    
    private List<task> taskList = new ArrayList<task>();
    
    public static void main(String args[])
    {
        
    }
    @Override 
    public void start(){
        taskList.addAll(Arrays.asList(new fish(ctx), new drop(ctx)));
        
    }
    
    
    @Override
    public void poll()
    {
        for(task Task :taskList){
            if(Task.activate()){
                Task.execute();
            }
        }
    }
}
