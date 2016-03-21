package com.avatar.rxjava.service.timer;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.UUID;

/**
 * 定时任务服务类
 * User: Bruce(zhelong0615@gmail.com)
 * Date: 2016-03-17
 * Time: 18:35
 */
public class TimerManager {

    // 定时任务ID对应的定时任务
    private Map<String, Timer> timerTasks;

    private static TimerManager instance;

    protected TimerManager() {
        timerTasks = new HashMap<>();
    }

    public static synchronized TimerManager getInstance() {
        if (instance == null) {
            instance = new TimerManager();
        }
        return instance;
    }

    public interface TimerTask {
        void onAction();
    }

    public String executePeriod(TimerManager.TimerTask timerTask, int delay, int intervalMillis) {
        if (timerTask == null) return null;
        String timerId = generateTimerId();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new java.util.TimerTask() {
            @Override
            public void run() {
                // You can add common operation here...
                timerTask.onAction();
            }
        }, delay, intervalMillis);
        timerTasks.put(timerId, timer);
        return timerId;
    }

    public void cancel(String timerId) {
        if (timerTasks.containsKey(timerId)) {
            Timer timer = timerTasks.remove(timerId);
            if (timer != null) {
                timer.cancel();
            }
        }
    }

    private String generateTimerId() {
        return UUID.randomUUID().toString();
    }
}
