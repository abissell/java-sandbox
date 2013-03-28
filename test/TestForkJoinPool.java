import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class TestForkJoinPool {

	@Test
	public void testMain() throws InterruptedException {
		runExecutor(20);
		runForkJoin(20);
	}

	private void runForkJoin(int size) {
		ForkJoinPool fjp = new ForkJoinPool();
		long start = System.currentTimeMillis();
		fjp.invoke(new ForkJoinTask(size));
		System.out.println("ForkJoin Time: "
				+ (System.currentTimeMillis() - start));
		System.out.println("ForkJoin pool size=" + fjp.getPoolSize());
		System.out.println("ForkJoin parallelism level=" + fjp.getParallelism());
		fjp.shutdown();
	}

	public void runExecutor(int size) throws InterruptedException {
		ExecutorService exec = Executors.newFixedThreadPool(4);
		CountDownLatch latch = new CountDownLatch(size);
		long start = System.currentTimeMillis();
		for (int i = 0; i < latch.getCount(); i++) {
			exec.submit(new RunnableTask(latch));
		}
		latch.await();
		System.out.println("Executor Time: "
				+ (System.currentTimeMillis() - start));
		exec.shutdown();
	}

	class ForkJoinTask extends RecursiveTask {
		private List<RecursiveTask> tasks;
		private int size;

		public ForkJoinTask(int size) {
			super();
			this.tasks = new ArrayList<>();
			this.size = size;
		}

		@Override
		protected Object compute() {
			for (int i = 0; i < size; i++) {
				RecursiveTask task = new RecursiveTask() {
					@Override
					protected Object compute() {
						try {
							Thread.sleep(1000);
						} catch (Exception e) {

						}
						return null;
					}
				};
				task.fork();
				tasks.add(task);
			}

			for (RecursiveTask task : tasks) {
				task.join();
			}
			return null;
		}
	}

	class RunnableTask implements Runnable {
		private CountDownLatch latch;

		public RunnableTask(CountDownLatch latch) {
			this.latch = latch;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(1000);
				latch.countDown();
			} catch (Exception e) {
			}
		}
	}
}
