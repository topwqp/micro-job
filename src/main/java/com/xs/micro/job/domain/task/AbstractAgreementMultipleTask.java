package com.xs.micro.job.domain.task;

import com.google.common.base.Stopwatch;
import com.xiangshang.elasticjob.lite.starter.job.AbstractMultipleSliceJob;
import com.xs.micro.job.domain.pojo.em.AgreementTaskType;
import com.xs.micro.job.domain.pojo.vo.AgreementTaskParamVo;
import io.elasticjob.lite.api.ShardingContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import java.util.List;

/**
 * 合同协议定时任务
 * @author guochaohui
 */
public abstract class AbstractAgreementMultipleTask extends AbstractMultipleSliceJob {

    protected final Logger LOG = LoggerFactory.getLogger(this.getClass());

    /**
     * 任务英文名称
     *
     * @return
     */
    abstract AgreementTaskType taskType();

    /**
     * 任务单条业务逻辑
     *
     * @param dataId
     * @param agreementTaskParamVo
     */
    abstract void doBusiness(int dataId, AgreementTaskParamVo agreementTaskParamVo);

    /**
     * 分页查询，每次查询数量
     *
     * @return
     */
    abstract int querySingleMaxCount();

    /**
     * 单条任务并发锁时间
     *
     * @return
     */
    abstract long lockAcquireSeconds();

    /**
     * 获取分页查询数据
     *
     * @param queryMaxCount
     * @param agreementTaskParamVo
     * @return
     */
    abstract List<Integer> getDataIdList(int queryMaxCount, AgreementTaskParamVo agreementTaskParamVo);

    /**
     * 是否到点自动执行任务
     * @return
     */
    abstract boolean isAutoRunTask();

    /**
     * 手动执行触发
     * @param shardingContext
     * @param agreementTaskParamVo
     */
    public void doManualRunTask(ShardingContext shardingContext, AgreementTaskParamVo agreementTaskParamVo) {
        Stopwatch sw = Stopwatch.createStarted();
        LOG.info("task ... start .... test");
        LOG.info("AgreementTask" + taskType().getDesc() + "任务开始");
    }

    /**
     * 定时任务触发
     * @param shardingContext
     */
    @Override
    @Async("asyncTaskExecutor")
    public void doTask(ShardingContext shardingContext) {
        if (!isAutoRunTask()) {
            LOG.info("禁止自动执行");
            return;
        }
        switch (taskType()) {
            // 执行往年签订任务，特殊处理，需要循环年份，年份从去年开始
            case FILE_SIGN_PREVIOUS_YEAR:

                break;
            // 执行当年数据
            case SIGN_APPLY:
                doBusiness(1,new AgreementTaskParamVo());
            case FILE_INIT:
            case FILE_SIGN_CURRENT_YEAR:
               break;
            // 执行签章文件是否存在校验
            case FILE_EXIST:
                break;
            case BATCH_DOWNLOAD:
                doBusiness(1,null);
                break;
            default:
                LOG.error("AgreementTask"+  taskType().getDesc() + "任务异常" + "不支持的任务类型");
                break;
        }
    }

}
