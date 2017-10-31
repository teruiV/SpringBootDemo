package com.frank.chapter64.job.simple;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import com.frank.chapter64.domain.Foo;
import com.frank.chapter64.repository.FooRepository;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author jianweilin
 * @date 2017/10/31
 */
public class SpringSimpleJob implements SimpleJob{

    @Resource
    private FooRepository fooRepository;

    @Override
    public void execute(ShardingContext shardingContext) {
        System.out.println(String.format("Item: %s | Time: %s | Thread: %s | %s",
                shardingContext.getShardingItem(), new SimpleDateFormat("HH:mm:ss").format(new Date()), Thread.currentThread().getId(), "SIMPLE"));
        List<Foo> data = fooRepository.findTodoData(shardingContext.getShardingParameter(), 10);
        for (Foo each : data) {
            fooRepository.setCompleted(each.getId());
        }
    }
}
