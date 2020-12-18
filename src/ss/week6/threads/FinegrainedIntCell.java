package ss.week6.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FinegrainedIntCell implements IntCell {
    private int value = 0;
    private boolean isConsumed = true;
    final Lock lock = new ReentrantLock();
    final Condition consumed = lock.newCondition(); 
    final Condition notConsumed = lock.newCondition(); 
   
	@Override
	public void setValue(int val) {
		lock.lock();
        
        while (!isConsumed) {
            try {
				notConsumed.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }

        value = val;
        isConsumed = false;

        // Notify consumers
        consumed.signal();
        lock.unlock();
	}

	@Override
	public int getValue() {
        lock.lock();
        
        while (isConsumed) {
            try {
				consumed.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
		
        isConsumed = true;

        notConsumed.signal();
        lock.unlock();
		return value;
	}
    
}
