import java.util.concurrent.Phaser;
import java.util.concurrent.ThreadLocalRandom;
public class PhaserPhasedExecution{
static class Worker implements Runnable{
private final Phaser phaser;
private final String name;
private final int phases;
Worker(Phaser phaser,String name,int phases){
this.phaser=phaser;
this.name=name;
this.phases=phases;
}
public void run(){
try{
for(int phase=0;phase<phases;phase++){
doWorkForPhase(phase);
System.out.printf("[%s] completed phase %d, waiting...%n",name,phase);
phaser.arriveAndAwaitAdvance();
System.out.printf("[%s] proceeding to next phase (after %d).%n",name,phase);
}
}finally{
phaser.arriveAndDeregister();
System.out.printf("[%s] finished all phases and deregistered.%n",name);
}
}
private void doWorkForPhase(int phase){
int delay=ThreadLocalRandom.current().nextInt(200,700);
try{
System.out.printf("[%s] working on phase %d (will take %d ms)%n",name,phase,delay);
Thread.sleep(delay);
}catch(InterruptedException e){
Thread.currentThread().interrupt();
}
}
}
public static void main(String[] args)throws InterruptedException{
final int numWorkers=3;
final int phases=4;
Phaser phaser=new Phaser(numWorkers){
protected boolean onAdvance(int phase,int registeredParties){
System.out.printf("-- Phase %d completed. Registered parties: %d --%n",phase,registeredParties);
return registeredParties==0;
}
};
System.out.printf("Starting with %d workers and %d phases.%n",numWorkers,phases);
for(int i=1;i<=numWorkers;i++){
Thread t=new Thread(new Worker(phaser,"Worker-"+i,phases));
t.start();
}
while(!phaser.isTerminated()){
Thread.sleep(200);
if(phaser.getRegisteredParties()==0)break;
}
System.out.println("All phases completed. Main exiting.");
}
}
