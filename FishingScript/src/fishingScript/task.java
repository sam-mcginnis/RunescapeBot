package fishingScript;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;

public abstract class task <C extends ClientContext> extends ClientAccessor<C>{
    public task(C ctx){
        super(ctx);
    }
    public abstract boolean activate();
    
    public abstract void execute();  
}
