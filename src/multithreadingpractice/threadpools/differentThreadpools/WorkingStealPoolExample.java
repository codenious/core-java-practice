package multithreadingpractice.threadpools.differentThreadpools;

import java.util.concurrent.*;

public class WorkingStealPoolExample  {

    public static void main(String[] args) {

        //ExecutorService executor = Executors.newWorkStealingPool();
        ForkJoinPool executor = ForkJoinPool.commonPool();

        Future<Integer> future = executor.submit(new ComputeSumTask(0, 100));

        try{
            int result = future.get();
            System.out.println(result);
        } catch (InterruptedException | ExecutionException e){
            throw new RuntimeException(e);
        }

    }
}

class ComputeSumTask extends  RecursiveTask<Integer>{

    int start;
    int end;

    ComputeSumTask(int start, int end){
        this.start = start;
        this.end = end;
    }



    @Override
    protected Integer compute() {
        int totalSum = 0;
        if(end - start <= 4){
            for(int i = start; i <= end; i++){
                totalSum += i;
            }

            return totalSum;
        } else {
            int mid = (start + end )/2;
            ComputeSumTask leftTask = new ComputeSumTask(start, mid);
            ComputeSumTask rightTask = new ComputeSumTask(mid+1, end);

            leftTask.fork();
            rightTask.fork();

            int leftResult = leftTask.join();
            int rightResult = rightTask.join();

            return leftResult + rightResult;
        }


    }
}
