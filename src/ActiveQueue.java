import java.util.Stack;

/**
 * ActiveQueue定义，其实就是一个producer/consumer队列
 * 用来存放调用者请求
 * @author sunxboy
 *
 */
public class ActiveQueue {
	private Stack _queue;
	static final int QUEUE_SIZE = 20;
	
	public ActiveQueue(){
        _queue = new Stack();
    }

	public synchronized void enqueue(MethodRequest mr){
		 while(_queue.size() > QUEUE_SIZE) {
	            try{
	                   wait();
	            }catch (InterruptedException e){
	                   e.printStackTrace();
	            }
	        }

	        _queue.push(mr);
	        notifyAll();
	        System.out.println("Leave Queue");

	}
	
	 public synchronized MethodRequest dequeue(){
	        MethodRequest mr;

	        while(_queue.empty()){
	            try{
	                wait();
	            }catch (InterruptedException e){
	                e.printStackTrace();
	            }
	        }
	        mr = (MethodRequest)_queue.pop();
	        notifyAll();

	    return mr;
	    }

}
