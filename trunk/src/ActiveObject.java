/**
 * 封装了并发逻辑的活动对象 
 * @author sunxboy
 *
 */
public class ActiveObject extends Thread {
	private ActiveQueue _queue;
	   
	public ActiveObject(){
        _queue = new ActiveQueue();
        start();
    }

    public void enqueue(MethodRequest mr){
        _queue.enqueue(mr);
    }

    public void run(){
        while(true){
            MethodRequest mr = _queue.dequeue();
            mr.call();
        }
    }
}
