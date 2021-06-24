package com.melon.apk.netty;


import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class NettyListener implements ApplicationListener<ContextRefreshedEvent> {
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        if (contextRefreshedEvent.getApplicationContext().getParent() == null) {
            try {
                new Thread() {
                    @Override
                    public void run() {
                        super.run();
                        new NettyServer().start(8066);
                    }
                }.start();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
