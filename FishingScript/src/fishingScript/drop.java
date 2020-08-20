package fishingScript;

import org.powerbot.script.rt4.Item;
import org.powerbot.script.rt4.ClientContext;

public class drop extends task<ClientContext> {
    
    private int fishID = 317;
    
    public drop(ClientContext ctx){
        super(ctx);
    }
    
    @Override
    public boolean activate ()
    {
        return ctx.inventory.select().count() == 28;
    }
    
    @Override
    public void execute()
    {
        for(Item i : ctx.inventory.id(fishID))
        {
            i.interact("Drop");
        }
    }
}

