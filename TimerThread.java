class TimerThread extends Thread{
	public static void main(String[] args) {
		  TimerThread thread =  new TimerThread();
		 thread.setName("Timer");
		  thread.start();
	
	}
	@Override
	public void run(){
		try{
			 System.out.println(Thread.currentThread().getName() + " running...");
		for(int i = 0 ; ; i++){
			Thread.sleep(1000);
			System.out.print(i + "\r");
            }

		}catch(InterruptedException e){
			System.out.println("Exception occuered");

		}
	}
}