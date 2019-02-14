package weathercheckter.johnnyzhao.com.weathercheckter.project.network.schedulers

import io.reactivex.Scheduler

//scheduler说明:
//https://www.jianshu.com/p/12638513424f

interface BaseSchedulerProvider {

    /**
     * 用于CPU 密集型计算任务，即不会被 I/O 等操作限制性能的耗时操作，例如xml,json文件的解析，Bitmap图片的压缩取样等，具有固定的线程池，
     * 大小为CPU的核数。
     * 不可以用于I/O操作，因为I/O操作的等待时间会浪费CPU。
     * */
    fun computation(): Scheduler

    /**
     * 用于IO密集型的操作，例如读写SD卡文件，查询数据库，访问网络等，具有线程缓存机制，在此调度器接收到任务后，
     * 先检查线程缓存池中，是否有空闲的线程，如果有，则复用，如果没有则创建新的线程，并加入到线程池中，如果每次都没有空闲线程使用，
     * 可以无上限的创建新线程。
     * */
    fun io(): Scheduler

    fun ui(): Scheduler
}