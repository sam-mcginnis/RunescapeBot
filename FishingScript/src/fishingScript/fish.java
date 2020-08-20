package fishingScript;

import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

/*@Script.Manifest(name="fishing",
            description="a shrimp fishing bot!",
            properties="client=6; topic=123456789; author= sam;")
*/

public class fish extends task<ClientContext>
{
    private int[] spotIDs = {332};
    
    public fish(ClientContext ctx)
    {
        super(ctx);
    }
    
    @Override
    public boolean activate()
    {
        return ctx.inventory.select().count() < 24 && !ctx.objects.select().id(spotIDs).isEmpty()
                &&ctx.players.local().animation() == -1;
    }
    
    @Override
    public void execute(){
        
        GameObject fish = ctx.objects.nearest().poll();
        if(fish.inViewport()){
            fish.interact("Fish");
        }
        else{
            ctx.movement.step(fish);
            ctx.camera.turnTo(fish);
        }
    }
}

