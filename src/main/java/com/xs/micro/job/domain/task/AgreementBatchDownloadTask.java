package com.xs.micro.job.domain.task;

import com.google.common.collect.Lists;
import com.xiangshang.elasticjob.lite.starter.annotation.ElasticSimpleJob;
import com.xs.micro.job.domain.pojo.em.AgreementTaskType;
import com.xs.micro.job.domain.pojo.vo.AgreementTaskParamVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 合同协议签章文件信息初始化task
 *
 * @author guochaohui
 */
@ElasticSimpleJob(
        appName = "${spring.application.name}",
        jobClass = AgreementBatchDownloadTask.class,
        cron = "5 * * * * ?",
        shardingTotalCount = "2",
        description = "合同协议微服务-批量下载定时",
        needWarn = false,
        warnMobiles = {"13534523334"}
)
@Service("agreementBatchDownloadTask")
public class AgreementBatchDownloadTask extends AbstractAgreementMultipleTask {
   private static final Logger LOG = LoggerFactory.getLogger(AgreementBatchDownloadTask.class);


    @Override
    void doBusiness(int dataId, AgreementTaskParamVo agreementTaskParamVo) {
        LOG.info("agreementBatchDownloadTask  doBusiness ...................................");
    }

    /**
     * 处理批次数据
     *
     * @param batchNo
     * @return
     * @author guochaohui
     * @date 2020-12-25 18:22
     */
    private void doBatch(String batchNo) {

    }

    @Override
    AgreementTaskType taskType() {
        return AgreementTaskType.BATCH_DOWNLOAD;
    }


    @Override
    int querySingleMaxCount() {
        return 4;
    }

    @Override
    long lockAcquireSeconds() {
        return 600;
    }

    @Override
    List<Integer> getDataIdList(int queryMaxCount, AgreementTaskParamVo agreementTaskParamVo) {
        return Lists.newArrayList(1);
    }

    @Override
    boolean isAutoRunTask() {
        return true;
    }

}
